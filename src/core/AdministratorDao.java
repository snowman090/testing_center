package core;


public interface AdministratorDao {


    // Import data.
    public void importData();

    // Import User.csv
    public boolean importUserCSV();

    // Import Class.csv
    public boolean importClassCSV();

    // Import Roster.csv
    public boolean importRoster();

    // Display Utilization
    public void displayUtilization();

    // Handle schedule request
    public void handleScheduleRequest();

    // Make appointment on behalf of a student
    public void makeApptOnBehalfOfStudent();

    // View Appointment
    public void viewAppointment();
    public void checkInStudent();
    public void generateReport();

}
