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

    public AppointmentDaoImp(){
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = session.beginTransaction();
        appointments = session.createQuery("FROM Appointment").list();
        session.close();
    }

    @Override
    public List<Appointment> findAllAppointment() {
        return appointments;
    }

    @Override
    public List<Appointment> findAllByStudent(String NetId) {
        List<Appointment> result = new ArrayList<Appointment>();
        for(int i = 0, index = 0; i < appointments.size(); i++){
            if(appointments.get(i).getStudentId().equals(NetId)){
                result.set(index, appointments.get(i));
                index++;
            }
        }
        return result;
    }

    @Override
    public Appointment findByAppointmentID(String AppointmentID) {
        return appointments.get(Integer.parseInt(AppointmentID));
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

    @Override
    public boolean updateAppointment(Appointment appointment, String id){
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("update Appointment A set A  = :A where A.appointmentID = :appointmentID");
            query.setParameter("A", appointment);
            query.setParameter("appointmentID", id);

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
        return  true;
    }





}
