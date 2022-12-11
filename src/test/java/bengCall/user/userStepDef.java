package bengCall.user;

import bengCall.user.responseUser;
import bengCall.user.userAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class userStepDef {

    @Given("Get user profile with valid token")
    public void getUserProfileWithValidToken() {
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + userAPI.VALID_TOKEN);
    }

    @When("Send request get customer user profile valid path")
    public void sendRequestGetCustomerProfileValidPath() {
        SerenityRest.when()
                .get(userAPI.CUSTOMER_PROFILE_VALID_PATH);
    }

    @Then("API should return response {int} OK")
    public void apiShouldReturnResponseOK(int OK) {
        SerenityRest.and().statusCode(OK);
    }

    @And("API should return body data fullname {string}, images {string}, email {string} and message {string}")
    public void apiShouldReturnBodyDataFullnameImagesEmailAndMessage(String fullname, String images, String email, String message) {
        SerenityRest.then()
                .body(responseUser.FULLNAME, equalTo(fullname))
                .body(responseUser.IMAGES, equalTo(images))
                .body(responseUser.EMAIL, equalTo(email))
                .body(responseUser.MESSAGE, equalTo(message));
    }

    @And("Validate get user profile success to json schema")
    public void validateGetUserProfileSuccessToJsonSchema() {
        File jsonFile = new File(userAPI.JSON_FILE+"/jsonSchema/user/getUser.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    //Scenario 2
    @Given("Get user profile with expired token")
    public void getUserProfileWithExpiredToken() {
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + userAPI.EXPIRED_TOKEN);
    }

    @And("API should return response {int} Unauthorized")
    public void apiShouldReturnResponseUnauthorized(int unauthorized) {
        SerenityRest.and()
                .statusCode(unauthorized);
    }

    @Then("API should return body message {string}")
    public void apiShouldReturnBodyMessage(String message) {
        SerenityRest.then()
                .body(responseUser.MESSAGE,equalTo(message));
    }

    @And("Validate message failed to json schema")
    public void validateMessageFailedToJsonSchema() {
        File jsonFile = new File(userAPI.JSON_FILE+"/jsonSchema/messageJsonSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    //Scenario 3
    @When("Send request get customer user profile invalid path")
    public void sendRequestGetCustomerUserProfileInvalidPath() {
        SerenityRest.when()
                .get(userAPI.CUSTOMER_PROFILE_INVALID_PATH);
    }

    @Then("API should return response {int} Not Found")
    public void apiShouldReturnResponseNotFound(int notFound) {
        SerenityRest.and()
                .statusCode(notFound);
    }

    //Scenario 4
    @Given("Update user profile valid token and input fullname {string}, email {string} and image")
    public void updateUserProfileValidTokenAndInputFullnameEmailAndImage(String fullname, String email) {
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + userAPI.VALID_TOKEN)
                .formParams("fullname",fullname)
                .formParams("email",email)
                .multiPart("images", new File("src/test/resources/jsonFile/jsonReqBody/user/Minionman.jpg"));
    }

    @When("Send update user put request valid path")
    public void sendUpdateUserPutRequestValidPath() {
        SerenityRest.when()
                .put(userAPI.CUSTOMER_PROFILE_VALID_PATH);
    }

    @Then("API should return response {int} Accepted")
    public void apiShouldReturnResponseAccepted(int accepted) {
        SerenityRest.and()
                .statusCode(accepted);
    }

    @And("API should return body data fullname {string}, email {string} and  message {string}")
    public void apiShouldReturnBodyDataFullnameEmailAndMessage(String fullname, String email, String message) {
        SerenityRest.then()
                .body(responseUser.FULLNAME, equalTo(fullname))
                .body(responseUser.EMAIL, equalTo(email))
                .body(responseUser.MESSAGE, equalTo(message));
    }

    @And("Validate update user profile success to json schema")
    public void validateUpdateUserProfileSuccessToJsonSchema() {
        File jsonFile = new File(userAPI.JSON_FILE+"/jsonSchema/user/putUser.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    //Scenario 5
    @Given("Update user profile without input body data")
    public void updateUserProfileWithoutInputBodyData() {
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + userAPI.VALID_TOKEN)
                .formParams("fullname","")
                .formParams("email","");
    }

    @Then("API should return response {int} Bad Request")
    public void apiShouldReturnResponseBadRequest(int badRequest) {
        SerenityRest.and()
                .statusCode(badRequest);
    }

    //Scenario 6
    @When("Send update user put request invalid path")
    public void sendUpdateUserPutRequestInvalidPath() {
        SerenityRest.when()
                .get(userAPI.CUSTOMER_PROFILE_INVALID_PATH);
    }

    //Scenario 7
    @Given("Update user profile with expired token")
    public void updateUserProfileWithExpiredToken() {
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + userAPI.EXPIRED_TOKEN)
                .formParams("fullname","Destiana Ayu Aulia")
                .formParams("email","destiana@gmail.com")
                .multiPart("images",new File("src/test/resources/jsonFile/jsonReqBody/user/Minionman.jpg"));
    }

    //Scenario 8
    @Given("Delete user profile with valid token")
    public void deleteUserProfileWithValidToken() {
        SerenityRest.given().log().all()
                .header("Authorization", "Bearer " + userAPI.VALID_TOKEN);
    }

    @When("Send request delete user profile valid path")
    public void sendRequestDeleteUserProfileValidPath() {
        SerenityRest.when()
                .delete(userAPI.CUSTOMER_PROFILE_VALID_PATH);
    }

    @And("Validate delete user profile success to json schema")
    public void validateDeleteUserProfileSuccessToJsonSchema() {
        File jsonFile = new File(userAPI.JSON_FILE+"/jsonSchema/user/deleteUser.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    //Scenario 9
    @When("Send request delete user profile invalid path")
    public void sendRequestDeleteUserProfileInvalidPath() {
        SerenityRest.when()
                .delete(userAPI.CUSTOMER_PROFILE_INVALID_PATH);
    }

    // Scenario 10
    @Given("Delete user profile with expired token")
    public void deleteUserProfileWithExpiredToken() {
        SerenityRest.given().log().all()
                .header("Authorization","Bearer " + userAPI.EXPIRED_TOKEN);
    }

}
