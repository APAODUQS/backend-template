package com.steps;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class BackEndSteps {

    String URL;
    HttpResponse response;

    @Given("^the service: (.*)$")
    public void setService(String url) {
        System.out.println("The service: " + url);
        URL = url;
    }

    @When("^the user does a (.*) petition$")
    public void callService(String petition) throws UnirestException {
        System.out.println("The user does a " + petition + " petition");
        response = Unirest.get(URL)
                .header("Accept", "application/json")
                .asString();
        System.out.println("The Response is: " + response);
        System.out.println("The Body is: " + response.getBody());
    }

    @Then("^the response is (\\d+)$")
    public void getResponse(Integer code) {
        Integer codeResponse = response.getStatus();
        Assert.assertEquals(code, codeResponse);
        System.out.println("The response is " + code);
    }

}
