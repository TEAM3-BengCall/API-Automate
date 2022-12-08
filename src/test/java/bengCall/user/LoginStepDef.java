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

public class LoginStepDef {
    @Steps BengcallAPI bengcallAPIuser;
    @Given("post login with valid credentials")
    public void postLoginWithValidCredential() {
        File json = new File(BengcallAPI.JSON_REQ_BODY+"/RegiterPost.json");
        bengcallAPIuser.postLoginCustomer(json);
    } 
    @When("send post login request with valid path")
    public void sendPostLoginRequestWithValidPath() {
        SerenityRest.when().post(BengcallAPI.POST_LOGIN_USER_VALID_PATH);
    }
    @Then("Response Api should return {int} Accepted")
    public void responseApiShouldReturnAccepted(int Accept) {
        SerenityRest.then().statusCode(Accept);

    }
    @And("Validation Json Schema Succsess Login")
    public void validationJsonSchemaSuccsessLogin() {
        File json = new File(BengcallAPI.JSON_SCHEMA+"/LoginSuccessLoginJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Response body  {string}, fullname {string}, role {int}")
    public void responseBodyFullnameRole(String arg0, String arg1, int arg2) {
        SerenityRest.then().body(BangCallResponse.Massage,equalTo(arg0))
                .body(BangCallResponse.Data,equalTo(arg1))
                .body(BangCallResponse.Datarole,equalTo(arg2));
    }
//Scenario 2
    @Given("post login with email field is empty")
    public void postLoginWithEmailFieldIsEmpty() {
        File json = new File(BengcallAPI.JSON_REQ_BODY+"/loginEmailEmptBody.json");
        bengcallAPIuser.postLoginCustomer(json);
    }
    @When("send post request with valid path")
    public void sendPostRequestWithValidPath() {
        SerenityRest.when().post(BengcallAPI.POST_LOGIN_USER_VALID_PATH);
    }

    @Then("Response Api should return {int} Bad Request")
    public void responseApiShouldReturnBadRequest(int arg0) {
        SerenityRest.rest().then().statusCode(arg0);
    }
    @And("Validation Json Schema Login invalid")
    public void validationJsonSchemaLoginInvalid() {
        File json = new File(BengcallAPI.JSON_SCHEMA+"/LoginPasswordEmailEmptyJsonSchema.json.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Response body {string}")
    public void responseBody(String arg0) {
        SerenityRest.then().body(BangCallResponse.Massage,equalTo(arg0));
    }
//Scenario 3
    @Given("post login customer with Password field is empty")
    public void postLoginCustomerWithPasswordFieldIsEmpty() {
        File json = new File(BengcallAPI.JSON_REQ_BODY+"/LoginPasswordEmptyBody.json");
        bengcallAPIuser.postLoginCustomer(json);
    }
//Scenario 4
    @Given("post login customer without credentials")
    public void postLoginCustomerWithoutCredentials() {
        File json = new File(BengcallAPI.JSON_REQ_BODY+"/LoginWithoutCredentialBody.json");
        bengcallAPIuser.postLoginCustomer(json);
    }

    //Scenario 5
    @Given("post login customer with valid credentials")
    public void postLoginCustomerWithValidCredentials() {
        File json = new File(BengcallAPI.JSON_REQ_BODY+"/loginBody.json");
        bengcallAPIuser.postLoginCustomer(json);
    }
    @When("send post request with invalid path")
    public void sendPostRequestWithInvalidPath() {
        SerenityRest.when().post(BengcallAPI.POST_LOGIN_USER_INVALID_PATH);
    }
    @Then("Response Api should return  {int} Not Found")
    public void responseApiShouldReturnNotFound(int arg0) {
        SerenityRest.rest().then().statusCode(arg0);
    }

    @And("Validation Json Schema Login Not Found")
    public void validationJsonSchemaLoginNotFound() {
        File json = new File(BengcallAPI.JSON_SCHEMA+"/LoginNotFoundJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}
