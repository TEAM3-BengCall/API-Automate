package bengCall.admin;

public class adminAPI {
    public static final String BASE_URL = "https://project-edu.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR + "src/test/resources/jsonFile";
    public static final String POST_LOGIN_ADMIN = BASE_URL+"/login";
    public static final String GET_ALL_VEHICLE_ADMIN = BASE_URL+"/vehicle";
    public static final String GET_ALL_VEHICLE_ADMIN_INVALID_PATH = BASE_URL+"/vehicless";
    public static final String POST_CREATE_VEHICLE_ADMIN =BASE_URL +"/admin/vehicle";
    public static final String DELETE_VEHICLE_TYPE_ADMIN = BASE_URL+"/admin/vehicle/{id}";
    public static final String DELETE_VEHICLE_TYPE_ADMIN_NO_ID = BASE_URL+"/admin/vehicle";
    public static final String DELETE_VEHICLE_TYPE_ADMIN_SPEC_CHARACTER = BASE_URL+"/admin/vehicle/{character}";
    public static final String GET_ALL_SERVICE_TYPE_ADMIN = BASE_URL+"/service/{id}";
    public static final String GET_ALL_SERVICE_TYPE_ADMIN_SPEC_CHARACTER = BASE_URL + "/service/{character}";
    public static final String POST_CREATE_SERVICE_ADMIN = BASE_URL+"/admin/service";
    public static final String DELETE_SERVICE_ADMIN = BASE_URL+"/admin/service/{id}";
    public static final String DELETE_SERVICE_ADMIN_NO_ID = BASE_URL+"/admin/service";
    public static final String DELETE_SERVICE_ADMIN_SPEC_CHARACTER = BASE_URL+"/admin/service/{character}";
    public static final String GET_DETAIL_TRANSACTION_ADMIN = BASE_URL+"/transaction/{id}";
    public static final String GET_DETAIL_TRANSACTION_ADMIN_INVALID_PATH = BASE_URL+"/transactionss";
    public static final String GET_DETAIL_TRANSACTION_ADMIN_SPEC_CHAR = BASE_URL + "/transaction/{character}";
    public static final String GET_TRANSACTION_ADMIN_VALID_PATH = BASE_URL+ "/admin/transaction";
    public static final String GET_TRANSACTION_ADMIN_INVALID_PATH = BASE_URL+ "/admin/transaction/dhuaar";
    public static final String PUT_TRANSACTION_ADMIN  = BASE_URL+ "/admin/transaction/1";
    public static final String PUT_TRANSACTION_ADMIN_INVALID = BASE_URL+ "/admin/transaction/HAHA";
    public static final String DELETE_CANCEL_TRANSACTION_ADMIN = BASE_URL+ "/admin/transaction/{id}";
    public static final String GET_VEHICLESERVICE_ADMIN = BASE_URL + "/admin/vehicleservice";
    public static final String GET_VEHICLESERVICE_INVALID_PATH_ADMIN = BASE_URL + "/admin/vehicleservicess";
    public static final String VALID_ADMIN_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNj" +
            "Y4MDEyMjY0LCJpZCI6Miwicm9sZSI6MX0.CrYp4cqKypDxgZ_ewG6BlfBrZE3C3eL5rg7uyH_0_d4";
    public static final String INVALID_ADMIN_TOKEN = "Bearer JIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY4MDEyMjY0LCJpZCI6Miwicm9sZSI6MX0.CrYp4cqKypDxgZ_ewG6BlfBrZE3C3eL5rg7uyH_0_d4";
}
