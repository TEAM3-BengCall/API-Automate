package bengCall.user;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class BengcallAPI {
    public static final String URL = "http://project-edu.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/jsonFile/jsonReqBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/jsonFile/jsonSchema";
    public static final String POST_REGISTER_USER_VALID_PATH = URL+"/register";
    public static final String POST_REGISTER_USER_INVALID_PATH = URL+"/registerr";
    public static final String POST_LOGIN_USER_VALID_PATH = URL+"/login";
    public static final String POST_LOGIN_USER_INVALID_PATH = URL+"/loginn";
    public static final String POST_HISTORY_VALID_PATH = URL+"/history";
    public static final String POST_HISTORY_INVALID_PATH = URL+"/historys";
    public static final String VALID_TOKEN ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY4NTcyOTY2LCJpZCI6MTU3LCJyb2xlIjowfQ.33J_Lm94hr_ArmgJhTOyKRImoAiVQ6kDRZcd2zDts3M";
    public static final String EXPIRED_TOKEN ="Bearer eyeeeerwJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3NzkyNzM2LCJpZCI6Miwicm9sZSI6MX0.bIdQ95WTl2ArvKn7RSptNgBBPZ08W2iPPJbxjefSRVE";


    @Step("Post register customer")
    public void postRegisterCustomer(File jsonFile){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }
    @Step("Post login customer")
    public void postLoginCustomer(File jsonFile){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }
    @Step("Get all service history with valid token")
    public void getHistoryValidToken(){
        SerenityRest.given()
                .header("Authorization",VALID_TOKEN);
    }

    @Step("Get all service history with expired token")
    public void getHistoryExpiredToken(){
        SerenityRest.given()
                .header("Authorization",EXPIRED_TOKEN);
    }


}

