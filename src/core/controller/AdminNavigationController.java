package core.controller;

import core.event.AppointmentDao;
import core.event.ReservationDao;
import core.service.TestingCenterInfoRetrieval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class AdminNavigationController {
    @Autowired
    private TestingCenterInfoRetrieval infoRetrieval;
    @Autowired
    private ReservationDao reservationAccess;
    @Autowired
    private AppointmentDao appointmentDao;

    private ModelMap model = new ModelMap();

    private String viewName = "admin-home";

    /**
     * this is a controller method for view and edit information
     * this functionality is for administrator only
     * @return
     */
    @RequestMapping("/view-info")
    public String viewCenterInfo() {
        model.clear();
        //set the heading to that of view information page
        model.addAttribute("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("viewInfo"));
        //infoRetrieval method will get a Map of testing center information
        model.addAttribute("main_content", infoRetrieval.retrieveInfo());
        return viewName;
    }

    /**
     * This method implements administrator's functionality for uploading
     * a file containing all users.
     * @return
     */
    @RequestMapping("/upload")
    public String uploadFile() {
        model.clear();
        model.addAttribute("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("uploadFile"));
        return viewName;
    }

    @RequestMapping("/view-requests")
    public String viewRequests() {
        model.clear();
        model.addAttribute("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("viewRequest"));
        /*by default, when the user enters the page all requests are displayed in chronological order
        by selecting different tabs on top of the list, the user is able to view the list
        in different orders: by alphabetical order of instructors' last names, number of attendants,
        utilization, or, display only the ones made by one instructor by search the instructor's name*/
        model.addAttribute("main_content", reservationAccess.findAll());
        return viewName;
    }

    @RequestMapping("/view-appointments")
    public String viewAppointments() {
        model.clear();
        model.addAttribute("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("viewAppointments"));
        model.addAttribute("main_content", appointmentDao.findAllAppointment());
        return viewName;
    }

    @RequestMapping("/make-appointment")
    public String makeAppointment() {
        model.clear();
        model.addAttribute("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("makeAppointment"));
        return viewName;
    }

    @RequestMapping("/check-in")
    public String checkIn() {
        model.clear();
        model.addAttribute("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("checkIn"));
        return viewName;
    }

    @RequestMapping("/generate-report")
    public String generateReport() {
        model.clear();
        model.addAttribute("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("generateReport"));
        return viewName;
    }
}