package core.event;

import core.service.SessionManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationDaoImp implements ReservationDao {

    @Autowired
    private SessionManager sessionManager = new SessionManager();
    SessionFactory sessionFactory = sessionManager.createSessionFactory();

    List<Reservation> reservations;

    public ReservationDaoImp(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        reservations = session.createQuery("FROM Reservation").list();
        session.close();
    }

    @Override
    public List<Reservation> findAll() {
        return reservations;
    }

    @Override
    public Reservation findByID(String reservationID) {
        return reservations.get(Integer.parseInt(reservationID));
    }

    @Override
    public List<Reservation> findByDate(LocalDate date) {
        ArrayList<Reservation> result = new ArrayList<Reservation>();
        for(int i = 0, index = 0; i < reservations.size(); i++){
            if((reservations.get(i).getStartDate().isBefore(date)||reservations.get(i).getStartDate().isEqual(date))
                    && (reservations.get(i).getEndDate().isAfter(date)||reservations.get(i).getEndDate().isEqual(date))){
                result.set(index,reservations.get(i));
                index++;
            }
        }
        return reservations;
    }

    @Override
    public List<Reservation> findByInstructor(String InstructorID) {
        List<Reservation> result = new ArrayList<Reservation>();
        for(int i = 0, index = 0; i < reservations.size(); i++){
            if(reservations.get(i).getInstructor().getNetId().equals(InstructorID)){
                result.set(index,reservations.get(i));
                index++;
            }
        }
        return result;
    }

    @Override
    public boolean insertReservation(Reservation reservation){//how to know which table we add in
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(reservation);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateReservation(Reservation newReservation, String id){// same Id as the old reservation, but we have set the new data in this newone
        try {
            Session session = sessionFactory.openSession();//needt to throw exception
            session.beginTransaction();
        /*Query query = session.createQuery("update Reservation set startTime = :startTime, endTime = :endTime," +
                " startDate = :startDate, endDate = :endDate, duration = :duration, instructor = :instructor, attendance = :attendance, status = :status" +
                " where reservationID = :reservationID");

        query.setParameter("startTime", newReservation.getStartTime());
        query.setParameter("endTime", newReservation.getEndTime());
        query.setParameter("startDate", newReservation.getStartDate());
        query.setParameter("endDate", newReservation.getEndDate());
        query.setParameter("duration", newReservation.getDuration());
        query.setParameter("instructor", newReservation.getInstructor());
        query.setParameter("attendance", newReservation.getAttendance());
        query.setParameter("status", newReservation.getStatus());
        query.setParameter("reservationID", newReservation.getReservationID());
        query.executeUpdate();*/
            Query query = session.createQuery("update Reservation R set R  = :R where R.reservationID = :reservationID");
            query.setParameter("R", newReservation);
            query.setParameter("reservationID", id);

            int ret = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteReservation(Reservation reservation){//needt to throw exception
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete from Reservation R where R.reservationID = :reservationID");
            query.setParameter("reservationID", reservation.getReservationID());
            int ret = query.executeUpdate();// this int return the number of entities updated or deleted
            session.getTransaction().commit();
            session.close();
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }
}
