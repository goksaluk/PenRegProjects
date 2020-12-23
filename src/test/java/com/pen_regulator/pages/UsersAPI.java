package com.pen_regulator.pages;

import com.pen_regulator.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UsersAPI {

    Response response;

    public void setTheRequest(){
        RestAssured.baseURI = ConfigurationReader.get("BaseURI");
    }

    public void sendTheRequest(String endPoint, int pageNumber){
        response=given().accept(ContentType.JSON).
                         queryParams("page" ,pageNumber).
                 when().
                         get(ConfigurationReader.get(endPoint));
    }

    public int getStatusCode(){
        return response.statusCode();
    }


    //To get users
    List<Map<String,Object>> userData = new ArrayList<>();
    public void getTheUsers(){

       // Map<String,Object> userList = response.body().as(Map.class);
        Map<String,Object> userList = response.jsonPath().get();
        userData = (List<Map<String, Object>>) userList.get("data");
        System.out.println("userData = " + userData);
    }

    public Map<String, Object> getRelatedUserData(String id ){

        Map<String, Object> relatedUser = new HashMap<>();
        for(int i=0; i<userData.size();i++) {
            if (userData.get(i).get("id").equals(Integer.parseInt(id))) {
                relatedUser.put("first_name", userData.get(i).get("first_name"));
                relatedUser.put("last_name", userData.get(i).get("last_name"));
                relatedUser.put("avatar", userData.get(i).get("avatar"));
            }
        }
        return relatedUser;

    }





}
