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
        methodAdminAPI.loginValidTokenWithParam(id);
    }

    @When("Send request get all service information")
    public void sendRequestGetAllServiceInformation() {
        methodAdminAPI.sendGetAllServiceAdmin();
    }
    @When("Send request get invalid service information")
    public void sendRequestGetInvalidServiceInformation() {
        methodAdminAPI.sendGetInvalidServiceSpecCharacter();
    }

    @Then("Response API should return {int} OK")
    public void responseAPIShouldReturnOK(int arg0) {
        methodAdminAPI.statusCode(arg0);
    }

    @And("Validate json schema")
    public void validateJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminTransaction/adminInvalidTransaction.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @And("Json response contain message {string}")
    public void jsonResponseContainMessage(String arg0) {
        methodAdminAPI.countainMessage(arg0);
    }

    @Given("Set view all service information as admin with invalid {}")
    public void setViewAllServiceInformationAsAdminWithInvalidId(String id) {
        methodAdminAPI.loginValidTokenWithParamString(id);
    }

    @And("Validate invalid json schema")
    public void validateInvalidJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminService/adminServiceInvalid.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @Then("Response API should return {int} Internal Server Error")
    public void responseAPIShouldReturnNotFound(int arg0) {
        methodAdminAPI.statusCode(arg0);
    }

    @Given("Set create new service with valid request body")
    public void setCreateNewServiceWithValidRequestBody() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminService/adminNewServiceType.json");
        methodAdminAPI.sendReqBodyWithValidToken(jsonFile);
    }

    @When("Send request create new service")
    public void sendRequestCreateNewService() {
        methodAdminAPI.sendPostServiceAdmin();
    }

    @Then("Response API should return {int} Created")
    public void responseAPIShouldReturnCreated(int arg0) {
        methodAdminAPI.statusCode(arg0);
    }

    @And("Validate creat new service type json schema")
    public void validateCreatNewServiceTypeJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminService/adminNewServiceType.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
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
        methodAdminAPI.sendReqBodyWithValidToken(jsonFile);
    }

    @Then("Response API should return {int} Bad Request")
    public void responseAPIShouldReturnBadRequest(int arg0) {
        methodAdminAPI.statusCode(arg0);
    }

    @And("Validate invalid create json schema")
    public void validateCreateNewWithEmptyVehicleIdValueJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminService/adminServiceInvalid.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @And("Json response contain {string}")
    public void jsonResponseContainCannotBindInput(String message) {
        methodAdminAPI.countainMessage(message);
    }

    @Given("Set create new service with request body empty service name value")
    public void setCreateNewServiceWithRequestBodyEmptyServiceNameValue() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminService/adminNewServiceWithEmptyServiceNameValue.json");
        methodAdminAPI.sendReqBodyWithValidToken(jsonFile);
    }

    @Given("Set create new service with request body empty price value")
    public void setCreateNewServiceWithRequestBodyEmptyPriceValue() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminService/adminNewServiceWithEmptyPriceValue.json");
        methodAdminAPI.sendReqBodyWithValidToken(jsonFile);
    }

    @Given("Set create new service with empty request body")
    public void setCreateNewServiceWithEmptyRequestBody() {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminService/adminNewServiceWithEmptyValue.json");
        methodAdminAPI.sendReqBodyWithValidToken(jsonFile);
    }

    @Given("Set delete service type with valid parameter {int}")
    public void setDeleteServiceTypeWithValidParameterId(int id) {
        methodAdminAPI.loginValidTokenWithParam(id);
    }

    @When("Send request delete service type")
    public void sendRequestDeleteServiceType() {
        methodAdminAPI.sendDeleteService();
    }

    @Then("Response API should return {int} Accepted")
    public void responseAPIShouldReturnAccepted(int arg0) {
        methodAdminAPI.statusCode(arg0);
    }

    @And("Validate delete json schema")
    public void validateDeleteJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminService/adminServiceInvalid.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @Given("Set delete service type with invalid parameter")
    public void setDeleteServiceTypeWithInvalidParameterId() {
        methodAdminAPI.loginValidTokenWithoutParam();
    }

    @Then("Response API should return {int} Method Not Allowed")
    public void responseAPIShouldReturnMethodNotAllowed(int arg0) {
        methodAdminAPI.statusCode(arg0);
    }

    @When("Send request delete service type without parameter")
    public void sendRequestDeleteServiceTypeWithoutParameter() {
        methodAdminAPI.sendDeleteWithoutParam();
    }
}
