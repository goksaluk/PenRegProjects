package com.pen_regulator.step_definitions;

import com.pen_regulator.pages.UsersAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class UsersStepDefs {

    UsersAPI usersAPI = new UsersAPI();

    @Given("I set REST API url")
    public void i_set_REST_API_url() {
        usersAPI.setTheRequest();
    }

    @Then("I send the request to {string} with page {int}")
    public void iSendTheRequestToWithPage(String endPoint, int pageNumber) {
        usersAPI.sendTheRequest(endPoint, pageNumber);
    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = usersAPI.getStatusCode();
        Assert.assertEquals(expectedStatusCode,actualStatusCode);
    }

    @And("I get the list of Users")
    public void iGetTheListOfUsers() {
        usersAPI.getTheUsers();
    }

    @Then("verify that related {string} have below {string} , {string} and {string}")
    public void verifyThatRelatedHaveBelowAnd(String id, String first_name, String last_name, String avatar) {

        Map<String, Object> userInfo = usersAPI.getRelatedUserData(id);
        System.out.println("userInfo = " + userInfo);
        Assert.assertEquals(first_name,userInfo.get("first_name"));
        Assert.assertEquals(last_name,userInfo.get("last_name"));
        Assert.assertEquals(avatar,userInfo.get("avatar"));

    }

}