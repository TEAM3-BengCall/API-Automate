package bengCall.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class commentStepDef {

    //Scenario 1
    @Given("Update comment user valid token and input id {int} and comment {string}")
    public void updateCommentUserValidTokenAndInputIdIdAndComment(int id, String comment) {
        SerenityRest.given().log().all()
                .header("Authorization","Bearer " + userAPI.VALID_TOKEN)
                .pathParam("id", id)
                .formParams("comment",comment);
    }

    @When("Send comment user put request valid path")
    public void sendCommentUserPutRequestValidPath() {
        SerenityRest.when()
                .put(userAPI.CUSTOMER_COMMENT_VALID_PATH);
    }

    @Then("API should return response {int} Created")
    public void apiShouldReturnResponseCreated(int created) {
        SerenityRest.then()
                .statusCode(created);
    }

    @And("API should return body data comment {string} and  message {string}")
    public void apiShouldReturnBodyDataCommentAndMessage(String comment, String message) {
        SerenityRest.then()
                .body(responseUser.COMMENT,equalTo(comment))
                .body(responseUser.MESSAGE,equalTo(message));
    }
    @And("Validate update comment user success to json schema")
    public void validateUpdateCommentUserSuccessToJsonSchema() {
        File jsonFile = new File(userAPI.JSON_FILE+"/jsonSchema/user/putCommentUser.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    //Scenario 2
    @Then("API should return response {int} Internal Server Error")
    public void apiShouldReturnResponseInternalServerError(int internalServerError) {
        SerenityRest.then()
                .statusCode(internalServerError);
    }

    //Scenario 3
    @When("Send comment user put request invalid path")
    public void sendCommentUserPutRequestInvalidPath() {
        SerenityRest.when()
                .put(userAPI.CUSTOMER_COMMENT_INVALID_PATH);
    }

    //Scenario 5
    @Given("Update comment user with expired token and input id {int} and comment {string}")
    public void updateCommentUserWithExpiredTokenAndInputIdIdAndComment(int id, String comment) {
        SerenityRest.given().log().all()
                .header("Authorization","Bearer " + userAPI.EXPIRED_TOKEN)
                .pathParam("id", id)
                .formParams("comment",comment);
    }

}
