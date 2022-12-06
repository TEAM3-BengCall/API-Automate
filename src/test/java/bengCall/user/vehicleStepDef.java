package bengCall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class vehicleStepDef {

    //Scenario 1
    @Given("Get vehicle type available with valid token")
    public void getVehicleTypeAvailableWithValidToken() {
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + userAPI.VALID_TOKEN);
    }

    @When("Send request get vehicle type valid path")
    public void sendRequestGetVehicleTypeValidPath() {
        SerenityRest.when()
                .get(userAPI.CUSTOMER_VEHICLES_VALID_PATH);
    }

    @And("API should return body data data.id {int}, data.name_vehicle {string} and message {string}")
    public void apiShouldReturnBodyDataDataIdDataName_vehicleAndMessage(int id, String vehicle, String message) {
        SerenityRest.then()
                .body(responseUser.DATA_ID,equalTo(id))
                .body(responseUser.DATA_NAME_VEHICLE,equalTo(vehicle))
                .body(responseUser.MESSAGE,equalTo(message));;
    }
    @And("Validate get vehicle type available success to json schema")
    public void validateGetVehicleTypeAvailableSuccessToJsonSchema() {
        File jsonFile = new File(userAPI.JSON_FILE+"/jsonSchema/user/getVehicleType.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    //Scenario 2
    @When("Send request get vehicle type invalid path")
    public void sendRequestGetVehicleTypeInvalidPath() {
        SerenityRest.when()
                .get(userAPI.CUSTOMER_VEHICLES_INVALID_PATH);
    }

    //Scenario 3
    @Given("Get vehicle type available with expired token")
    public void getVehicleTypeAvailableWithExpiredToken() {
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + userAPI.EXPIRED_TOKEN);
    }

}
