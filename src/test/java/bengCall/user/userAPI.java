package bengCall.user;

public class userAPI {
    public static final String BASE_URL = "https://project-edu.online";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = "src/test/resources/jsonFile";
    public static final String POST_REGISTER_USER_VALID_PATH = BASE_URL+"/register";
    public static final String POST_REGISTER_USER_INVALID_PATH = BASE_URL+"/registerr";
    public static final String POST_LOGIN_USER_VALID_PATH = BASE_URL+"/login";
    public static final String POST_LOGIN_USER_INVALID_PATH = BASE_URL+"/loginn";
    public static final String CUSTOMER_PROFILE_VALID_PATH = BASE_URL+"/users";
    public static final String CUSTOMER_PROFILE_INVALID_PATH = BASE_URL+"/userss";
    public static final String CUSTOMER_VEHICLES_VALID_PATH = BASE_URL+"/vehicle";
    public static final String CUSTOMER_VEHICLES_INVALID_PATH = BASE_URL+"/vehicless";

    public static final String CUSTOMER_COMMENT_VALID_PATH = BASE_URL+"/comment/{id}";
    public static final String CUSTOMER_COMMENT_INVALID_PATH = BASE_URL+"/comments/{id}";

    public static final String VALID_TOKEN ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjcwNjkzOTY5LCJpZCI6MjcwLCJyb2xlIjowfQ.lSrXnlrGJMItk1sQdBJpGs6MYfwxVa_3Rco5FNUrdUo";
    public static final String EXPIRED_TOKEN ="eyeeeerwJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHBpcmVkIjoxNjY3NzkyNzM2LCJpZCI6Miwicm9sZSI6MX0.bIdQ95WTl2ArvKn7RSptNgBBPZ08W2iPPJbxjefSRVE";
}
