package core.event;

import java.time.LocalTime;
import java.util.List;

/**
 * Created by eson_wang on 10/11/15.
 */
public interface AppointmentDao {
    List<Appointment> findAllAppointment();
    List<Appointment> findByAppointmentID(String AppointmentID);

    boolean addAppointment(Appointment appointment);

    boolean updateAppointmentTime(Appointment appointment, LocalTime StartTime, LocalTime EndTime);

    boolean updateAppointmentName(Appointment appointment, String name);

    boolean deleteAppointment(Appointment appointment);
}
