package bengCall.user;

public class userAPI {
    public static final String BASE_URL = "https://project-edu.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"src/test/resources/jsonFile";
    public static final String POST_REGISTER_USER_VALID_PATH = BASE_URL+"/register";
    public static final String POST_REGISTER_USER_INVALID_PATH = BASE_URL+"/registerr";
    public static final String POST_LOGIN_USER_VALID_PATH = BASE_URL+"/login";
    public static final String POST_LOGIN_USER_INVALID_PATH = BASE_URL+"/loginn";
    public static final String CUSTOMER_PROFILE_VALID_PATH = BASE_URL+"/users";
    public static final String CUSTOMER_PROFILE_INVALID_PATH = BASE_URL+"/userss";
    public static final String CUSTOMER_VEHICLES_VALID_PATH = BASE_URL+"/vehicle";
    public static final String CUSTOMER_VEHICLES_INVALID_PATH = BASE_URL+"/vehicless";
    public static final String CUSTOMER_SERVICES_VALID_PATH = BASE_URL+"/service/{id}";
    public static final String CUSTOMER_SERVICES_INVALID_PATH = BASE_URL+"/services/{id}";
    public static final String CUSTOMER_ALL_SERVICE_HISTORY_VALID_PATH = BASE_URL+"/history";
    public static final String CUSTOMER_ALL_SERVICE_HISTORY_INVALID_PATH = BASE_URL+"/historys";
    public static final String CUSTOMER_COMMENT_VALID_PATH = BASE_URL+"/comment/{id}";
    public static final String CUSTOMER_COMMENT_INVALID_PATH = BASE_URL+"/comments/{id}";
    public static final String POST_TRANSACTION_USER_VALID_PATH = BASE_URL+"/transaction";
    public static final String POST_TRANSACTION_USER_INVALID_PATH = BASE_URL+"/transactions";
    public static final String DETAIL_TRANSACTION_USER_VALID_PATH = BASE_URL+"/transaction/me";
    public static final String DETAIL_TRANSACTION_USER_INVALID_PATH = BASE_URL+"/transaction/meee";
    public static final String ONGOING_USER_TRANSACTION_USER_VALID_PATH = BASE_URL+"/transaction/{id}";
    public static final String ONGOING_USER_TRANSACTION_USER_INVALID_PATH = BASE_URL+"/transactions/{id}";
    public static final String VALID_TOKEN ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY4NTcyOTY2LCJpZCI6MTU3LCJyb2xlIjowfQ.33J_Lm94hr_ArmgJhTOyKRImoAiVQ6kDRZcd2zDts3M";
    public static final String EXPIRED_TOKEN ="Bearer eyeeeerwJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3NzkyNzM2LCJpZCI6Miwicm9sZSI6MX0.bIdQ95WTl2ArvKn7RSptNgBBPZ08W2iPPJbxjefSRVE";
    public static final String TOKEN_ON_CUSTOMER_ACCOUNT_NOT_EXIST ="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3NzEyNjYxLCJpZCI6Nywicm9sZSI6MH0.BsCCA7kROz9yldDro-l-kjNP7RoF13l1-fyRbDWdeSA";
}
