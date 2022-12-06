package bengCall.admin;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class AdminLoginAPI {

    //Login Admin with valid data
    @Step("Valid Login admin")
    public void ValidLoginAdmin(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //Login Admin with invalid data
    @Step("invalid login admin")
    public void InvalidLoginAdmin(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);

    }

    //Login Admin without email
    @Step("Login admin without email")
    public void loginAdminWithoutEmail(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //Login Admin without password
    @Step("Login admin without password")
    public void loginAdminWithoutPassword(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
