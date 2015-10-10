package core.event;

import java.util.List;

public interface CourseDao {

    List<Course> findByCourseId();

    boolean addCourse(Course course);

    boolean updateCourse(Course course, String id);

    boolean deleteCourse(String course);

}
