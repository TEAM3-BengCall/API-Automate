package bengCall.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.File;

import static bengCall.admin.adminAPI.*;

public class adminVehicleServiceSteps {
    @Given("Get list vehicle service with valid token auth")
    public void getListVehicleServiceWithValidTokenAuth(){
        methodAdminAPI.loginValidTokenWithoutParam();
    }

    @When("Send request get vehicle service")
    public void sendRequestGetVehicleService() {
        methodAdminAPI.sendGetVehicleService();
    }

    @And("Validate list vehicle service json schema")
    public void validateListVehicleServiceJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminVehicleService/adminVehicleService.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @Given("Get list vehicle service with invalid token auth")
    public void getListVehicleServiceWithInvalidTokenAuth() {
        methodAdminAPI.loginInvalidTokenWithoutParam();
    }
}