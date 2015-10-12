package core.event;

import core.user.Instructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by eson_wang on 10/11/15.
 */
public class exam {
    @Id
    @Column(name = "examId")
    @Basic(optional = false)
    private String examId;

    @Basic(optional = false)
    @Column(name = "exam_name" )
    private String exam_Name;//course or adhoc

    @Basic(optional = false)
    @Column(name = "type" )
    private String type;//course or adhoc

    @Basic(optional = false)
    @Column(name = "Num_Student_need" )
    private int Num_Student_need;//


    public int getNum_Student_appointment() {
        return Num_Student_appointment;
    }

    public void setNum_Student_appointment(int num_Student_appointment) {
        Num_Student_appointment = num_Student_appointment;
    }

    public int getNum_Student_need() {
        return Num_Student_need;
    }

    public void setNum_Student_need(int num_Student_need) {
        Num_Student_need = num_Student_need;
    }

    @Basic(optional = false)
    @Column(name = "Num_Student_appointment" )
    private int Num_Student_appointment;//

    @Temporal(TemporalType.TIME)
    @Column(name="START_TIME")// start time of an exam
    @Basic(optional = false)
    private LocalTime startTime;

    @Temporal(TemporalType.TIME)
    @Column(name="END_TIME")// end time of an exam
    @Basic(optional = false)
    private LocalTime endTime;

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE")// start date of an exam
    @Basic(optional = false)
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE")// end date of an exam
    @Basic(optional = false)
    private LocalDate endDate;

    private int duration;// lasting time

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExam_Name() {
        return exam_Name;
    }

    public void setExam_Name(String exam_Name) {
        this.exam_Name = exam_Name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getDuration() {
        return ChronoUnit.HOURS.between(startTime, endTime);
    }








}
