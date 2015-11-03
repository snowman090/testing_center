package core.event;

import core.user.Instructor;

import java.util.List;

/**
 * Created by zeqing on 11/2/2015.
 */
public interface ExamDao {
    public List<Exam> getAllExams();

    public Exam findByExamId(String examId);

    public List<Exam> findByInStructorId(String instructorId);

    public boolean addExam(Exam exam);

    public boolean updateExam(Exam exam, String id);

    public boolean deleteExam(Exam exam);

}
