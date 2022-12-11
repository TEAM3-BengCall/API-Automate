package bengCall.admin;

import bengCall.APIAndResponse.BengCallAPI;
import bengCall.APIAndResponse.BengCallResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class LoginAdminStepdefs {

    @Steps
    methodAdminAPI adminLoginAPI;

    //Login Admin with Valid data
    @Given("User login with valid data file json")
    public void UserLoginWithValidDataFileJson(){
        File json = new File(BengCallAPI.JSON_REQ_BODY_ADMIN + "/LoginAdminRequestBodyJson.json");
        adminLoginAPI.ValidLoginAdmin(json);
    }

    @When("Send Request admin login")
    public void SendRequestAdminLogin() {
        SerenityRest.when().post(BengCallAPI.POST_LOGIN_ADMIN);
    }

    @Then("Status code {int} Accepted")
    public void statusCodeAccepted(int Accepted) {
        SerenityRest.then().statusCode(Accepted);
    }

    @And("Login response body should contain full name {string} role {int} massage {string}")
    public void loginResponseBodyShouldContainFullNameRoleMassage(String fullname, int role, String massage) {
        SerenityRest.then().body(BengCallResponse.FULL_NAME, equalTo(fullname))
                .body(BengCallResponse.ROLE, equalTo(role))
                .body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validate Login successful json schema")
    public void validateLoginSuccesfullJsonSchema() {
        File json = new File(BengCallAPI.JSON_SCHEMA_VAL_ADMIN + "/LoginAdminJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Login Admin With Valid data
    @Given("User login with invalid data file json")
    public void userLoginWithInvalidDataFileJson() {
        File json = new File(BengCallAPI.JSON_REQ_BODY_ADMIN + "/LoginAdminWithInvalidDataRequestBodyJson.json");
        adminLoginAPI.InvalidLoginAdmin(json);
    }

    @Then("Status code {int} Bad request")
    public void statusCodeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

    @And("Response body should contain massage {string}")
    public void responseBodyShouldContainMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validate Login admin unsucess json schema")
    public void validateLoginAdminUnsucessJsonSchema() {
        File json = new File(BengCallAPI.JSON_SCHEMA_VAL_ADMIN + "/InvalidAdminJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //invalid Path Login Admin
    @When("Send Request invalid path admin login")
    public void sendRequestInvalidPathAdminLogin() {
        SerenityRest.when().post(BengCallAPI.INVALID_LOGIN_ADMIN);
    }

    @Then("Status code {int} not found")
    public void statusCodeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("invalid path Response body should contain massage {string}")
    public void invalidPathResponseBodyShouldContainMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validate login admin invalid path")
    public void validateLoginAdminInvalidPath() {
        File json = new File(BengCallAPI.JSON_SCHEMA_VAL_ADMIN + "/LoginAdminInvalidPathJsonSchmaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Login without email
    @Given("Json File body Without email")
    public void jsonFileBodyWithoutEmail() {
        File json = new File(BengCallAPI.JSON_REQ_BODY_ADMIN + "/LoginAdminWithoutEmailRequestBodyJson.json");
        adminLoginAPI.loginAdminWithoutEmail(json);
    }

    @And("response body without email should contain massage {string}")
    public void responseBodyWithoutEmailShouldContainMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validate json path without email")
    public void validateJsonPathWithoutEmail() {
        File json = new File(BengCallAPI.JSON_SCHEMA_VAL_ADMIN + "/InvalidAdminJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Login admin without password
    @Given("Json File body Without password")
    public void jsonFileBodyWithoutPassword() {
        File json = new File(BengCallAPI.JSON_REQ_BODY_ADMIN + "/LoginAdminWithoutPasswordRequestBodyJson.json");
        adminLoginAPI.loginAdminWithoutPassword(json);
    }


    @And("response body without password should contain massage {string}")
    public void responseBodyWithoutPasswordShouldContainMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validate json path without password")
    public void validateJsonPathWithoutPassword() {
        File json = new File(BengCallAPI.JSON_SCHEMA_VAL_ADMIN + "/InvalidAdminJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
