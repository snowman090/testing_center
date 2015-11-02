package core.event;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import core.service.SessionManager;
import org.springframework.web.util.Log4jConfigListener;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExamDaoImp implements ExamDao{
    public static final Logger log = Logger.getLogger(ExamDaoImp.class);
    List<Exam> exams;
    public ExamDaoImp() {

        exams = new ArrayList<Exam>();
    }
    @Override
    public List<Exam> getAllExams() {
        return exams;
    }


    @Override
    public Exam findByExamId(String examId) {
        return exams.get(Integer.parseInt(examId));
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
            log.info("---------- add Exam info----------");
            log.info("|  -Exam Id: " + exam.getExamId());
            log.info("|  -Exam Name: " + exam.getExamName());
            log.info("|  -Type: " + exam.getType());
            log.info("|  -Start Date Time: " + exam.getStartDateTime());
            log.info("|  -End Date Time" + exam.getEndDateTime());
            log.info("|  -Duration: " + exam.getDuration());
            log.info("|  -Number of Students who has appointments: " + exam.getNumStudentAppointment());
            log.info("|  -Number of Students who need to take exam: " + exam.getNumStudentNeed());

            tx.commit();
            session.close();
        }catch (HibernateException he){
            if(tx != null){
                tx.rollback();
            }
            log.error("Error with addExam ", he);
            return false;
        }
        return  true;
    }

    @Override
    public boolean updateExam(Exam exam, String examId) {
        return false;
    }

    @Override
    public boolean deleteCExam(String examId) {
        return false;
    }
}
