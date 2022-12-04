package bengCall.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static bengCall.admin.adminAPI.*;

public class adminVehicleServiceSteps {
    @Given("Get list vehicle service with valid token auth")
    public void getListVehicleServiceWithValidTokenAuth(){
        SerenityRest.given()
                .header("Authorization",VALID_ADMIN_TOKEN);
    }

    @When("Send request get vehicle service")
    public void sendRequestGetVehicleService() {
        SerenityRest.when()
                .get(GET_VEHICLESERVICE_ADMIN);
    }

    @And("Validate list vehicle service json schema")
    public void validateListVehicleServiceJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminVehicleService/adminVehicleService.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get list vehicle service with invalid token auth")
    public void getListVehicleServiceWithInvalidTokenAuth() {
        SerenityRest.given()
                .header("Authorization",INVALID_ADMIN_TOKEN);
    }
}
