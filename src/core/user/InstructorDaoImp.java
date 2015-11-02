package core.user;


import core.event.ReservationDao;
import core.event.ReservationDaoImp;
import core.service.SessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InstructorDaoImp implements InstructorDao{
    List<Instructor> instructors;
    public InstructorDaoImp(){
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        instructors = session.createQuery("FROM Instructor ").list();
        session.close();

    }
    @Override
    public List<Instructor> findAll() {
        return instructors;
    }

    @Override
    public Instructor findByNetID(String id) {
        return instructors.get(Integer.parseInt(id));
    }

    @Override
    public boolean addInstructor(Instructor instructor) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            session.save(instructor);
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
        return true;
    }

    @Override
    public boolean updateInstructor(Instructor instructor, String id) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("update Instructor I set I  = :I where I.netId = :netId");
            query.setParameter("I", instructor);
            query.setParameter("netId", id);

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
    public boolean deleteInstructor(Instructor instructor) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from Instructor I where I.netId = :id");
            query.setParameter("id", instructor.getNetId());
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
        return true;
    }

   // @Autowired
   // ReservationDao reservationDao;


}
