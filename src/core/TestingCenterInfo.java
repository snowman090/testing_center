package core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * This class holds Testing Center setting information
 * Created by Zeqli on 10/7/2015.
 */
public class TestingCenterInfo {
    int numSeats;
    int numSetAsideSeats;
    LocalTime tcOpen;
    LocalTime tcClose;
    LocalDate tcCloseBeginDate;
    LocalDate tcCloseEndDate;;
    LocalDateTime ETSExamBegin;
    LocalDateTime ETSExamEnd;
    int gap;
    int reminderInterval;

    //read information from file
    private void getInformation(){

    }

    //save information in file
    private void saveInformation(){

    }
}
