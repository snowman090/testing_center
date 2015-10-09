package core.event;

import core.user.UserType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        list = new List<String[]>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String[]> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(String[] strings) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String[]> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends String[]> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public String[] get(int i) {
                return new String[0];
            }

            @Override
            public String[] set(int i, String[] strings) {
                return new String[0];
            }

            @Override
            public void add(int i, String[] strings) {

            }

            @Override
            public String[] remove(int i) {
                return new String[0];
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<String[]> listIterator() {
                return null;
            }

            @Override
            public ListIterator<String[]> listIterator(int i) {
                return null;
            }

            @Override
            public List<String[]> subList(int i, int i1) {
                return null;
            }
        };
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
