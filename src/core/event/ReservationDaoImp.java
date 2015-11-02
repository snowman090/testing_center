package core.event;
import core.service.SessionManager;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationDaoImp implements ReservationDao {
    List<Reservation> reservations;

    public ReservationDaoImp(){
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        tx = session.beginTransaction();
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
    public List<Reservation> findByInstructorId(String InstructorID) {
        List<Reservation> result = new ArrayList<Reservation>();
        for(int i = 0, index = 0; i < reservations.size(); i++){
            if(reservations.get(i).getInstructorId().equals(InstructorID)){
                result.set(index,reservations.get(i));
                index++;
            }
        }
        return result;
    }

    @Override
    public boolean insertReservation(Reservation reservation){//how to know which table we add in
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            session.save(reservation);
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException he){
            if(tx != null){
                tx.rollback();
            }
            //log.error("Error with addExam ", he);
            return false;
        }
        return  true;
    }

    @Override
    public boolean updateReservation(Reservation newReservation, String id){// same Id as the old reservation, but we have set the new data in this newone
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("update Reservation R set R  = :R where R.reservationID = :reservationID");
            query.setParameter("R", newReservation);
            query.setParameter("reservationID", id);

            int ret = query.executeUpdate();
            tx.commit();
            session.close();
        }
        catch (HibernateException he){
            if(tx != null){
                tx.rollback();
            }
            //log.error("Error with addExam ", he);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteReservation(Reservation reservation){//needt to throw exception
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from Reservation R where R.reservationID = :reservationID");
            query.setParameter("reservationID", reservation.getReservationID());
            int ret = query.executeUpdate();// this int return the number of entities updated or deleted
            tx.commit();
            session.close();
        }
        catch (HibernateException he){
            if(tx != null){
                tx.rollback();
            }
            //log.error("Error with addExam ", he);
            return false;
        }
        return  true;
    }
}
