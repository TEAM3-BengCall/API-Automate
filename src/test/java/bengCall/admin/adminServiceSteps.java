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
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminTransaction/adminInvalidTransaction.json");
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
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminService/adminServiceInvalid.json");
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
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminService/adminNewServiceType.json");
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
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminService/adminNewServiceType.json");
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

    @Given("Set create new service with request body empty vehicle id value")
    public void setCreateNewServiceWithRequestBodyEmptyVehicleIdValue() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminService/adminNewServiceWithEmptyVehicleIdValue.json");
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Then("Response API should return {int} Bad Request")
    public void responseAPIShouldReturnBadRequest(int arg0) {
        SerenityRest.then()
                .statusCode(arg0);
    }

    @And("Validate invalid create json schema")
    public void validateCreateNewWithEmptyVehicleIdValueJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminService/adminServiceInvalid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Json response contain {string}")
    public void jsonResponseContainCannotBindInput(String message) {
        SerenityRest.then()
                .body(responseAdmin.MESSAGE,equalTo(message));
    }

    @Given("Set create new service with request body empty service name value")
    public void setCreateNewServiceWithRequestBodyEmptyServiceNameValue() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminService/adminNewServiceWithEmptyServiceNameValue.json");
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Given("Set create new service with request body empty price value")
    public void setCreateNewServiceWithRequestBodyEmptyPriceValue() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminService/adminNewServiceWithEmptyPriceValue.json");
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Given("Set create new service with empty request body")
    public void setCreateNewServiceWithEmptyRequestBody() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminService/adminNewServiceWithEmptyValue.json");
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Given("Set delete service type with valid parameter {int}")
    public void setDeleteServiceTypeWithValidParameterId(int id) {
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("id",id);
    }

    @When("Send request delete service type")
    public void sendRequestDeleteServiceType() {
        SerenityRest.when()
                .delete(DELETE_SERVICE_ADMIN);
    }

    @Then("Response API should return {int} Accepted")
    public void responseAPIShouldReturnAccepted(int arg0) {
        SerenityRest.then()
                .statusCode(arg0);
    }

    @And("Validate delete json schema")
    public void validateDeleteJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminService/adminServiceInvalid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Set delete service type with invalid parameter")
    public void setDeleteServiceTypeWithInvalidParameterId() {
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN);
    }

    @Then("Response API should return {int} Method Not Allowed")
    public void responseAPIShouldReturnMethodNotAllowed(int arg0) {
        SerenityRest.then()
                .statusCode(arg0);
    }

    @When("Send request delete service type without parameter")
    public void sendRequestDeleteServiceTypeWithoutParameter() {
        SerenityRest.when()
                .delete(DELETE_SERVICE_ADMIN_NO_ID);
    }
}
