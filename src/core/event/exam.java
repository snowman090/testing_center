package core.event;

import core.user.Instructor;

import javax.persistence.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@Table(name = "Exam")
public class exam {
    @Id
    @Column(name = "examId")
    @Basic(optional = false)
    private String examId;

    @Basic(optional = false)
    @Column(name = "exam_name" )
    private String examName;//course or adhoc

    @Basic(optional = false)
    @Column(name = "type" )
    private String type;//course or adhoc

    @Basic(optional = false)
    @Column(name = "Num_Student_Need" )
    private int numStudentNeed;//

    @Basic(optional = false)
    @Column(name = "Num_Student_appointment" )
    private int numStudentAppointment;//


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="START_DATE_TIME")// start time of an exam
    @Basic(optional = false)
    private Date startDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="END_DATE_TIME")// end time of an exam
    @Basic(optional = false)
    private Date endDateTime;

    private double duration;// lasting time
    public exam(){}
    public exam(String Id, String name, String type, LocalDateTime start, LocalDateTime end, double duration, int numApp, int numNeed){
        examId = Id;
        examName = name;
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

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
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
    public void setType(String type) {this.type = type;}

    public double getDuration()
    {
        return (double)ChronoUnit.MINUTES.between(getStartDateTime(), getEndDateTime())/60;
    }
}
