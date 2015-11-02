package core.event;

import java.util.List;

/**
 * Created by eson_wang on 10/11/15.
 */
public interface ExamDao {
    List<Exam> getAllExams ();

    Exam findByExamId(String examId);

    boolean addExam(Exam exam);

    boolean updateExam(Exam exam, String examId);

    boolean deleteCExam(String examId);




}