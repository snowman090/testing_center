package core.user;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents ();
    List<Student> getStudentsByName (String firstName, String lastName);
    Student getStudentById (String Id);
    Authorization getPermission ();
    boolean updateInfo (Student student);
    boolean delete (Student student);
    boolean addStudent (Student student);
}
