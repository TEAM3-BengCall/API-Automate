package bengCall.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class LoginAdminStepdefs {

    @Steps
    AdminLoginAPI adminLoginAPI;

    //Login Admin with Valid data
    @Given("User login with file json")
    public void UserLoginWithFileJson(){
        File json = new File(AdminLoginAPI.JSON_REQ_BODY + "/LoginAdminRequestBodyJson.json");
        adminLoginAPI.LoginAdmin(json);
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

    @And("Validate Login successfully json schema")
    public void validateLoginSuccesfullJsonSchema() {
        File json = new File(AdminLoginAPI.JSON_SCHEMA_VAL + "/LoginAdminJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }




}
