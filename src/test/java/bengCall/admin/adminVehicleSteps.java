package bengCall.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static bengCall.admin.adminAPI.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class adminVehicleSteps {
    @Given("Set get all vehicle with valid token auth")
    public void setGetAllVehicleWithValidTokenAuth(){
        methodAdminAPI.loginValidTokenWithoutParam();
    }

    @When("Send request get all vehicle")
    public void sendRequestGetAllVehicle() {
        methodAdminAPI.sendGetAllVehicle();
    }

    @And("Validate all vehicle json schema")
    public void validateAllVehicleJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminVehicle/adminAllVehicle.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @Given("Set get all vehicle with invalid token auth")
    public void setGetAllVehicleWithInvalidTokenAuth() {
        methodAdminAPI.loginInvalidTokenWithoutParam();
    }

    @Given("Set create new vehicle type with valid request body")
    public void setCreateNewVehicleTypeWithValidRequestBody() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminVehicle/adminNewVehicle.json");
        methodAdminAPI.sendReqBodyWithValidToken(jsonFile);

    }

    @When("Send request create new vehicle type")
    public void sendRequestCreateNewVehicleType() {
        methodAdminAPI.sendPostVehicleType();
    }

    @And("Validate create new vehicle type json schema")
    public void validateCreateNewVehicleTypeJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminVehicle/adminNewVehicleType.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @And("Json response contain {string} and message {string}")
    public void jsonResponseContainAndMessage(String arg0, String arg1) {
        SerenityRest.then()
                .body(responseAdmin.NAME_VEHICLE,equalTo(arg0))
                .body(responseAdmin.MESSAGE,equalTo(arg1));
    }

    @Given("Set create new vehicle type with empty request body")
    public void setCreateNewVehicleTypeWithEmptyRequestBody() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminVehicle/adminInvalidNewVehicle.json");
        methodAdminAPI.sendReqBodyWithValidToken(jsonFile);
    }

    @And("Validate create invalid new vehicle type json schema")
    public void validateCreateInvalidNewVehicleTypeJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminTransaction/adminInvalidTransaction.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @And("Validate create new with invalid token auth json schema")
    public void validateCreateNewWithInvalidTokenAuthJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminTransaction/adminInvalidTransaction.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @Given("Set create new vehicle type with invalid token auth")
    public void setCreateNewVehicleTypeWithInvalidTokenAuth() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminVehicle/adminNewVehicle.json");
        methodAdminAPI.sendReqBodyWithInvalidToken(jsonFile);
    }

    @Given("Delete Vehicle type with valid id {int}")
    public void deleteVehicleTypeWithValidId(int arg0) {
        methodAdminAPI.loginValidTokenWithParam(arg0);
    }

    @When("Send request delete vehicle type")
    public void sendRequestDeleteVehicleType() {
        methodAdminAPI.sendDeleteVehicle();
    }

    @Given("Delete Vehicle type with invalid auth token and valid id {int}")
    public void deleteVehicleTypeWithInvalidAuthToken(int arg0) {
        methodAdminAPI.loginInvalidTokenWithParam(arg0);

    }
}
