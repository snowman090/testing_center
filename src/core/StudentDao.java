package core;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents ();
    List<Student> getStudentsByName (String firstName, String lastName);
    Student getStudentById (String Id);
    Authorization getPermission ();
    void updateInfo (Student student);
    void delete (Student student);
}
