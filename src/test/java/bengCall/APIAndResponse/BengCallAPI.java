package bengCall.APIAndResponse;

public class BengCallAPI {
    public static final String BASE_URL = "https://project-edu.online";

    //Folder
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR + "/src/test/resources/JsonFile";
    public static final String JSON_REQ_BODY_ADMIN = JSON_FILE + "/JsonRequestBody/Admin/Login";
    public static final String JSON_SCHEMA_VAL_ADMIN = JSON_FILE + "/JsonSchemaValidation/Admin/Login";
    public static final String JSON_SCHEMA_VAL_USER = JSON_FILE + "/JsonSchemaValidation/User/ServiceVehicle";

    //URL Login
    public static final String POST_LOGIN_ADMIN = BASE_URL + "/login";
    public static final String INVALID_LOGIN_ADMIN = BASE_URL + "/logi";

    //URL USER SERVICE
    public static final String SERVICE_VEHICLE_USER = BASE_URL + "/service/{id}";
    public static final String SERVICE_VEHICLE_WITHOUT_ID = BASE_URL + "/service";
    public static final String SERVICE_VEHICLE_WITH_INVALID_PATH = BASE_URL + "/servicee/{id}";

    //TOKEN
    public static final String VALID_USER_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY5ODI4NjI2LCJpZCI6MTcxLCJyb2xlIjowfQ.9L8bv-rWr5vHnFyYHDMyCnQfsiXDboWE249gktGqtrE";
    public static final String INVALID_USER_TOKEN = "Bearer JhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY5ODI4NjI2LCJpZCI6MTcxLCJyb2xlIjowfQ.9L8bv-rWr5vHnFyYHDMyCnQfsiXDboWE249gktGqtrE";

}
