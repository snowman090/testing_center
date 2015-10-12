package core.event;

import java.util.List;

/**
 * Created by eson_wang on 10/11/15.
 */
public interface examDao {
    List<exam> getAllExams ();

    List<exam> findByexamId(String examId);

    boolean addExam(exam exam);

    boolean updateExam(exam exam, String examId);

    boolean deleteCExam(String examId);




}