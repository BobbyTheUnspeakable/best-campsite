package com.bestcampsite.bestcampsite.controllers;

import com.bestcampsite.bestcampsite.models.DAOs.UserDAO;
import com.bestcampsite.bestcampsite.models.RIDB.CAMPSITE;
import com.bestcampsite.bestcampsite.models.RIDB.RECDATA;
import com.bestcampsite.bestcampsite.models.RIDB.SEARCH_RESULTS;
import com.bestcampsite.bestcampsite.models.User.User;
import com.bestcampsite.bestcampsite.service.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Collection;

@Controller
@RequestMapping(value ="bestcampsite")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(Model model){
        String cookie = userCookie();
        model.addAttribute("user", cookie);
        model.addAttribute("loginStatus", checkLoginStatus(cookie));
        return "Login";
    }

    public User authUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUsername(authentication.getName());
        return user;
    }

    public String userCookie(){
        String cookie = "";
        User authUser = authUser();
        if(authUser != null){
            cookie = authUser.getUsername();
        }
        return cookie;
    }

    public boolean checkLoginStatus(String userCookie){
        boolean loggedInStatus = false;
        if(!userCookie.equals("")){
            loggedInStatus = true;
        }
        return loggedInStatus;
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.GET)
    public String createAccount(Model model){
       User user = new User();
        model.addAttribute(user);
       return "CreateAccount";
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){
        User existingUser = userService.findUserByUsername(user.getUsername());
        if(existingUser != null){
            bindingResult.rejectValue("username", "error.username",
                                    "There is already a user with that name.");
        }
        if(bindingResult.hasErrors()){
            return "CreateAccount";
        } else {
            userService.saveUser(user);
            model.addAttribute("user", new User());
            String cookie = userCookie();
            model.addAttribute("user", cookie);
            model.addAttribute("loginStatus", checkLoginStatus(cookie));
        }
        return "redirect:/bestcampsite/search";
    }
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model){
        return "Search";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String processSearch(Model model, String state, String keyword) throws IOException{

        SEARCH_RESULTS searchResults = readBySearchTerms(state, keyword);
        //Collection<CAMPSITE> searchResults = readByCampsiteID("https://ridb.recreation.gov//api//v1//facilities//234442//campsites//9816.json?&apikey=C8644A72609A4DFE80B4A35D177BB582");
        //RECDATA searchResults = readByFacilityID(234442);
        //model.addAttribute("searchResults", searchResults);

        return"Search";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model){
        return "Home";
    }

    public SEARCH_RESULTS readBySearchTerms(String state, String keyword) throws IOException {

        String baseURL = "https://ridb.recreation.gov/api/v1/facilities.json?activity=9&full=true&sort=name";
        String stateParam = "&state=";
        String queryParam = "&query=";
        String keyParam = "&apikey=C8644A72609A4DFE80B4A35D177BB582";
        String finalURL = "";
        Gson gson = new Gson();
        String facilityJsonDecoded = "";
        String facilityJson = "";

        if(state.equals("") && keyword.equals("")){
            //TODO send error
        }
        if(!state.equals("") && !keyword.equals("")){
            finalURL = baseURL + stateParam + state + queryParam + keyword + keyParam;
        }
        if(state.equals("") && !keyword.equals("")){
            finalURL = baseURL + queryParam + keyword + keyParam;
        }
        if(!state.equals("") && keyword.equals("")){
            finalURL = baseURL + stateParam + state + keyParam;
        }

        HttpsURLConnection ridbCall = (HttpsURLConnection) (new URL(finalURL)).openConnection();
        ridbCall.setRequestProperty("Content-Type", "application/json");
        ridbCall.setRequestProperty("Accept", "application/json");
        ridbCall.setRequestMethod("GET");
        ridbCall.connect();

        try {
            BufferedReader ridbReader = new BufferedReader(new InputStreamReader(ridbCall.getInputStream()));
            while ((facilityJsonDecoded=ridbReader.readLine()) != null){
                facilityJson+=facilityJsonDecoded;
            }
            ridbReader.close();
        } catch (Exception exception){
            exception.printStackTrace();
        }

        ridbCall.disconnect();

        SEARCH_RESULTS facilityResults = gson.fromJson(facilityJson, SEARCH_RESULTS.class);

        return facilityResults;
    }

    public RECDATA readByFacilityID(int facilityID) throws IOException {
        String baseURL = "https://ridb.recreation.gov/api/v1/facilities/";
        String endURL = ".json?full=true&apikey=C8644A72609A4DFE80B4A35D177BB582";
        Gson gson = new Gson();
        String facilityJsonDecoded = "";
        String facilityJson = "";

        HttpsURLConnection ridbCall = (HttpsURLConnection)
                (new URL(baseURL + facilityID + endURL)).openConnection();

        ridbCall.setRequestProperty("Content-Type", "application/json");
        ridbCall.setRequestProperty("Accept", "application/json");
        ridbCall.setRequestMethod("GET");
        ridbCall.connect();

        try {
            BufferedReader ridbReader = new BufferedReader(new InputStreamReader(ridbCall.getInputStream()));
            while ((facilityJsonDecoded = ridbReader.readLine()) != null) {
                facilityJson += facilityJsonDecoded;
            }
            ridbReader.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        ridbCall.disconnect();

        RECDATA facility = gson.fromJson(facilityJson, RECDATA.class);

        return facility;
    }

    public Collection<CAMPSITE> readByCampsiteID(String URL) throws IOException {
        String baseURL = "https://ridb.recreation.gov/api/v1/facilities/"; //TODO change URLs to CAMPSITE.ResourceLink
        String endURL = ".json?full=true&apikey=C8644A72609A4DFE80B4A35D177BB582";
        Gson gson = new Gson();
        String campsiteJsonDecoded = "";
        String campsiteJson = "";

        HttpsURLConnection ridbCall = (HttpsURLConnection)
                (new URL(URL)).openConnection();

        ridbCall.setRequestProperty("Content-Type", "application/json");
        ridbCall.setRequestProperty("Accept", "application/json");
        ridbCall.setRequestMethod("GET");
        ridbCall.connect();

        try {
            BufferedReader ridbReader = new BufferedReader(new InputStreamReader(ridbCall.getInputStream()));
            while ((campsiteJsonDecoded=ridbReader.readLine()) != null){
                campsiteJson+=campsiteJsonDecoded;
            }
            ridbReader.close();
        } catch (Exception exception){
            exception.printStackTrace();
        }

        ridbCall.disconnect();

        Type collectionType = new TypeToken<Collection<CAMPSITE>>(){}.getType();
        Collection<CAMPSITE> campsite = gson.fromJson(campsiteJson, collectionType);

        return campsite;
    }
}
