package core.event;

import core.service.SessionManager;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentDaoImp implements AppointmentDao {
    List<Appointment> appointments;

    public AppointmentDaoImp(){}

    @Override
    public List<Appointment> findAllAppointment() {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = session.beginTransaction();
        appointments = session.createQuery("FROM Appointment").list();
        session.close();
        return appointments;
    }

    @Override
    public List<Appointment> findAllByStudent(String NetId) {
        ArrayList<Appointment> result;
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Appointment A WHERE A.studentId = :stuId");

        query.setParameter("stuId", NetId);
        tx.commit();
        result = (ArrayList<Appointment>)query.list();
        session.close();
        return result;
    }

    @Override
    public Appointment findByAppointmentID(String AppointmentID) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Appointment A WHERE A.appointmentID = :appId");
        query.setParameter("appId", AppointmentID);
        tx.commit();
        Appointment result = (Appointment)query.uniqueResult();
        session.close();
        return result;
    }

    /*@Override
    public List<Appointment> findAllByInstructor(String netId) {
        List<Appointment> result = new ArrayList<Appointment>();
        for(int i = 0, index = 0; i < appointments.size(); i++){
            if(appointments.get(i).get.equals(NetId)){
                result.set(index,appointments.get(i));
                index++;
            }
        }
        return result;
    }*/

    @Override
    public boolean insertAppointment(Appointment appointment) {// how to know which table we add in
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.save(appointment);
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

    @Override
    public boolean deleteAppointment(Appointment appointment) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("delete from Appointment R where R.appointmentID = :appointmentID");
            query.setParameter("appointmentID", appointment.getAppointmentID());

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

    @Override
    public boolean updateAppointment(Appointment appointment, String id){
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("update Appointment A set A  = :A where A.appointmentID = :appointmentID");
            query.setParameter("A", appointment);
            query.setParameter("appointmentID", id);
            query.executeUpdate();
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
