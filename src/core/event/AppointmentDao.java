package core.event;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentDao {
    List<Appointment> findAllAppointment();

    List<Appointment> findAllByStudent(String NetId);

    boolean findByAppointmentID(String AppointmentID);

    boolean addAppointment(Appointment appointment);

    boolean updateAppointmentTime(Appointment appointment, LocalDateTime startTime, LocalDateTime endTime);

    boolean updateAppointmentName(Appointment appointment, String name);

    boolean deleteAppointment(Appointment appointment);

}
