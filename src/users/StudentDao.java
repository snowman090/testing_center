package users;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();
    List<Student> getStudentsByName (String firstName, String lastName);
    Student getStudentById (String Id);
}
