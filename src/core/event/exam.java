package core.event;

import core.user.Instructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

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







}
