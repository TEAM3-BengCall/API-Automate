package bengCall.admin;

public class adminAPI {
    public static final String BASE_URL = "https://project-edu.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR + "src/test/resources/jsonFile";
    public static final String POST_LOGIN_ADMIN = BASE_URL+"/login";
    public static final String GET_ALL_VEHICLE_ADMIN = BASE_URL+"/vehicle";
    public static final String GET_ALL_VEHICLE_ADMIN_INVALID_PATH = BASE_URL+"/vehicless";
    public static final String GET_DETAIL_TRANSACTION_ADMIN = BASE_URL+"/transaction/{id}";
    public static final String GET_DETAIL_TRANSACTION_ADMIN_INVALID_PATH = BASE_URL+"/transactionss";
    public static final String GET_DETAIL_TRANSACTION_ADMIN_SPEC_CHAR = BASE_URL + "/transaction/{character}";
    public static final String VALID_ADMIN_TOKEN = "Bearer ";
    public static final String INVALID_ADMIN_TOKEN = "Bearer ";
}
