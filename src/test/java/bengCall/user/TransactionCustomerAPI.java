package bengCall.user;

import bengCall.APIAndResponse.BengCallAPI;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class TransactionCustomerAPI {

    //Transaction user with valid path
    @Step("Create transaction with valid path")
    public void createTransactionWithValidPath(File json){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .contentType(ContentType.JSON).body(json);
    }

    //Transaction user with invalid location id
    @Step("Create transaction with invalid location id")
    public void createTransactionWithInvalidLocationId(File json){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .contentType(ContentType.JSON).body(json);
    }

    //Transaction user with invalid vehicle id
    @Step("Create transaction with invalid vehicle id")
    public void createTransactionWithInvalidVehicleId(File json){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .contentType(ContentType.JSON).body(json);
    }

    //Transaction user with invalid service id
    @Step("Create transaction with invalid service id")
    public void createTransactionWithInvalidServiceId(File json){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .contentType(ContentType.JSON).body(json);
    }

    //Create Transaction without date
    @Step("Create transaction without date")
        public void createTransactionWithoutDate(File json){
            SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                                .contentType(ContentType.JSON).body(json);
    }

    //Create Transaction without phone number
    @Step("Create transaction without phone number")
    public void createTransactionWithoutPhoneNumber(File json){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .contentType(ContentType.JSON).body(json);
    }

    //Create Transaction without address
    @Step("Create transaction without address")
    public void createTransactionWithoutAddress(File json){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .contentType(ContentType.JSON).body(json);
    }

    //Get on going transaction with valid parameter and valid token
    @Step("Get on going transaction with valid parameter and valid token")
    public void getTransactionWithValidParameterAndValidToken (){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN);
    }

    //Get ongoing transaction with invalid parameter id
    @Step("Get on going transaction with invalid parameter id")
    public void getTransactionWithInvalidParameterId (){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN);
    }

    //Get ongoing transaction with invalid token
    @Step("Get on going transaction with invalid token")
    public void getOnGoingTransactionWithInvalidToken(){
        SerenityRest.given().header("Authorization", BengCallAPI.INVALID_USER_TOKEN);
    }

    //Get detail transaction with valid parameter id
    @Step("Get detail transaction with valid parameter id")
    public void getDetailTransactionWithValidParameterID(int id){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .pathParam("id", id);
    }

    //Get detail transaction with valid parameter id
    @Step("Get detail transaction with invalid parameter id")
    public void getDetailTransactionWithInvalidParameterID(int id){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .pathParam("id", id);
    }

    //Get detail transaction with invalid token
    @Step("Get detail transaction with invalid token")
    public void getDetailTransactionWithInvalidToken(int id){
        SerenityRest.given().header("Authorization", BengCallAPI.INVALID_USER_TOKEN)
                            .pathParam("id", id);
    }

}
