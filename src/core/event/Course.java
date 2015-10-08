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
    @Column(name = "SESSION")
    private int session;

    @Basic(optional = false)
    @Column(name = "INSTRUCTOR")
    private Instructor instructor;

    @Basic(optional = false)
    @Column(name = "ENROLLED_STUDENTS")
    @OneToMany(mappedBy = "course")
    private List<Student> enrolledStudents;

    public Course() {

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
