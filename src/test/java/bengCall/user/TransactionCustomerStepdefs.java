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
import static org.hamcrest.Matchers.in;


public class TransactionCustomerStepdefs {

    @Steps
    TransactionCustomerAPI transactionCustomerAPI;


    //Transaction with valid json body
    @Given("user create transaction with valid json")
    public void userCreateTransactionWithValidJson() {
        File json = new File(BengCallAPI.JSON_REQ_BODY_TRANSACTION + "/TransactionUserJsonFile.json");
        transactionCustomerAPI.createTransactionWithValidPath(json);
    }

    @When("Send request valid path transaction")
    public void sendRequestValidPathTransaction() {
        SerenityRest.when().post(BengCallAPI.TRANSACTION_USER);
    }

    @Then("Status code {int} Created")
    public void statusCodeCreated(int Created) {
        SerenityRest.then().statusCode(Created);
    }

    @And("response body valid path transaction massage {string}")
    public void responseBodyValidPathTransactionMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation Transaction valid path")
    public void validationTransactionValidPath() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/TransactionUserJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Transaction customer with invalid path
    @When("Send request invalid path transaction user")
    public void sendRequestInvalidPathTransactionUser() {
        SerenityRest.when().post(BengCallAPI.TRANSACTION_USER_INVALID_PATH);
    }

    @And("validation invalid path transaction user")
    public void validationInvalidPathTransactionUser() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/TransactionUserWithInvalidPathJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Transaction user with invalid location id
    @Given("user create transaction with invalid location id")
    public void userCreateTransactionWithInvalidLocationId() {
        File json = new File(BengCallAPI.JSON_REQ_BODY_TRANSACTION + "/TransactionwithInvalidLocationIdUserJsonFile.json");
        transactionCustomerAPI.createTransactionWithInvalidLocationId(json);
    }

    @And("response body with invalid location id massage {string}")
    public void responseBodyWithInvalidLocationIdMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation Transaction with invalid location id")
    public void validationTransactionWithInvalidLocationId() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/TransactionUserJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Create transaction with invalid vehicle id
    @Given("user create transaction with invalid vehicle id")
    public void userCreateTransactionWithInvalidVehicleId() {
         File json = new File(BengCallAPI.JSON_REQ_BODY_TRANSACTION + "/TransactionWithInvalidVehicleIdJsonFile.json");
         transactionCustomerAPI.createTransactionWithInvalidVehicleId(json);
    }

    @And("response body with invalid vehicle id massage {string}")
    public void responseBodyWithInvalidVehicleIdMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation Transaction with invalid vehicle id")
    public void validationTransactionWithInvalidVehicleId() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/TransactionUserJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Create transaction with invalid vehicle id
    @Given("user create transaction with invalid service id")
    public void userCreateTransactionWithInvalidServiceId() {
        File json = new File(BengCallAPI.JSON_REQ_BODY_TRANSACTION + "/TransactionWithInvalidServiceIdFileJson.json");
        transactionCustomerAPI.createTransactionWithInvalidServiceId(json);
    }

    @And("response body with invalid service id massage {string}")
    public void responseBodyWithInvalidServiceIdMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation Transaction with invalid service id")
    public void validationTransactionWithInvalidServiceId() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/TransactionUserJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Create transaction without date
    @Given("user create transaction without date")
    public void userCreateTransactionWithoutDate() {
        File json = new File(BengCallAPI.JSON_REQ_BODY_TRANSACTION + "/TransactionWithoutDateJsonFile.json");
        transactionCustomerAPI.createTransactionWithoutDate(json);
    }

    @And("response body without date massage {string}")
    public void responseBodyWithoutDateMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation Transaction without date")
    public void validationTransactionWithoutDate() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/TransactionUserInvalidJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Create transaction without phone number
    @Given("user create transaction without phone number")
    public void userCreateTransactionWithoutPhoneNumber() {
        File json = new File(BengCallAPI.JSON_REQ_BODY_TRANSACTION + "/TransactionWithoutPhoneNumberJsonFile.json");
        transactionCustomerAPI.createTransactionWithoutPhoneNumber(json);
    }

    @And("response body without phone number massage {string}")
    public void responseBodyWithoutPhoneNumberMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation Transaction without phone number")
    public void validationTransactionWithoutPhoneNumber() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/TransactionUserInvalidJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Create transaction without address
    @Given("user create transaction without address")
    public void userCreateTransactionWithoutAddress() {
        File json = new File(BengCallAPI.JSON_REQ_BODY_TRANSACTION + "/TransactionWithoutPhoneNumberJsonFile.json");
        transactionCustomerAPI.createTransactionWithoutAddress(json);
    }

