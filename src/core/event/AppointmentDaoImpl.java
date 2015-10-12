package core.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDaoImpl implements AppointmentDao {

    List<Appointment> appointments;

    public AppointmentDaoImpl() {
        appointments = new ArrayList<Appointment>();
        Appointment appointment1 = new Appointment();
        Appointment appointment2 = new Appointment();
        appointments.add(appointment1);
        appointments.add(appointment2);
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }


    public Appointment getAppointment(int id) {
        return appointments.get(id);
    }


    public boolean deleteAppointment(Appointment appointment) {
        appointments.remove(appointment.getAppointmentID());
        return true;

    }

    public boolean updateAppointmentTime(Appointment appointment, LocalDateTime startTime, LocalDateTime endTime){
        Appointment App = appointments.get(Integer.parseInt(appointment.getAppointmentID()));
        App.setStartDateTime(startTime);
        App.setEndDateTime(endTime);

        return true;
    }

    public boolean updateAppointmentName(Appointment appointment, String name){
        Appointment App = appointments.get(Integer.parseInt(appointment.getAppointmentID()));
        App.setStudentName(name);
        return true;
    }

    public boolean addAppointment(Appointment appointment) {
        appointments.add(appointment);
        return true;
    }

    @Override
    public List<Appointment> findAllAppointment() {
        return null;
    }

    @Override
    public List<Appointment> findByAppointmentID(String AppointmentID) {
        return null;
    }


}
