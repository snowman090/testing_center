package core.event;

import core.user.UserType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataCollection {
    static final private String PATH = "/course_registration_data/";
    static final private String fileExt = ".csv";

    private List<String[]> users;
    private List<String[]> courses;
    private List<String[]> rosters;

    private String path_usersCSV;
    private String path_coursesCSV;
    private String path_rostersCSV;

    //import ata from CSV file
    public boolean readFile(String path, List<String[]> list){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        list = new ArrayList<String[]>();
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] listItem = line.split(cvsSplitBy);
                list.add(listItem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    //


    public List<String[]> getUsers() {
        return users;
    }

    public void setUsers(List<String[]> users) {
        this.users = users;
    }

    public List<String[]> getCourses() {
        return courses;
    }

    public void setCourses(List<String[]> courses) {
        this.courses = courses;
    }

    public List<String[]> getRosters() {
        return rosters;
    }

    public void setRosters(List<String[]> rosters) {
        this.rosters = rosters;
    }

    public String getPath_usersCSV() {
        return path_usersCSV;
    }

    public void setPath_usersCSV(String path_usersCSV) {
        this.path_usersCSV = path_usersCSV;
    }

    public String getPath_coursesCSV() {
        return path_coursesCSV;
    }

    public void setPath_coursesCSV(String path_coursesCSV) {
        this.path_coursesCSV = path_coursesCSV;
    }

    public String getPath_rostersCSV() {
        return path_rostersCSV;
    }

    public void setPath_rostersCSV(String path_rostersCSV) {
        this.path_rostersCSV = path_rostersCSV;
    }
}
