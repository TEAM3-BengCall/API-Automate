package bengCall.admin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class AdminLoginAPI {
    public static final String BASE_URL = "http://project-edu.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR + "/src/test/resources/JsonFile";
    public static final String JSON_REQ_BODY = JSON_FILE + "/JsonRequestBody/Admin/Login";
    public static final String JSON_SCHEMA_VAL = JSON_FILE + "/JsonSchemaValidation/Admin/Login";


    public static final String POST_LOGIN_ADMIN = BASE_URL + "/login";


    public static final String VALID_ADMIN_TOKEN = "Bearer ";
    public static final String INVALID_ADMIN_TOKEN = "Bearer ";


    //Login Admin
    @Step("Login admin")
    public void LoginAdmin(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