    @And("response body without address massage {string}")
    public void responseBodyWithoutAddressMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation Transaction without address")
    public void validationTransactionWithoutAddress() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/TransactionUserInvalidJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get Transaction On Going
    @Given("User get on going transaction")
    public void userGetOnGoingTransaction() {
        transactionCustomerAPI.getTransactionWithValidParameterAndValidToken();
    }

    @When("send request valid path ongoing transaction")
    public void sendRequestValidPathOngoingTransaction() {
        SerenityRest.when().get(BengCallAPI.TRANSACTION_ON_GOING);
    }

    @And("response body on going transaction massage {string}, id {int} and invoice {int}")
    public void responseBodyOnGoingTransactionMassageIdAndInvoice(String massage, int id, int invoice) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage))
                .body(BengCallResponse.ID, equalTo((id)))
                .body(BengCallResponse.INVOICE, equalTo(invoice));
    }

    @And("Validation on going transaction")
    public void validationOnGoingTransaction() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/GetOnGoingJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get On Going trasaction with invalid id
    @Given("User get on going transaction with invalid id")
    public void userGetOnGoingTransactionWithInvalidId() {
        transactionCustomerAPI.getTransactionWithInvalidParameterId();
    }

    @When("send request invalid path ongoing transaction")
    public void sendRequestInvalidPathOngoingTransaction() {
        SerenityRest.when().get(BengCallAPI.TRANSACTION_ON_GOING_INVALID);
    }

    @And("response body on going transaction with invalid id massage {string}")
    public void responseBodyOnGoingTransactionWithInvalidIdMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation on going transaction with invalid parameter id")
    public void validationOnGoingTransactionWithInvalidParameterId() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/GetOnGoingJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get ongoing transaction with invalid token
    @Given("User get on going transaction with invalid token")
    public void userGetOnGoingTransactionWithInvalidToken() {
        transactionCustomerAPI.getOnGoingTransactionWithInvalidToken();
    }

    @And("response body on going transaction with invalid token massage {string}")
    public void responseBodyOnGoingTransactionWithInvalidTokenMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation on going transaction with invalid token")
    public void validationOnGoingTransactionWithInvalidToken() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/GetOnGoingJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get detail transaction with valid id
    @Given("User get detail on going transaction with valid id {int}")
    public void userGetDetailOnGoingTransactionWithValidId(int id) {
        transactionCustomerAPI.getDetailTransactionWithValidParameterID(id);
    }

    @When("Send request valid path detail transaction")
    public void sendRequestValidPathDetailTransaction() {
        SerenityRest.when().get(BengCallAPI.DETAIL_TRANSACTION);
    }

    @And("response body data with valid id massage {string}")
    public void responseBodyDataWithValidIdMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation detail transaction with valid id")
    public void validationDetailTransactionWithValidId() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/GetDetailTransactionWithValidIdJsonSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get detail transaction with invalid id
    @Given("Send request valid path transaction with invalid id {int}")
    public void sendRequestValidPathTransactionWithInvalidId(int id) {
        transactionCustomerAPI.getDetailTransactionWithInvalidParameterID(id);
    }

    @And("response body data with invalid id massage {string}")
    public void responseBodyDataWithInvalidIdMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation detail transaction with invalid id")
    public void validationDetailTransactionWithInvalidId() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/GetInvalidDetailTransactionUserJsonSchemaValidate.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Get detail transaction invalid token
    @Given("User get detail on going transaction with valid id {int} and invalid token")
    public void userGetDetailOnGoingTransactionWithValidIdAndInvalidToken(int id) {
        transactionCustomerAPI.getDetailTransactionWithInvalidToken(id);
    }

    @And("response get detail transaction with invalid token massage {string}")
    public void responseGetDetailTransactionWithInvalidTokenMassage(String massage) {
        SerenityRest.then().body(BengCallResponse.MASSAGE, equalTo(massage));
    }

    @And("Validation detail transaction with invalid token")
    public void validationDetailTransactionWithInvalidToken() {
        File json = new File(BengCallAPI.JSON_SCHEMA_TRANSACTION + "/GetDetailTransactionWithInvalidTokenValidJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
