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


public class RegisteStepDef {
    @Steps
    BengcallAPI bengcallAPIuser;

    @Given("post register customer with valid credential")
    public void postRegisterWithValidCredential() {
        File json = new File(BengcallAPI.JSON_REQ_BODY+"/RegiterPost.json");
        bengcallAPIuser.postRegisterCustomer(json);
    }
    @When("send register request with valid path")
    public void sendRegisterRequestWithValidPath() {
        SerenityRest.when().post(BengcallAPI.POST_REGISTER_USER_VALID_PATH);
    }
    @And("Validation Json Schema Register succsess")
    public void validationJsonSchemaRegister() {
        File json = new File(BengcallAPI.JSON_SCHEMA+"/PostRegiterSuccessJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Then("Response Api should return {int} Created")
    public void responseApiShouldReturnCreated(int Created) {
        SerenityRest.then().statusCode(Created);
    }
    @And("Response body {string}, email {string}")
    public void responseBodyEmail(String arg0, String arg1) {
        SerenityRest.then()
                .body(BangCallResponse.Data,equalTo(arg0))
                .body(BangCallResponse.Email,equalTo(arg1));
    }
    @And("message {string}")
    public void message(String arg0) {
        SerenityRest.then().body(BangCallResponse.Massage,equalTo(arg0));
    }
//Scenario 2
    @Given("post register customer with invalid password")
    public void postRegisterCustomerWithInvalidPassword() {
        File json = new File(BengcallAPI.JSON_REQ_BODY+"/RegisterPasswordLess8CharBody.json");
        bengcallAPIuser.postRegisterCustomer(json);
    }
    @And("Validation Json Schema Register Invalid")
    public void validationJsonSchemaRegisterInvalid() {
        File json = new File(BengcallAPI.JSON_SCHEMA+"/InvalidEmailPasswordRegisterJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Response body {string}")
    public void responseBody(String arg0) {
        SerenityRest.then().body(BangCallResponse.Massage,equalTo(arg0));
    }
//Scenario 3
    @Given("post register customer without credentials")
    public void postRegisterCustomerWithoutCredentials() {
        File json = new File(BengcallAPI.JSON_REQ_BODY+"/RegisterInvalidCredentialBody.json");
        bengcallAPIuser.postRegisterCustomer(json);
    }
    @When("send Register request with invalid path")
    public void sendRegisterRequestWithInvalidPath() {
        SerenityRest.when().post(BengcallAPI.POST_REGISTER_USER_INVALID_PATH);
    }
    @And("Validation Json Schema Not Found")
    public void validationJsonSchemaNotFound() {
        File json = new File(BengcallAPI.JSON_SCHEMA+"/RegisterNotFoundJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
// Scenario 4
    @Given("post register customer with one field mandatory is empty")
    public void postRegisterCustomerWithOneFieldMandatoryIsEmpty() {
        File json = new File(BengcallAPI.JSON_REQ_BODY+"/RegisterOneMandatoryEmptyBody.json");
        bengcallAPIuser.postRegisterCustomer(json);
    }
// Scenario 5
    @Given("post register customer with two field mandatory is empty")
    public void postRegisterCustomerWithTwoFieldMandatoryIsEmpty() {
        File json = new File(BengcallAPI.JSON_REQ_BODY+"/RegisterTwoMandatoryEmpty.json");
        bengcallAPIuser.postRegisterCustomer(json);
    }

}
