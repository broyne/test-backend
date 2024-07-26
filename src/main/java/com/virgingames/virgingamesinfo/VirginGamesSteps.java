package com.virgingames.virgingamesinfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;



public class VirginGamesSteps {

    @Step("Getting all the Jackpots Bingo by currency")
    public ValidatableResponse getAllJackpotsBingo(){
        return SerenityRest.given()
                .when()
                .queryParam("currency", "GBP")
                .get(EndPoints.GET_ALL_BINGO)
                .then().log().ifError().statusCode(200);

    }

    @Step ("Getting the currency of GBP")
    public HashMap<String,Object> getThecurrencyMultipleData(String currency){
        String s1 = "data.pots.findAll{it.currency == '";
        String s2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .queryParam("currency", currency)
                .when()
                .get(EndPoints.GET_ALL_BINGO)
                .then().statusCode(200)
                .extract()
                .path(s1 + currency + s2);
    }


}
