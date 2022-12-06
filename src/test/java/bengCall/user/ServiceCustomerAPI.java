package bengCall.user;

import bengCall.APIAndResponse.BengCallAPI;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;


public class ServiceCustomerAPI {

    @Steps
    BengCallAPI bangCallAPI;


    //Get service vehicle customer with valid parameter id
    @Step("Get service vehicle customer with valid parameter id")
    public void getServiceVehicleCustomerValidId (int id){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .pathParam("id", id);
    }

    //Get service vehicle customer with invalid parameter
    @Step("Get service vehicle customer with invalid parameter id")
    public void GetServiceVehicleCustomerInvalidId(int id){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .pathParam("id", id);
    }

    //Get service vehicle customer without id
    @Step("Get service vehicle customer without id")
    public void GetServiceVehicleCustomerWithoutId(){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN);
    }

    //Get service vehicle customer with invalid path
    @Step("Get service Vehicle with invalid path")
    public void GetServiceVehicleCustomerWithInvalidPath(int id){
        SerenityRest.given().header("Authorization", BengCallAPI.VALID_USER_TOKEN)
                            .pathParam("id", id);
    }

    //Get Service vehicle with invalid token
    @Step("Get Service vehicle customer with invalid token")
    public void getServiceVehicleCustomerWithInvalidToken(int id){
        SerenityRest.given().header("Authorization", BengCallAPI.INVALID_USER_TOKEN)
                            .pathParam("id", id);
    }
}
