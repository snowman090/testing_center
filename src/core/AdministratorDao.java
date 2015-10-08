package core;




public interface AdministratorDao {


    // Import data.
    public void importData();

    // Import User.csv
    public boolean importUserCSV(String semester);

    // Import Class.csv
    public boolean importClassCSV(String semester);

    // Import Roster.csv
    public boolean importRoster(String semester);

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
