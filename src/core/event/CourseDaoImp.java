package core.event;

import core.service.SessionManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by eson_wang on 11/2/15.
 */
public class CourseDaoImp implements CourseDao{
    private SessionManager sessionManager = new SessionManager();
    SessionFactory sessionFactory = sessionManager.createSessionFactory();

    List<Course> courses;

    public CourseDaoImp(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
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
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCourse(Course course, String id) {
        try {
            Session session = sessionFactory.openSession();//need to throw exception
            session.beginTransaction();

            Query query = session.createQuery("update Course C set C  = :C where C.courseId = :courseId");
            query.setParameter("C", course);
            query.setParameter("courseId", id);

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
    public boolean deleteCourse(Course course) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete from Course R where R.courseId = :courseId");
            query.setParameter("courseId", course.getCourseId());
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
