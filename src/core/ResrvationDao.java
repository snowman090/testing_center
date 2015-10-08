package core;

import java.util.List;

public interface ResrvationDao {
    List<Reservation> findAll();
    List<Reservation> findByID();
    //could be deleted if there exist function for displaying day, week, term
    List<Reservation> findByDate();
    List<Reservation> findByInstructor();
    List<Reservation> findByStudent();
    boolean insertReservation(Reservation reservation);
    boolean updateReservation(Reservation reservation);
    boolean deleteReservation(Reservation reservation);
}
