package core.event;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ReservationDaoImp implements ReservationDao {
    @Override
    public List<Reservation> findAll() {
        return null;
    }

    @Override
    public List findByID(String reservationID) {
        return null;
    }

    @Override
    public List<Reservation> findByDate(LocalDate date) {
        return null;
    }

    @Override
    public List<Reservation> findByInstructor(String InstructorID) {
        return null;
    }

    @Override
    public boolean insertReservation(Reservation reservation) {
        return false;
    }

    @Override
    public boolean updateReservation(Reservation reservation) {
        return false;
    }

    @Override
    public boolean deleteReservation(Reservation reservation) {
        return false;
    }
}
