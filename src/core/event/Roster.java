package core.event;


public class Roster {
    private String netID;
    private String CourseID;

    public Roster(String netID, String courseID) {
        this.netID = netID;
        this.CourseID = courseID;
    }

    public String getNetID() {
        return netID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setNetID(String netID) {
        this.netID = netID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

}
