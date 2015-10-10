package core.event;

import core.user.Authorization;
import core.user.Instructor;

import java.util.List;

public interface CourseDao {

    List<Course> findByCourseId();

    List<Course> findByNetID(String InstructorID);

    Authorization getPermission();

    boolean insertCourse(Course course);

    boolean updateCourse(Course course);

    boolean deleteCourse(Course course);

}
