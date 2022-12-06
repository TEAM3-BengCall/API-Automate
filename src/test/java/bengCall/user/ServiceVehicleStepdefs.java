package bengCall.user;

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

public class ServiceVehicleStepdefs {

    @Steps
    ServiceCustomerAPI serviceCustomerAPI;

    //Get With valid id
    @Given("Get all vehicle service with valid id vehicle id {int}")
    public void getAllVehicleServiceWithValidIdVehicleIdId(int id) {
        serviceCustomerAPI.getServiceVehicleCustomerValidId(id);
    }

    @When("Send request service")
    public void sendRequestService() {
       SerenityRest.when().get(BengCallAPI.SERVICE_VEHICLE_USER);
    }

    @Then("Status code {int} OK")
    public void statusCodeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response service customer body should contain massage {string}")
    public void responseBodyShouldContainMassageAndVehicleIdVehicleId(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation get vehicle service with valid parameter id")
    public void validationGetVehicleServiceWithValidParameterId() {
        File json = new File(BengCallAPI.JSON_SCHEMA_VAL_USER + "/ServiceVehiclesUserJsonSchemaValidation.json");
    }


    //Get with invalid id
    @Given("Get all vehicle service with invalid id vehicle id {int}")
    public void getAllVehicleServiceWithInvalidIdVehicleIdId(int id) {
        serviceCustomerAPI.GetServiceVehicleCustomerInvalidId(id);
    }

    @When("Send request invalid path service")
    public void sendRequestInvalidPathService() {
        SerenityRest.when().get(BengCallAPI.SERVICE_VEHICLE_USER);
    }

    @Then("Status code {int} Internal Server Error")
    public void statusCodeInternalServerError(int InternalServerError) {
        SerenityRest.then().statusCode(InternalServerError);
    }

    @And("invalid id Response customer body should contain massage {string}")
    public void invalidIdResponseCustomerBodyShouldContainMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation Get Vehicle service with invalid parameter id")
    public void validationGetVehicleServiceWithInvalidParameterId() {
        File json = new File(BengCallAPI.JSON_SCHEMA_VAL_USER + "/ServiceVehicleInvalidUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get Service Customer withoud id
    @Given("Get vehicle service Without id")
    public void getVehicleServiceWithoutId() {
        serviceCustomerAPI.GetServiceVehicleCustomerWithoutId();
    }

    @When("Send path service without id")
    public void sendPathServiceWithoutId() {
        SerenityRest.when().get(BengCallAPI.SERVICE_VEHICLE_WITHOUT_ID);
    }

    @And("invalid id Response body should contain massage {string}")
    public void invalidIdResponseBodyShouldContainMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation Get Vehicle service without id")
    public void validationGetVehicleServiceWithoutId() {
        File json = new File(BengCallAPI.JSON_SCHEMA_VAL_USER + "/ServiceVehicleInvalidUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get vehicle service with invalid path
    @Given("get Vehicle service with invalid path and with id {int}")
    public void getVehicleServiceWithInvalidPath(int id) {
        serviceCustomerAPI.GetServiceVehicleCustomerWithInvalidPath(id);
    }

    @When("Send invalid path")
    public void sendInvalidPath() {
        SerenityRest.when().get(BengCallAPI.SERVICE_VEHICLE_WITH_INVALID_PATH);
    }

    @And("Validation Get vehicle service with invalid path")
    public void validationGetVehicleServiceWithInvalidPath() {
        File json = new File(BengCallAPI.JSON_SCHEMA_VAL_USER + "/ServiceVehicleInvalidUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get service customer with invalid token
    @Given("Vehicle service id with id {int} and invalid token")
    public void vehicleServiceIdWithIdAndInvalidToken(int id) {
        serviceCustomerAPI.getServiceVehicleCustomerWithInvalidToken(id);
    }

    @Then("Status code {int} Unauthorized")
    public void statusCodeUnauthorized(int Unauthorized) {
        SerenityRest.then().statusCode(Unauthorized);
    }

    @And("invalid token response body should contain massage {string}")
    public void invalidTokenResponseBodyShouldContainMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation Get Vehicle service with invalid token")
    public void validationGetVehicleServiceWithInvalidToken() {
        File json = new File(BengCallAPI.JSON_SCHEMA_VAL_USER + "/ServiceVehicleInvalidUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
