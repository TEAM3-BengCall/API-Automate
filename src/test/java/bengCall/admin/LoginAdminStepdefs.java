package bengCall.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class LoginAdminStepdefs {

    @Steps
    AdminLoginAPI adminLoginAPI;

    //Login Admin with Valid data
    @Given("User login with valid data file json")
    public void UserLoginWithValidDataFileJson(){
        File json = new File(AdminLoginAPI.JSON_REQ_BODY + "/LoginAdminRequestBodyJson.json");
        adminLoginAPI.ValidLoginAdmin(json);
    }

    @When("Send Request admin login")
    public void SendRequestAdminLogin() {
        SerenityRest.when().post(AdminLoginAPI.POST_LOGIN_ADMIN);
    }

    @Then("Status code {int} Accepted")
    public void statusCodeAccepted(int Accepted) {
        SerenityRest.then().statusCode(Accepted);
    }

    @And("Login response body should contain full name {string} role {int} massage {string}")
    public void loginResponseBodyShouldContainFullNameRoleMassage(String fullname, int role, String massage) {
        SerenityRest.then().body(AdminLoginResponse.FULL_NAME, equalTo(fullname))
                .body(AdminLoginResponse.ROLE, equalTo(role))
                .body(AdminLoginResponse.MASSAGE, equalTo(massage));
    }

    @And("Validate Login successful json schema")
    public void validateLoginSuccesfullJsonSchema() {
        File json = new File(AdminLoginAPI.JSON_SCHEMA_VAL + "/LoginAdminJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Login Admin With Valid data
    @Given("User login with invalid data file json")
    public void userLoginWithInvalidDataFileJson() {
        File json = new File(AdminLoginAPI.JSON_REQ_BODY + "/LoginAdminWithInvalidDataRequestBodyJson.json");
        adminLoginAPI.InvalidLoginAdmin(json);
    }

    @Then("Status code {int} Bad request")
    public void statusCodeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

    @And("Response body should contain massage {string}")
    public void responseBodyShouldContainMassage(String massage) {
        SerenityRest.then().body(AdminLoginResponse.MASSAGE, equalTo(massage));
    }

    @And("Validate Login admin unsucess json schema")
    public void validateLoginAdminUnsucessJsonSchema() {
        File json = new File(AdminLoginAPI.JSON_SCHEMA_VAL + "/InvalidAdminJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //invalid Path Login Admin
    @When("Send Request invalid path admin login")
    public void sendRequestInvalidPathAdminLogin() {
        SerenityRest.when().post(AdminLoginAPI.INVALID_LOGIN_ADMIN);
    }

    @Then("Status code {int} not found")
    public void statusCodeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("invalid path Response body should contain massage {string}")
    public void invalidPathResponseBodyShouldContainMassage(String massage) {
        SerenityRest.then().body(AdminLoginResponse.MASSAGE, equalTo(massage));
    }

    @And("Validate login admin invalid path")
    public void validateLoginAdminInvalidPath() {
        File json = new File(AdminLoginAPI.JSON_SCHEMA_VAL + "/LoginAdminInvalidPathJsonSchmaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Login without email
    @Given("Json File body Without email")
    public void jsonFileBodyWithoutEmail() {
        File json = new File(AdminLoginAPI.JSON_REQ_BODY + "/LoginAdminWithoutEmailRequestBodyJson.json");
        adminLoginAPI.InvalidLoginAdmin(json);
    }

    @And("response body without email should contain massage {string}")
    public void responseBodyWithoutEmailShouldContainMassage(String massage) {
        SerenityRest.then().body(AdminLoginResponse.MASSAGE, equalTo(massage));
    }

    @And("Validate json path without email")
    public void validateJsonPathWithoutEmail() {
        File json = new File(AdminLoginAPI.JSON_SCHEMA_VAL + "/InvalidAdminJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Login admin without password
    @Given("Json File body Without password")
    public void jsonFileBodyWithoutPassword() {
        File json = new File(AdminLoginAPI.JSON_REQ_BODY + "/LoginAdminWithoutPasswordRequestBodyJson.json");
        adminLoginAPI.loginAdminWithoutPassword(json);
    }


    @And("response body without password should contain massage {string}")
    public void responseBodyWithoutPasswordShouldContainMassage(String massage) {
        SerenityRest.then().body(AdminLoginResponse.MASSAGE, equalTo(massage));
    }

    @And("Validate json path without password")
    public void validateJsonPathWithoutPassword() {
        File json = new File(AdminLoginAPI.JSON_SCHEMA_VAL + "/InvalidAdminJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
