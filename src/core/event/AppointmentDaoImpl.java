package core.event;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

    List<Appointment> appointments;

    public AppointmentDaoImpl() {
        appointments = new ArrayList<Appointment>();
    }
    @Override
    public List<Appointment> findAllAppointment() {
        return appointments;
    }

    @Override
    public List<Appointment> findAllByStudent(String NetId) {
        return null;
    }

    @Override
    public List<Appointment> findAllByInstructor(String netId) {
        return null;
    }

    @Override
    public boolean deleteAppointment(Appointment appointment) {
        appointments.remove(appointment.getAppointmentID());
        return true;
    }

    @Override
    public boolean updateAppointmentTime(Appointment appointment, LocalDateTime StartTime, LocalDateTime EndTime){

        Appointment App = appointments.get(Integer.parseInt(appointment.getAppointmentID()));
        App.setStartDateTime(StartTime);
        App.setEndDateTime(EndTime);

        return true;
    }
    @Override
    public boolean updateAppointmentName(Appointment appointment, String name){
        Appointment App = appointments.get(Integer.parseInt(appointment.getAppointmentID()));
        App.setStudentId(name);
        return true;
    }
    @Override
    public boolean addAppointment(Appointment appointment) {
        appointments.add(appointment);
        return true;
    }

    @Override
    public boolean findByAppointmentID(String AppointmentID) {
        appointments.get(Integer.parseInt(AppointmentID));

        return true;
    }


}
