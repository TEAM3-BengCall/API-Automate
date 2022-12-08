package bengCall.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static bengCall.admin.adminAPI.*;

public class adminTransactionSteps {
    @Given("Get transaction with valid parameter {int}")
    public void getTransactionWithValidParameterId(int id){
        methodAdminAPI.loginValidTokenWithParam(id);
    }

    @When("Send request get transaction")
    public void sendRequestGetTransaction() {
        methodAdminAPI.sendGetTransaction();
    }

    @And("Validate single transaction json schema")
    public void validateSingleTransactionJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminTransaction/adminSingleTransaction.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @Given("Get transaction with invalid parameter {long}")
    public void getTransactionWithInvalidParameterId(long id) {
        methodAdminAPI.loginValidTokenWithParamLongInt(id);
    }

    @Then("Response API should return {int} Not Found")
    public void responseAPIShouldReturnNotFound(int arg0) {
        SerenityRest.then()
                .statusCode(arg0);
    }

    @And("Validate invalid single transaction json schema")
    public void validateInvalidSingleTransactionJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminService/adminServiceInvalid.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get transaction with invalid token auth with parameter {int}")
    public void getTransactionWithInvalidTokenAuth(int id) {
        methodAdminAPI.loginInvalidTokenWithParam(id);
    }

    @Then("Response API should return {int} Unauthorized")
    public void responseAPIShouldReturnUnauthorized(int arg0) {
        methodAdminAPI.statusCode(arg0);
    }

    @Given("Get All transaction with valid token auth")
    public void getAllTransactionWithValidTokenAuth() {
        methodAdminAPI.loginValidTokenWithoutParam();
    }

    @When("Send request get all transaction")
    public void sendRequestGetAllTransaction() {
        methodAdminAPI.sendGetAllTransaction();
    }

    @And("Validate get all transaction json schema")
    public void validateGetAllTransactionJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminTransaction/adminAllTransaction.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @Given("Get all transaction with invalid token auth")
    public void getAllTransactionWithInvalidTokenAuth() {
        methodAdminAPI.loginInvalidTokenWithoutParam();
    }

    @Given("Set put update transaction with valid {int}")
    public void setPutUpdateTransactionWithValidId(int id) {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminTransaction/adminUpdateTransaction.json");
        methodAdminAPI.sendReqBodyWithValidTokenAndParam(id,jsonFile);
    }

    @When("Send request put transaction")
    public void sendRequestPutTransaction() {
        methodAdminAPI.sendPutTransaction();
    }

    @And("Validate update transaction json schema")
    public void validateUpdateTransactionJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminTransaction/adminUpdateTransaction.json");
        methodAdminAPI.validateJsonSchema(jsonFile);
    }

    @Given("Set put update transaction with invalid token auth valid {int}")
    public void setPutUpdateTransactionWithInvalidTokenAuthValidId(int id) {
        methodAdminAPI.loginInvalidTokenWithParam(id);
    }

    @Given("Set delete transaction with valid {int}")
    public void setDeleteTransactionWithValid(int arg0) {
        methodAdminAPI.loginValidTokenWithParam(arg0);
    }

    @When("Send request delete transaction")
    public void sendRequestDeleteTransaction() {
        methodAdminAPI.sendDeleteTransaction();
    }
}