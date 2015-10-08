package core.user;

import java.util.List;

public interface InstructorDao {
    List<Instructor> findAll();
    List<Instructor> findByNetID();
    boolean insertInstructor(Instructor instructor);
    boolean updateInstructor(Instructor instructor);
    boolean deleteInstructor(Instructor instructor);
}
