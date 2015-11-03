package core.event;

import core.service.SessionManager;
import org.hibernate.*;

import java.util.List;

/**
 * Created by eson_wang on 11/2/15.
 */
public class CourseDaoImp implements CourseDao{
    List<Course> courses;

    public CourseDaoImp(){
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = session.beginTransaction();
        courses = session.createQuery("FROM Course ").list();
        session.close();
    }

    @Override
    public List<Course> getAllCourse() {
        return courses;
    }

    @Override
    public Course findByCourseId(String courseId) {
        return courses.get(Integer.parseInt(courseId));
    }

    @Override
    public boolean addCourse(Course course) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(course);
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
    public boolean updateCourse(Course course, String id) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("update Course C set C  = :C where C.courseId = :courseId");
            query.setParameter("C", course);
            query.setParameter("courseId", id);

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

    @Override
    public boolean deleteCourse(Course course) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from Course R where R.courseId = :courseId");
            query.setParameter("courseId", course.getCourseId());
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
