package core.controller;

import java.util.ArrayList;
import java.util.List;

public class StringResources {
    public final static String LOGIN_USER_ERROR = "NetID not registered";
    public final static String LOGIN_PASSWORD_ERROR = "Password does not match user";
    public final static String USER_INSTRUCTOR = "Instructor";
    public final static String USER_STUDENT = "Student";
    public final static String USER_ADMINISTRATOR = "Administrator";

    public final static List<String> ADMINISTRATOR_OPERATIONS = new ArrayList<String>();
    public final static List<String> STUDENT_OPERATIONS = new ArrayList<String>();
    public final static List<String> INSTRUCTOR_OPERATIONS = new ArrayList<String>();

    //populate the lists of user operations
    static {
        ADMINISTRATOR_OPERATIONS.add("View Requests");


        STUDENT_OPERATIONS.add("");


        INSTRUCTOR_OPERATIONS.add("");

    }
}
