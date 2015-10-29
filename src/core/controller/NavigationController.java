package core.controller;

import core.service.TestingCenterInfoRetrieval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class NavigationController {
    @Autowired
    private TestingCenterInfoRetrieval infoRetrieval;

    /**
     * this is a controller method for view and edit information
     * this functionality is for administrator only
     * @return
     */
    @RequestMapping("/view-info")
    public ModelAndView viewCenterInfo() {
        ModelAndView model = new ModelAndView("edit-info");
        model.addObject("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("viewInfo"));
        //infoRetrieval method will get a Map of testing center information
        model.addObject("center_info", infoRetrieval.retrieveInfo());
        return model;
    }

    @RequestMapping("/upload")
    public ModelAndView uploadFile() {
        return null;
    }

    @RequestMapping("/view-requests")
    public ModelAndView viewRequests() {
        return null;
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