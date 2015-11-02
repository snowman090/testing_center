package core.event;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDao {
    List<Reservation> findAll();
    Reservation findByID(String reservationID);
    List<Reservation> findByDate(LocalDate date);
    List<Reservation> findByInstructor(String InstructorID);
    boolean insertReservation(Reservation reservation);
    boolean updateReservation(Reservation reservation, String id);
    boolean deleteReservation(Reservation reservation);
}
