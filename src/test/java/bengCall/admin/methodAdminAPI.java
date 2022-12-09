
package bengCall.admin;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static bengCall.admin.adminAPI.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class methodAdminAPI {
    static void statusCode(int arg0){
        SerenityRest.then()
                .statusCode(arg0);
    }
    static void loginValidTokenWithParam(int id){
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("id",id);
    }
    static void loginInvalidTokenWithParam(int id){
        SerenityRest.given()
                .header("Authorization", INVALID_ADMIN_TOKEN)
                .pathParam("id",id);
    }
    static void loginValidTokenWithParamString(String id){
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("id",id);
    }
    static void loginValidTokenWithParamLongInt(long id){
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("id",id);
    }
    static void loginInvalidTokenWithoutParam(){
        SerenityRest.given()
                .header("Authorization", INVALID_ADMIN_TOKEN);
    }
    static void loginValidTokenWithoutParam(){
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN);
    }
    static void sendReqBodyWithValidToken(File jsonFile){
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }
    static void sendReqBodyWithInvalidToken(File jsonFile){
        SerenityRest.given()
                .header("Authorization", INVALID_ADMIN_TOKEN)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }
    static void sendReqBodyWithValidTokenAndParam(int id, File jsonFile){
        SerenityRest.given()
                .header("Authorization", VALID_ADMIN_TOKEN)
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }
    static void sendGetAllServiceAdmin(){
        SerenityRest.when()
                .get(GET_ALL_SERVICE_TYPE_ADMIN);
    }
    static void sendGetInvalidServiceSpecCharacter(){
        SerenityRest.when()
                .get(GET_ALL_SERVICE_TYPE_ADMIN_SPEC_CHARACTER);
    }
    static void sendPostServiceAdmin(){
        SerenityRest.when()
                .post(POST_CREATE_SERVICE_ADMIN);
    }
    static void sendDeleteService(){
        SerenityRest.when()
                .delete(DELETE_SERVICE_ADMIN);
    }
    static void sendDeleteWithoutParam(){
        SerenityRest.when()
                .delete(DELETE_SERVICE_ADMIN_NO_ID);
    }
    static void sendGetTransaction(){
        SerenityRest.when()
                .get(GET_DETAIL_TRANSACTION_ADMIN);
    }
    static void sendGetAllTransaction(){
        SerenityRest.when()
                .get(GET_TRANSACTION_ADMIN_VALID_PATH);
    }
    static void sendPutTransaction(){
        SerenityRest.when()
                .put(PUT_TRANSACTION_ADMIN);
    }
    static void sendDeleteTransaction(){
        SerenityRest.when()
                .delete(DELETE_CANCEL_TRANSACTION_ADMIN);
    }
    static void sendGetVehicleService(){
        SerenityRest.when()
                .get(GET_VEHICLESERVICE_ADMIN);
    }
    static void sendGetAllVehicle(){
        SerenityRest.when()
                .get(GET_ALL_VEHICLE_ADMIN);
    }
    static void sendPostVehicleType(){
        SerenityRest.when()
                .post(POST_CREATE_VEHICLE_ADMIN);
    }
    static void sendDeleteVehicle(){
        SerenityRest.when()
                .delete(DELETE_SERVICE_ADMIN);
    }
    static void validateJsonSchema(File jsonFile){
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
    static void countainMessage(String arg0){
        SerenityRest.then()
                .body(responseAdmin.MESSAGE, equalTo(arg0));
    }
}
