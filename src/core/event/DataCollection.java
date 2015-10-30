package core.event;

import core.db.SessionManager;
import core.user.UserType;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import test.Log4J;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataCollection {
    public static final Logger log = Logger.getLogger(Log4J.class);
    private static SessionManager sessionManager;

    static final private String PATH = "/course_registration_data/";
    static final private String fileExt = ".csv";

    private List<String[]> users;
    private List<String[]> courses;
    private List<String[]> rosters;

    private String path_usersCSV;
    private String path_coursesCSV;
    private String path_rostersCSV;

    private AppointmentDaoImpl appointmentDaoImpl = new AppointmentDaoImpl();

    //import ata from CSV file
    //0: fail; 1: user; 2: class; 3: rooster
    public boolean readFile(String path){
        List<String[]> list = new ArrayList<String[]>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<Appointment> appointmentList = appointmentDaoImpl.findAllAppointment();
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
                //add users to table;
            }
            else if(path.contains("class.csv")){
                setCourses(list);
                log.info("|  Import Class Information: ");
            }
            else if(path.contains("roster.csv")){
                setRosters(list);
                log.info("|  Import Roster Information: ");
                //change the list to hashmap
                HashMap<String, String> hash = new HashMap();
                for(int i = 0; i < list.size(); i++){
                    hash.put(list.get(i)[0],list.get(i)[1]);
                }
                markSuperfluous(appointmentList, list);
                Session session = sessionManager.getInstance().getOpenSession();
                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    List e = session.createQuery("FROM Appointment WHERE Appointment.status = 's' ").list();
                    Iterator iterator = e.iterator();
                    while (iterator.hasNext()) {
                        Appointment appt = (Appointment) iterator.next();
                        if(hash.get(appt.getStudentId()) == appt.getExamId()){
                            appt.setStatus(null);
                            //reinstate appointment
                        }
                        else {
                            //cancel appointment
                        }
                    }
                }catch (HibernateException var9) {
                    if(tx != null) {
                        tx.rollback();
                    }

                    var9.printStackTrace();
                } finally {
                    session.close();
                }
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
    public void markSuperfluous(List<Appointment> appointmentList, List<String[]> list){
        Iterator databaseIterator = appointmentList.iterator();
        while(databaseIterator.hasNext()) {
            Appointment appt = (Appointment)databaseIterator.next();
            appt.setStatus("s");
               for(int i = 0; i < list.size(); i++){
                    if ((appt.getStudentId() == list.get(i)[0]) && (appt.getExamId() == list.get(i)[1])) {
                        appt.setStatus(null);
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
