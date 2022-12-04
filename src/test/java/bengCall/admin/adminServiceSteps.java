package bengCall.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import java.io.File;

import static bengCall.admin.adminAPI.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class adminServiceSteps {
    @Given("Set view all service information as admin with valid token and {int}")
    public void setViewAllServiceInformationAsAdminWithValidTokenAndId(int id){
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("id",id);
    }

    @When("Send request get all service information")
    public void sendRequestGetAllServiceInformation() {
        SerenityRest.when()
                .get(GET_ALL_SERVICE_TYPE_ADMIN);
    }
    @When("Send request get invalid service information")
    public void sendRequestGetInvalidServiceInformation() {
        SerenityRest.when()
                .get(GET_ALL_SERVICE_TYPE_ADMIN_SPEC_CHARACTER);
    }

    @Then("Response API should return {int} OK")
    public void responseAPIShouldReturnOK(int arg0) {
        SerenityRest.then()
                .statusCode(arg0);
    }

    @And("Validate json schema")
    public void validateJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema"+"/adminService.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Json response contain message {string}")
    public void jsonResponseContainMessage(String arg0) {
        SerenityRest.then()
                .body(responseAdmin.MESSAGE, equalTo(arg0));
    }

    @Given("Set view all service information as admin with invalid {}")
    public void setViewAllServiceInformationAsAdminWithInvalidId(String id) {
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("character",id);
    }

    @And("Validate invalid json schema")
    public void validateInvalidJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminServiceInvalid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Then("Response API should return {int} Internal Server Error")
    public void responseAPIShouldReturnNotFound(int arg0) {
        SerenityRest.then()
                .statusCode(arg0);
    }

    @Given("Set create new service with valid request body")
    public void setCreateNewServiceWithValidRequestBody() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminNewServiceType.json");
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @When("Send request create new service")
    public void sendRequestCreateNewService() {
        SerenityRest.when()
                .post(POST_CREATE_SERVICE_ADMIN);
    }

    @Then("Response API should return {int} Created")
    public void responseAPIShouldReturnCreated(int arg0) {
        SerenityRest.then()
                .statusCode(arg0);
    }

    @And("Validate creat new service type json schema")
    public void validateCreatNewServiceTypeJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminNewServiceType.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Json response contain {}  {}  {}  {}")
    public void jsonResponseContainIdService_namePriceVehicle_id(int id, String service, int price, int vId) {
        SerenityRest.then()
                .body(responseAdmin.ID,equalTo(id))
                .body(responseAdmin.SERVICE_NAME,equalTo(service))
                .body(responseAdmin.Price,equalTo(price))
                .body(responseAdmin.VEHICLE_ID,equalTo(vId));
    }

}
