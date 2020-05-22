package com.steps;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import cucumber.api.java.en.*;

public class BackEndSteps {

        String URL;

        @Given("^the service: (.*)$")
        public void setService (String url)  {
            System.out.println("The service: " + url);
            URL = url;
        }

        @When("^the user does a (.*) petition$")
        public void callService (String petition) throws UnirestException {
            System.out.println("The user does a " + petition + " petition");
            HttpResponse response = Unirest.get(URL)
                    .header("Accept", "application/json")
                    .asString();
            System.out.println("The Response is: " + response);
            System.out.println("The Body is: " + response.getBody());
            System.out.println("The Status Code is: " + response.getStatus());
        }

        @Then("^the response is (\\d+)$")
        public void getResponse (Integer code) {
            System.out.println("The response is " + code);
        }

}
