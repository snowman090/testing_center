package core.event;

import java.time.temporal.ChronoUnit;

public class Utilization {

    private long utilzExpection;
    private long utilzActual;
    private int numApprove;
    private int numStudent;
    private int numDay;
    private int gap;
    private int day;
    private String exam;
    private int numSeat;

    private TestingCenterInfo center = new TestingCenterInfo();



    AppointmentDao appointmentDao = new AppointmentDaoImpl();
    examDao examDao = new examDaoImpl();

    public Double countUtilzActual(){
        long TotalDuration = 0;
        long Hours = ChronoUnit.HOURS.between(center.getOpen(), center.getClose());////

        for (Appointment appointment : appointmentDao.findAllAppointment()) {
            System.out.println(appointment.getAppointmentID());
            TotalDuration += ChronoUnit.HOURS.between(appointment.getStartDateTime(), appointment.getEndDateTime());
        }

        return ((double)TotalDuration / (double)(numSeat * Hours));
    }

    public long countUtilzExpection(){
        long TotalExamDuration = 0;
        long Hours = ChronoUnit.HOURS.between(center.getOpen(), center.getClose());////
        for (exam exam: examDao.getAllExams()) {
            TotalExamDuration += (exam.getDuration()+ gap) * (exam.getNum_Student_need() - exam.getNum_Student_appointment()/day) ;
        }
        return  (utilzActual + TotalExamDuration);
    }


    public long getUtilzExpection() {
        return utilzExpection;
    }

    public void setUtilzExpection(int utilzExpection) {
        this.utilzExpection = utilzExpection;
    }

    public long getUtilzActual() {
        return utilzActual;
    }

    public void setUtilzActual(int utilzActual) {
        this.utilzActual = utilzActual;
    }

    public int getNumApprove() {
        return numApprove;
    }

    public void setNumApprove(int numApprove) {
        this.numApprove = numApprove;
    }

    public int getNumStudent() {
        return numStudent;
    }

    public void setNumStudent(int numStudent) {
        this.numStudent = numStudent;
    }

    public int getNumDay() {
        return numDay;
    }

    public void setNumDay(int numDay) {
        this.numDay = numDay;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public int getNumSeat() {
        return numSeat;
    }

    public void setNumSeat(int numSeat) {
        this.numSeat = numSeat;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public TestingCenterInfo getCenter() {
        return center;
    }

    public AppointmentDao getAppointmentDao() {
        return appointmentDao;
    }

    public core.event.examDao getExamDao() {
        return examDao;
    }

}
