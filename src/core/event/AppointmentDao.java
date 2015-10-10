package core.event;

import java.util.List;

/**
 * Created by eson_wang on 10/11/15.
 */
public interface AppointmentDao {
    List<Appointment> findByAppointmentID();

    boolean addAppointment(Appointment appointment);

    boolean updateAppointment(Appointment appointment);

    boolean deleteAppointment(Appointment appointment);
}
