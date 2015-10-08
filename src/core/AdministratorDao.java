package core;


import org.w3c.dom.Document;

public interface AdministratorDao {


    // Import data.
    public void importData();

    // Import User.csv
    public boolean importUserCSV(Document userCSV);

    // Import Class.csv
    public boolean importClassCSV(Document userCSV);

    // Import Roster.csv
    public boolean importRoster(Document userCSV);

    // Display Utilization
    public void displayUtilization();

    // Handle schedule request
    public void handleScheduleRequest();

    // Make appointment on behalf of a student
    public void makeApptOnBehalfOfStudent();

    // View Appointment
    public void viewAppointment();

    // Check-in Student
    public void checkInStudent();

    // Generate Report
    public void generateReport();

}
