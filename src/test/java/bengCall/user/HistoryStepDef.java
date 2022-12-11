package bengCall.user;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class HistoryStepDef {

    @Steps BengcallAPI bengcallAPIuser;
    //Scenario 1
    @Given("Get history with valid token")
    public void getsHistoryWithValidToken() {
        bengcallAPIuser.getHistoryValidToken();
    }

    @When("send History request  with valid path")
    public void sendRequestHistoryValidPath() {
        SerenityRest.when().get(BengcallAPI.POST_HISTORY_VALID_PATH);
    }

    @And("Response Api should return {int} OK")
    public void getServiceHistoryResponseBody(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @When("Validation Json Schema History Success")
    public void validationJson() {
        File json = new File(BengcallAPI.JSON_SCHEMA+"/user/HistorySuccessJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("response body {string}")
    public void responseBody(String arg0) {
        SerenityRest.then().body(BangCallResponse.Massage,equalTo(arg0));
    }


    //Scenario 2

    @Given("Get  history with valid token")
    public void getHistoryWithValidToken() {
        bengcallAPIuser.getHistoryValidToken();
    }

    @When("send request with invalid path")
    public void sendRequestWithInvalidPath() {
        SerenityRest.when().get(BengcallAPI.POST_HISTORY_INVALID_PATH);

    }
    @Then("Response Api should return {int} Not Found")
    public void responseApiShouldReturnNotFound(int arg0) {
        SerenityRest.then().statusCode(arg0);
    }

    @And("Validation Json Schema History Not Found")
    public void validationJsonSchemaHistoryNotFound() {
        File json = new File(BengcallAPI.JSON_SCHEMA+"/user/HistoryNotFoundSjsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario 3
    @Given("Get  history with expired token")
    public void getHistoryWithExpiredToken() {
        bengcallAPIuser.getHistoryExpiredToken();
    }

    @When("send request with valid path")
    public void sendRequestWithValidPath() {
        SerenityRest.when().get(BengcallAPI.POST_HISTORY_VALID_PATH);
    }
    @And("Validation Json Schema Expired Token")
    public void validationJsonSchemaExpiredToken() {
        File json = new File(BengcallAPI.JSON_SCHEMA+"/user/HistoryExpiredTokenJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Then("Response Api should return {int} Unauthorized")
    public void responseApiShouldReturnUnauthorized(int arg0) {
        SerenityRest.then().statusCode(arg0);
    }



}
