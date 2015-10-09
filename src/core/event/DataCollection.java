package core.event;

import core.user.UserType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataCollection {
    static final private String PATH = "/course_registration_data/";
    static final private String fileExt = ".csv";

    private List<String[]> users;
    private List<String[]> courses;
    private List<String[]> rosters;

    private String path_usersCSV;
    private String path_soursesCSV;
    private String path_rostersCSV;

    public boolean readUser(String semester){
        return false;
    }

    public boolean readClass(String semester){
        return false;
    }

    public boolean readRoaster(String semester){
        return false;
    }

    public void readUsersFile(String path, List<String[]> list){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] listItem = line.split(cvsSplitBy);
                list.add(listItem);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

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

    public String getPath_soursesCSV() {
        return path_soursesCSV;
    }

    public void setPath_soursesCSV(String path_soursesCSV) {
        this.path_soursesCSV = path_soursesCSV;
    }

    public String getPath_rostersCSV() {
        return path_rostersCSV;
    }

    public void setPath_rostersCSV(String path_rostersCSV) {
        this.path_rostersCSV = path_rostersCSV;
    }
}
