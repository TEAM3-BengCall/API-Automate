package bengCall.admin;

public class adminAPI {
    public static final String BASE_URL = "https://project-edu.online";
    public static final String JSON_FILE = "src/test/resources/jsonFile";
    public static final String GET_ALL_VEHICLE_ADMIN = BASE_URL+"/vehicle";
    public static final String POST_CREATE_VEHICLE_ADMIN =BASE_URL +"/admin/vehicle";

    public static final String GET_ALL_SERVICE_TYPE_ADMIN = BASE_URL+"/service/{id}";
    public static final String GET_ALL_SERVICE_TYPE_ADMIN_SPEC_CHARACTER = BASE_URL + "/service/{id}";
    public static final String POST_CREATE_SERVICE_ADMIN = BASE_URL+"/admin/service";
    public static final String DELETE_SERVICE_ADMIN = BASE_URL+"/admin/service/{id}";
    public static final String DELETE_SERVICE_ADMIN_NO_ID = BASE_URL+"/admin/service";
    public static final String GET_DETAIL_TRANSACTION_ADMIN = BASE_URL+"/transaction/{id}";
    public static final String GET_TRANSACTION_ADMIN_VALID_PATH = BASE_URL+ "/admin/transaction";
    public static final String PUT_TRANSACTION_ADMIN  = BASE_URL+ "/admin/transaction/{id}";
    public static final String DELETE_CANCEL_TRANSACTION_ADMIN = BASE_URL+ "/admin/transaction/{id}";
    public static final String GET_VEHICLESERVICE_ADMIN = BASE_URL + "/admin/vehicleservice";
    public static final String VALID_ADMIN_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNj" +
            "Y4MDEyMjY0LCJpZCI6Miwicm9sZSI6MX0.CrYp4cqKypDxgZ_ewG6BlfBrZE3C3eL5rg7uyH_0_d4";
    public static final String INVALID_ADMIN_TOKEN = "Bearer JIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY4MDEyMjY0LCJpZCI6Miwicm9sZSI6MX0.CrYp4cqKypDxgZ_ewG6BlfBrZE3C3eL5rg7uyH_0_d4";
}
