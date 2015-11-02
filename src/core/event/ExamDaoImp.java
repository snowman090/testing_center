package core.event;

import core.user.Instructor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import core.service.SessionManager;
import org.springframework.web.util.Log4jConfigListener;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExamDaoImp implements ExamDao{
    //public static final Logger log = Logger.getLogger(ExamDaoImp.class);
    List<Exam> exams;
    public ExamDaoImp() {}

    @Override
    public List<Exam> getAllExams() {//approved request
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        exams = session.createQuery("FROM Exam").list();
        session.close();
        return exams;
    }


    @Override
    public Exam findByExamId(String examId) {

        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Exam E WHERE E.examId = :eId");
        query.setParameter("eId", examId);
        tx.commit();
        Exam result = (Exam)query.uniqueResult();
        session.close();
        return result;
    }

    @Override
    public List<Exam> findByInStructorId(String instructorId) {
        ArrayList<Exam> result;
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Exam E WHERE E.instructorId = :insId");

        query.setParameter("insId", instructorId);
        tx.commit();
        result = (ArrayList<Exam>)query.list();
        session.close();
        return result;
    }


    @Override
    public boolean addExam(Exam exam) {// return should have different cases
//        exams.add(exam);
//        return true;
// Comment off by Zeqing Li.
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(exam);
            /*log.info("---------- add Exam info----------");
            log.info("|  -Exam Id: " + exam.getExamId());
            log.info("|  -Type: " + exam.getType());
            log.info("|  -Start Date Time: " + exam.getStartDateTime());
            log.info("|  -End Date Time" + exam.getEndDateTime());
            log.info("|  -Duration: " + exam.getDuration());
            log.info("|  -Number of Students who has appointments: " + exam.getNumStudentAppointment());
            log.info("|  -Number of Students who need to take exam: " + exam.getNumStudentNeed());*/

            tx.commit();
            session.close();
        }catch (HibernateException he){
            if(tx != null){
                tx.rollback();
            }
            //log.error("Error with addExam ", he);
            return false;
        }
        return  true;
    }

    @Override
    public boolean updateExam(Exam exam, String id) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("update Exam E set E  = :E where E.examId = :examId");
            query.setParameter("E", exam);
            query.setParameter("examId", id);

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
    public boolean deleteExam(Exam exam) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("delete from Exam E where E.examId = :examId");
            query.setParameter("examId", exam.getExamId());

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
}
