package core.event;

import java.util.List;

/**
 * Created by zeqing on 11/2/2015.
 */
public interface ExamDao {
    public List<Exam> getAllExams()  ;


    public Exam findByExamId(String examId);


    public boolean addExam(Exam exam);

    public boolean updateExam(Exam exam, String examId);

    public boolean deleteCExam(String examId);

}
