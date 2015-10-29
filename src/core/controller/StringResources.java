package core.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringResources {

    public final static String LOGIN_USER_ERROR = "NetID not registered";
    public final static String LOGIN_PASSWORD_ERROR = "Password does not match user";
    public final static String USER_INSTRUCTOR = "Instructor";
    public final static String USER_STUDENT = "Student";
    public final static String USER_ADMINISTRATOR = "Administrator";

    public final static Map<String, String> ADMINISTRATOR_OPERATIONS = new HashMap<>();
    public final static Map<String, String> STUDENT_OPERATIONS = new HashMap<>();
    public final static Map<String, String> INSTRUCTOR_OPERATIONS = new HashMap<>();

    //populate the lists of user operations
    static {
        ADMINISTRATOR_OPERATIONS.put("viewRequest", "View Requests");

    }
}
