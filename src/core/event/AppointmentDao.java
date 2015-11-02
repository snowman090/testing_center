package core.event;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentDao {
    List<Appointment> findAllAppointment();

    List<Appointment> findAllByStudent(String netId);

    //List<Appointment> findAllByInstructor(String netId);   why???

    Appointment findByAppointmentID(String AppointmentID);

    boolean insertAppointment(Appointment appointment);

    boolean updateAppointment(Appointment appointment, String id);

    boolean deleteAppointment(Appointment appointment);

}
