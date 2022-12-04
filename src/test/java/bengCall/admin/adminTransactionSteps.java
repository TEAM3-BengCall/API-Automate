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

public class adminTransactionSteps {
    @Given("Get transaction with valid parameter {int}")
    public void getTransactionWithValidParameterId(int id){
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("id",id);
    }

    @When("Send request get transaction")
    public void sendRequestGetTransaction() {
        SerenityRest.when()
                .get(GET_DETAIL_TRANSACTION_ADMIN);
    }

    @And("Validate single transaction json schema")
    public void validateSingleTransactionJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminTransaction/adminSingleTransaction.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get transaction with invalid parameter {long}")
    public void getTransactionWithInvalidParameterId(long id) {
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("id",id);
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
        SerenityRest.given()
                .header("Authorization", INVALID_ADMIN_TOKEN)
                .pathParam("id",id);
    }

    @Then("Response API should return {int} Unauthorized")
    public void responseAPIShouldReturnUnauthorized(int arg0) {
        SerenityRest.then()
                .statusCode(arg0);
    }

    @Given("Get All transaction with valid token auth")
    public void getAllTransactionWithValidTokenAuth() {
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN);
    }

    @When("Send request get all transaction")
    public void sendRequestGetAllTransaction() {
        SerenityRest.when()
                .get(GET_TRANSACTION_ADMIN_VALID_PATH);
    }

    @And("Validate get all transaction json schema")
    public void validateGetAllTransactionJsonSchema() {
        File jsonFile = new File(JSON_FILE+"/jsonSchema/adminTransaction/adminAllTransaction.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get all transaction with invalid token auth")
    public void getAllTransactionWithInvalidTokenAuth() {
        SerenityRest.given()
                .header("Authorization", INVALID_ADMIN_TOKEN);
    }

    @Given("Set put update transaction with valid {int}")
    public void setPutUpdateTransactionWithValidId(int id) {
        File jsonFile = new File(JSON_FILE+"/jsonReqBody/adminTransaction/adminUpdateTransaction.json");
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @When("Send request put transaction")
    public void sendRequestPutTransaction() {
        SerenityRest.when()
                .put(PUT_TRANSACTION_ADMIN);
    }

    @And("Validate update transaction json schema")
    public void validateUpdateTransactionJsonSchema() {
    }

    @Given("Set put update transaction with invalid token auth valid {int}")
    public void setPutUpdateTransactionWithInvalidTokenAuthValidId(int id) {
        SerenityRest.given()
                .header("Authorization", INVALID_ADMIN_TOKEN)
                .pathParam("id", id);
    }

    @Given("Set delete transaction with valid {int}")
    public void setDeleteTransactionWithValid(int arg0) {
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("id", arg0);
    }

    @When("Send request delete transaction")
    public void sendRequestDeleteTransaction() {
        SerenityRest.when()
                .delete(DELETE_CANCEL_TRANSACTION_ADMIN);
    }
}
