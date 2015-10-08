package core.event;

import java.util.List;

public interface ResrvationDao {
    List<Reservation> findAll();
    List findByID();
    List<Reservation> findByDate();
    List<Reservation> findByInstructor();
    boolean insertReservation(Reservation reservation);
    boolean updateReservation(Reservation reservation);
    boolean deleteReservation(Reservation reservation);
}
