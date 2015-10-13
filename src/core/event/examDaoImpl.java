package core.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eson_wang on 10/12/15.
 */
public class examDaoImpl implements examDao{
    List<exam> exams;
    public examDaoImpl(){

        exams = new ArrayList<exam>();

    }

    @Override
    public List<exam> getAllExams() {
        return null;
    }

    @Override
    public List<exam> findByexamId(String examId) {
        return null;
    }

    @Override
    public boolean addExam(exam exam) {// return should have different cases
        exams.add(exam);
        return true;
    }

    @Override
    public boolean updateExam(exam exam, String examId) {
        return false;
    }

    @Override
    public boolean deleteCExam(String examId) {
        return false;
    }


}
