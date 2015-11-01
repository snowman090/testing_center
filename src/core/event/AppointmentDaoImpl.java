package core.event;

import core.service.SessionManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

    @Autowired
    private SessionManager sessionManager = new SessionManager();
    SessionFactory sessionFactory = sessionManager.createSessionFactory();

    List<Appointment> appointments;

    public AppointmentDaoImpl(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
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
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(appointment);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAppointment(Appointment appointment) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete from Appointment R where R.appointmentID = :appintmentID");
            query.setParameter("appintmentID", appointment.getAppointmentID());
            int ret = query.executeUpdate();// this int return the number of entities updated or deleted
            session.getTransaction().commit();
            session.close();
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAppointment(Appointment appointment){
        try {
            Session session = sessionFactory.openSession();//need to throw exception
            session.beginTransaction();

            Query query = session.createQuery("update Appointment A set A  = :A where A.appointmentID = :appointmentID");
            query.setParameter("A", appointment);
            query.setParameter("appointmentID", appointment.getAppointmentID());

            int ret = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }





}
