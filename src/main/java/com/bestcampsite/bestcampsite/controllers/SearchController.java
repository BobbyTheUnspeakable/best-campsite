package com.bestcampsite.bestcampsite.controllers;

import com.bestcampsite.bestcampsite.models.RIDB.CAMPSITE;
import com.bestcampsite.bestcampsite.models.RIDB.RECDATA;
import com.bestcampsite.bestcampsite.models.RIDB.SEARCH_RESULTS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Collection;

public class SearchController {

    private static String stateSearchURL = "https://ridb.recreation.gov/api/v1/facilities.json?activity=9&full=true&sort=name&state=";
    private static String nameSearchURL = "https://ridb.recreation.gov/api/v1/facilities.json?activity=9&full=true&query=";
    private static String keyParam = "&apikey=C8644A72609A4DFE80B4A35D177BB582";
    private static Gson gson = new Gson();
    private String state;
    private String searchTerm;
    private String facilityJsonDecoded;
    private String facilityJson;


    //@RequestMapping(value = "search")
    //public String search(Model model){
    //    return "Search";
    //}

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

    //TODO it works for now may need to change parameter from URL to facilityID and campsiteID
    public Collection<CAMPSITE> readByCampsiteID(String URL) throws IOException {
        String baseURL = "https://ridb.recreation.gov/api/v1/facilities/";
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
        Collection<CAMPSITE> campsiteResults = gson.fromJson(campsiteJson, collectionType);

        return campsiteResults;
    }

    @RequestMapping(value = "campground/{facilityId}", method = RequestMethod.GET)
    public String campground(Model model, @PathVariable int facilityId){
        return "Stuff";
    }

    /*
    So as far as searches go a User should be able to search facilities by;
    NAME: https://ridb.recreation.gov/api/v1/facilities.json?activity=9&full=true&query=akers
    STATE: https://ridb.recreation.gov/api/v1/facilities.json?activity=9&full=true&sort=name&state=MO
    If a result set is larger than 50 I'll have to append the request with the appropriate offset=50/100/150 etc.
    All api request will be ended with the param "&apikey=C8644A72609A4DFE80B4A35D177BB582"
    The last parameter in each request is what the user would put into the search bar

    Then no matter the search query I'll have to pull the FacilityID and use it for the next request
    which will be a link to the individual campground page
    CAMPGROUND: https://ridb.recreation.gov/api/v1/facilities/234442.json?full=true
                                                                ID^
    The returned object will have pertinent information about the campground
    it will also have embedded api requests for the individual campsites
    CAMPSITE: https://ridb.recreation.gov//api//v1//facilities//234442//campsites//9816.json

    Perhaps I should build a helper class(es) for JSON parsing?
    Have all my use cases for the search function in it:
        Search by State
        Search by Keyword
        Search by Both
    If I do go that route then the logic would look something like:
    if(state = "" && keyword = null) send an error message
    if(state != "" && keyword != null) send request with both query params
    if(state = "" && keyword != null) send request with keyword query
    if(state != "" && keyword = null) send request with state query
    I'll also most likely have to include a test on the metadata in order to offset large responses

    so long as there are no errors I'll have an array of FACILITY objects
    I can handle most of the looping for the table in thymeleaf and the things I'll need are:
    FacilityId, FacilityName, and eventually (hopefully) GEOJSON.

     */

}
