package core.event;

import core.user.Instructor;

import javax.persistence.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@Table(name = "Exam")
public class Exam {// approved request
    @Id
    @Column(name = "examId")
    @Basic(optional = false)
    private String examId;


    @Column(name = "exam_name" )
    private String examName;//course or ad hoc

    @Basic(optional = false)
    @Column(name = "type" )
    private String type;//"course" or "ad hoc"



    @Basic(optional = false)
    @Column(name = "num_student_need_to_take_exam" )
    private int numStudentNeed;//

    @Basic(optional = false)
    @Column(name = "num_student_existing_appointment_to_take_exam" )
    private int numStudentAppointment;//

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date_time")// start time of an exam
    @Basic(optional = false)
    private Date startDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date_time")// end time of an exam
    @Basic(optional = false)
    private Date endDateTime;

    @Column(name="attendace")
    private int attendance;

    @Column(name="instructor_id")
    @Basic(optional = false)
    private String instructorId;

    private double duration;// lasting time
    
    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }


    
    public Exam(){}

    /**
     *
     * @param Id ExamID
     * @param type Type
     * @param start
     * @param end
     * @param duration
     * @param numApp
     * @param numNeed
     */
    public Exam(String Id, String type, LocalDateTime start, LocalDateTime end, double duration, int numApp, int numNeed){
        examId = Id;
        this.type = type;

        Instant instant1 = start.atZone(ZoneId.systemDefault()).toInstant();
        startDateTime = Date.from(instant1);

        Instant instant2 = end.atZone(ZoneId.systemDefault()).toInstant();
        endDateTime = Date.from(instant2);

        this.duration = duration;

        numStudentAppointment = numApp;
        numStudentNeed = numNeed;
    }


    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getNumStudentAppointment() {
        return numStudentAppointment;
    }

    public void setNumStudentAppointment(int numStudentAppointment) {
        this.numStudentAppointment = numStudentAppointment;
    }

    public int getNumStudentNeed() {
        return numStudentNeed;
    }

    public void setNumStudentNeed(int numStudentNeed) {
        this.numStudentNeed= numStudentNeed;
    }

    public LocalDateTime getStartDateTime() {// date to
        Instant instant = Instant.ofEpochMilli(startDateTime.getTime());
        LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        return res;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        Instant instant = startDateTime.atZone(ZoneId.systemDefault()).toInstant();
        this.startDateTime = Date.from(instant);
    }



    public LocalDateTime getEndDateTime() {
        Instant instant = Instant.ofEpochMilli(endDateTime.getTime());
        LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        return res;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        Instant instant = endDateTime.atZone(ZoneId.systemDefault()).toInstant();
        this.endDateTime = Date.from(instant);
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public double getDuration()
    {
        return (double)ChronoUnit.MINUTES.between(getStartDateTime(), getEndDateTime())/60;
    }
}
