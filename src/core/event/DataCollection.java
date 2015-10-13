package core.event;

import core.user.UserType;
import org.apache.log4j.Logger;
import test.Log4J;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataCollection {
    public static final Logger log = Logger.getLogger(Log4J.class);

    static final private String PATH = "/course_registration_data/";
    static final private String fileExt = ".csv";

    private List<String[]> users;
    private List<String[]> courses;
    private List<String[]> rosters;

    private String path_usersCSV;
    private String path_coursesCSV;
    private String path_rostersCSV;

    //import ata from CSV file
    //0: fail; 1: user; 2: class; 3: rooster
    public boolean readFile(String path){
        List<String[]> list = new ArrayList<String[]>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(path));
            log.info("---------- readFile(String path) ----------");
            while ((line = br.readLine()) != null) {
                String[] listItem = line.split(cvsSplitBy);
                list.add(listItem);
            }
            if(path.contains("user.csv")){
                setUsers(list);
                log.info("|  Import User Information: ");
            }
            else if(path.contains("class.csv")){
                setCourses(list);
                log.info("|  Import Class Information: ");
            }
            else if(path.contains("roster.csv")){
                setRosters(list);
                log.info("|  Import Roster Information: ");
            }
            for(int i = 0; i < list.size(); i++){
                String[] items = list.get(i);
                for( int j = 0; j < items.length; j++){
                    log.info("|  " + items[j]);
                }
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
