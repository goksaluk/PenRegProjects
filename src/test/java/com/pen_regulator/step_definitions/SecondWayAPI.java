package com.pen_regulator.step_definitions;

import com.pen_regulator.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


import com.pen_regulator.pages.UsersAPI;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SecondWayAPI {

    Response response;
    UsersAPI usersAPI =new UsersAPI();

    @Test
    public void test() {
        RestAssured.baseURI = ConfigurationReader.get("BaseURI");

        response = given().accept(ContentType.JSON).
                queryParams("page", "3").
                when().
                get(ConfigurationReader.get("users_endpoint"));

        List<Map<String, Object>> userData = new ArrayList<>();
        Map<String, Object> userList = response.jsonPath().get();
        userData = (List<Map<String, Object>>) userList.get("data");
        System.out.println("userData = " + userData);

        Map<String, Object> relatedUser = new HashMap<>();
        for (int i = 0; i < userData.size(); i++) {
            if (userData.get(i).get("id").equals(Integer.parseInt("7"))) {
                relatedUser.put("first_name", userData.get(i).get("first_name"));
                relatedUser.put("last_name", userData.get(i).get("last_name"));
                relatedUser.put("avatar", userData.get(i).get("avatar"));
            }
            response.then().
                    assertThat().statusCode(200).
                    body("id", is("7")).
                    body("email", is("michael.lawson@reqres.in")).
                    body("first_name", is("Michael")).
                    body("last_name", is("Lawson")).
                    body("avatar", is("https://reqres.in/img/faces/7-image.jpg"));


        }
    }
}
