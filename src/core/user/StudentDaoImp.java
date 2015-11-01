package core.user;

import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao{
    private List<Student> students;

    public StudentDaoImp(){
        students = new ArrayList<Student>();
        Student student1 = new Student();
        Student student2 = new Student();
        students.add(student1);
        students.add(student2);
    }

    @Override
    public boolean addStudent(Student student) {// return should have different cases
        students.add(student);
        return true;
    }

    @Override
    public boolean deleteStudent(Student student) {// return should have different cases
        students.remove(student);
        return true;
    }

    //retrive list of students from the database
    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public List<Student> getStudentsByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Student getStudentById(int Id) {
        return students.get(Id);
    }

    @Override
    public Authorization getPermission() {
        return null;
    }

    @Override
    public boolean updateInfo(Student student) {// return should have different cases
//        students.get(student.getStudent_Id()).setName(student.getName());
//        return true;
        return false;
    }




}
