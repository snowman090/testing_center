package core.event;


import core.user.UserType;

import java.util.ArrayList;

public class DataCollection {
    static final private String PATH = "/course_registration_data/";
    static final private String fileExt = ".csv";
    private ArrayList<UserType> users;
    private ArrayList<Course> courses;
    private ArrayList<Roster> rosters;

    public boolean readUser(String semester){
        return false;
    }

    public boolean readClass(String semester){
        return false;
    }

    public boolean readRoaster(String semester){
        return false;
    }


}
