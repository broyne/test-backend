package com.virgingames.cucumber.steps;

import com.virgingames.virgingamesinfo.VirginGamesSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasValue;


public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    VirginGamesSteps steps;

    @When("User sends a GET request to jackpots bingo endpoint")
    public void userSendsAGETRequestToJackpotsBingoEndpoint() {
        response = steps.getAllJackpotsBingo();
    }

    @Then("User must get back a valid status code {int} as per the {string}")
    public void userMustGetBackAValidStatusCodeAsPerThe(int status, String currency) {
        response.statusCode(status);
    }


    @When("User sends a GET request to jackpots endpoint")
    public void userSendsAGETRequestToJackpotsEndpoint() {
        response = steps.getAllJackpotsBingo();
    }

    @Then("User must get back a valid status code {int} as per{string}")
    public void userMustGetBackAValidStatusCodeAsPer(int statusCode, String currency) {
        HashMap<String,Object> currencyList = steps.getThecurrencyMultipleData(currency);
        Assert.assertThat(currencyList, hasValue(currency));
    }
}
