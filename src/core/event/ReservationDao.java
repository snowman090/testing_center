package core.event;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDao {

    //List<Reservation> findAll();

    List<Reservation> getAllReservation();
    Reservation findByID(String reservationID);

    List<Reservation> findByDate(LocalDate date);
    List<Reservation> findByInstructor(String InstructorID);

    boolean insertReservation(Reservation reservation) throws Exception;
    boolean updateReservation(Reservation newReservation) throws Exception;
    boolean deleteReservation(Reservation reservation) throws Exception;
}
