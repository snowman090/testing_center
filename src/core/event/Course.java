package core.event;

import core.user.Instructor;
import core.user.Student;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
    @Id
    @Column(name = "courseId" )
    @Basic(optional = false)
    private String courseId;
    @Basic(optional = false)
    @Column(name = "subject" )
    private String subject;
    @Basic(optional = false)
    @Column(name = "catalogNumber")
    private int catalog;
    @Basic(optional = false)
    @Column(name = "session")
    private int session;
    @Basic(optional = false)
    @Column(name = "instructor")
    private Instructor instructor;
    @Basic(optional = false)
    @OneToMany(mappedBy = "courseID")
    private List<Student> enrolledStudents;

    // Empty Constructor For Hibernate
    public Course() {
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getEnrolledStudents() {
        return this.enrolledStudents;
    }

    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}