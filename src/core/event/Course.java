package core.event;

import core.user.Instructor;
import core.user.Student;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @Column(name = "COURSE_NAME")
    private String courseId;
    @Basic(optional = false)
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
