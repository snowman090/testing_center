package core.event;

import core.user.Instructor;
import core.user.Student;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @Column(name = "COURSE_NAME")
    @Basic(optional = false)
    private String courseId;

    @Basic(optional = false)
    @Column(name = "SUBJECT")
    private String subject;

    @Basic(optional = false)
    @Column(name = "CATALOG_NUMBER")
    private int catalog;

    @Basic(optional = false)
    private int session;

    @Basic(optional = false)
    private Instructor instructor;

    @Basic(optional = false)
    @Column(name = "ENROLLED_STUDENTS")
    @OneToMany(mappedBy = "course")
    private List<Student> enrolledStudents;

    @Lob
    private String description;

    public Course() {

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getCatalog() {
        return catalog;
    }

    public void setCatalog(int catalog) {
        this.catalog = catalog;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}
