package core.event;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class ExamDaoImp implements ExamDao{
    List<Exam> exams;
    public ExamDaoImp() {

        exams = new ArrayList<Exam>();
    }
    @Override
    public List<Exam> getAllExams() {
        return exams;
    }

    @Override
    public List<Exam> findByexamId(String examId) {
        return null;
    }
    public exam findByExamId(String examId) {
        return exams.get(Integer.parseInt(examId));
    }



    @Override
    public boolean addExam(Exam exam) {// return should have different cases
        exams.add(exam);
        return true;
    }

    @Override
    public boolean updateExam(Exam exam, String examId) {
        return false;
    }

    @Override
    public boolean deleteCExam(String examId) {
        return false;
    }


}
