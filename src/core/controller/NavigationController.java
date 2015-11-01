package core.controller;

import core.event.ReservationDao;
import core.service.TestingCenterInfoRetrieval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class NavigationController {
    @Autowired
    private TestingCenterInfoRetrieval infoRetrieval;
    @Autowired
    private ReservationDao reservationAccess;

    /**
     * this is a controller method for view and edit information
     * this functionality is for administrator only
     * @return
     */
    @RequestMapping("/view-info")
    public ModelAndView viewCenterInfo() {
        ModelAndView model = new ModelAndView("edit-info");
        //set the heading to that of view information page
        model.addObject("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("viewInfo"));
        //infoRetrieval method will get a Map of testing center information
        model.addObject("center_info", infoRetrieval.retrieveInfo());
        return model;
    }

    /**
     * This method implements administrator's functionality for uploading
     * a file containing all users.
     * @return
     */
    @RequestMapping("/upload")
    public ModelAndView uploadFile() {
        ModelAndView model = new ModelAndView("upload-file");
        model.addObject("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("uploadFile"));
        return model;
    }

    @RequestMapping("/view-requests")
    public ModelAndView viewRequests() {
        ModelAndView model = new ModelAndView("view-requests");
        model.addObject("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("viewRequest"));
        //by default, when the user enters the page all requests are displayed in chronological order
        //by selecting different tabs on top of the list, the user is able to view the list
        //in different orders: by alphabetical order of instructors' last names, number of attendants,
        //utilization
        model.addObject("all_requests", reservationAccess.findAll());
        return model;
    }

    @RequestMapping("/view-appointments")
    public ModelAndView viewAppointments() {
        return null;
    }

    @RequestMapping("/make-appointment")
    public ModelAndView makeAppointment() {
        return null;
    }
}