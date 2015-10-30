package core.event;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.IllegalFormatException;

/**
 * Created by zeqing on 10/29/2015.
 */
public class Term {

    /**
     * Year 2015 -> 115x
     * Semester winter -> 1151
     *          spring -> 1154
     *          summer -> 1156
     *          fall   -> 1158
     * Year 2016 -> 116x
     * ...
     */
    private int termId;
    private String termName;
    private LocalDate termStartDate;
    private LocalDate termEndDate;

    public Term() {
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
        this.termName = termIdToName(termId);
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
        this.termId = termNameToId(termName);
    }

    public LocalDate getTermStartDate() {
        return termStartDate;
    }

    public void setTermStartDate(LocalDate termStartDate) {
        this.termStartDate = termStartDate;
    }

    public LocalDate getTermEndDate() {
        return termEndDate;
    }

    public void setTermEndDate(LocalDate termEndDate) {
        this.termEndDate = termEndDate;
    }

    // Convert Term Id to 'Semester Year' Format
    private String termIdToName(int termId){

        int year = (termId % 1000) / 10;
        int semId = termId % 10;
        String semester = "";
        switch (semId){
            case 1: semester = "Winter"; break;
            case 4: semester = "Spring"; break;
            case 6: semester = "Summer"; break;
            case 8: semester = "Fall"; break;
            default: semester = "Unknown Semester";
        }

        semester = semester + " " + String.valueOf(year);
        return semester;

    }

    // Convert 'Semester Year' Format to Term Id
    private int termNameToId(String termName){
        String[] s = termName.split(" ");
        String semester = s[0];
        int year = (Integer.valueOf(s[1])%100) * 10;
        int term = 1000 + year;

        switch (semester){
            case "Winter": term += 1; break;
            case "Spring": term += 4; break;
            case "Summer": term += 6; break;
            case "Fall": term += 8; break;
            default: term +=0;
        }
        return term;
    }
}
