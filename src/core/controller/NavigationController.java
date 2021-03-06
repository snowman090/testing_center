//package core.controller;
//
//import core.event.AppointmentDao;
//import core.event.ReservationDao;
//import core.service.TestingCenterInfoRetrieval;
//import core.user.Authorization;
//import core.user.SessionProfile;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class NavigationController {
//    @Autowired
//    private TestingCenterInfoRetrieval infoRetrieval;
//    @Autowired
//    private ReservationDao reservationAccess;
//    @Autowired
//    private AppointmentDao appointmentDao;
//    @Autowired
//    private SessionProfile profile;
//
//    private ModelMap model = new ModelMap();
//
//    private String viewName;
//
//    /**
//     * this is a controller method for view and edit information
//     * this functionality is for administrator only
//     * @return
//     */
//    @RequestMapping(value = "/{permission}/view-info")
//    public String viewCenterInfo(@PathVariable("permission") Authorization permission) {
//        switch (permission) {
//            case ADMINISTRATOR:
//                model.clear();
//                //set the heading to that of view information page
//                model.addAttribute("page_heading",
//                        StringResources.ADMINISTRATOR_OPERATIONS.get("viewInfo"));
//                //infoRetrieval method will get a Map of testing center information
//                model.addAttribute("main_content", infoRetrieval.retrieveInfo());
//        }
//        return viewName;
//    }
//
//    /**
//     * This method implements administrator's functionality for uploading
//     * a file containing all users.
//     * @return
//     */
//    @RequestMapping("/{permission}/upload")
//    public String uploadFile(@PathVariable("permission") Authorization permission) {
//        switch (permission) {
//            case ADMINISTRATOR:
//                model.clear();
//                model.addAttribute("page_heading",
//                        StringResources.ADMINISTRATOR_OPERATIONS.get("uploadFile"));
//        }
//        return viewName;
//    }
//
//    @RequestMapping("/{permission}/view-requests")
//    public String viewRequests(@PathVariable("permission") Authorization permission) {
//        switch (permission) {
//            case ADMINISTRATOR:
//                model.clear();
//                model.addAttribute("page_heading",
//                        StringResources.ADMINISTRATOR_OPERATIONS.get("viewRequest"));
//                /*by default, when the user enters the page all requests are displayed in chronological order
//                by selecting different tabs on top of the list, the user is able to view the list
//                in different orders: by alphabetical order of instructors' last names, number of attendants,
//                utilization, or, display only the ones made by one instructor by search the instructor's name*/
//                model.addAttribute("main_content", reservationAccess.findAll());
//                break;
//            case INSTRUCTOR:
//                model.clear();
//                model.addAttribute("page_heading",
//                        StringResources.INSTRUCTOR_OPERATIONS.get("viewReservations"));
//                String netId = profile.getUserId();
//                model.addAttribute("main_content", reservationAccess.findByInstructorId(netId));
//        }
//        return viewName;
//    }
//
//    @RequestMapping("/{permission}/view-appointments")
//    public String viewAppointments(@PathVariable("permission") Authorization permission) {
//        String netId = profile.getUserId();
//        switch (permission) {
//            case ADMINISTRATOR:
//                model.clear();
//                model.addAttribute("page_heading",
//                        StringResources.ADMINISTRATOR_OPERATIONS.get("viewAppointments"));
//                model.addAttribute("main_content", appointmentDao.findAllAppointment());
//                break;
//
//            case STUDENT:
//                model.clear();
//                model.addAttribute("page_heading",
//                        StringResources.STUDENT_OPERATIONS.get("viewAppointments"));
//                model.addAttribute("main_content", appointmentDao.findAllByStudent(netId));
//                break;
//        }
//        return viewName;
//    }
//
//    @RequestMapping("/{permission}/make-appointment")
//    public String makeAppointment(@PathVariable("permission") Authorization permission) {
//        switch (permission) {
//            case ADMINISTRATOR:
//                model.clear();
//                model.addAttribute("page_heading",
//                        StringResources.ADMINISTRATOR_OPERATIONS.get("makeAppointment"));
//            break;
//
//            case STUDENT:
//                model.clear();
//                model.addAttribute("page_heading",
//                        StringResources.STUDENT_OPERATIONS.get("makeAppointment"));
//        }
//        return viewName;
//    }
//
//    @RequestMapping("/{permission}/check-in")
//    public String checkIn(@PathVariable("permission") Authorization permission) {
//        if (permission == Authorization.ADMINISTRATOR) {
//            model.clear();
//            model.addAttribute("page_heading",
//                    StringResources.ADMINISTRATOR_OPERATIONS.get("checkIn"));
//        }
//        return viewName;
//    }
//
//    @RequestMapping("/{permission}/generate-report")
//    public String generateReport(@PathVariable("permission") Authorization permission) {
//        if (permission == Authorization.ADMINISTRATOR) {
//            model.clear();
//            model.addAttribute("page_heading",
//                    StringResources.ADMINISTRATOR_OPERATIONS.get("generateReport"));
//        }
//        return viewName;
//    }
//
//    @RequestMapping("/{permission}/schedule-event")
//    public String scheduleEvent(@PathVariable("permission") Authorization permission){
//        if (permission == Authorization.INSTRUCTOR) {
//            model.clear();
//            model.addAttribute("page_heading",
//                    StringResources.INSTRUCTOR_OPERATIONS.get("scheduleEvent"));
//        }
//        return viewName;
//    }
//}