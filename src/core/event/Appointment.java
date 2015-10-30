package core.event;

import core.user.Student;
import core.user.UserType;

import javax.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @Column(name = "appointment_id")
    private String appointmentID;

    @Column(name = "exam_id")
    @Basic(optional = false)
    private String examId;

    @Column(name = "made_by")
    @Basic(optional = false)
    private String madeBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_time")
    @Basic(optional = false)
    private Date startDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_time")
    @Basic(optional = false)
    private Date endDateTime;

    @Column(name="student_Id")
    @Basic(optional = false)
    private String studentId;

    @Column(name="seat")
    @Basic(optional = false)
    private String seat;

    @Column(name="is_attend")
    @Basic(optional = false)
    private boolean isAttend;

    @ManyToOne
    @JoinColumn(name="studentId")
    private Student student;

    @JoinColumn(name="status")
    private String status;

    public Appointment(){}

    public Appointment(String appointmentID, String examId, String madeBy, LocalDateTime startDateTime,
                       LocalDateTime endDateTime, String netId, String seat, boolean isAttend){
        this.appointmentID = appointmentID;
        this.examId = examId;
        this.madeBy = madeBy;
        Instant instant1 = startDateTime.atZone(ZoneId.systemDefault()).toInstant();
        this.startDateTime = Date.from(instant1);
        Instant instant2 = endDateTime.atZone(ZoneId.systemDefault()).toInstant();
        this.endDateTime = Date.from(instant2);
        this.studentId = netId;
        this.seat = seat;
        this.isAttend = isAttend;    }


    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
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



    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public boolean isAttend() {
        return isAttend;
    }

    public void setIsAttend(boolean isAttend) {
        this.isAttend = isAttend;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // TODO SOME FIELD SHOULD NOT BE CHANGED
    public boolean update(Appointment appt){
        if(this.getAppointmentID() != appt.getAppointmentID()){
            return false;
        }
        else{
            this.setMadeBy(appt.getMadeBy());
            this.setExamId(appt.getExamId());
            this.setStartDateTime(appt.getStartDateTime());
            this.setEndDateTime(appt.getEndDateTime());
            this.setStudentId(appt.getStudentId());
            this.setSeat(appt.getSeat());
            this.setIsAttend(appt.isAttend());
            return true;
        }

    }

}
