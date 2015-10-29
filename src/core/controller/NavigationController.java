package core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class NavigationController {
    @RequestMapping("view-info")
    public String viewCenterInfo () {
        ModelMap model = new ModelMap();
        model.addAttribute("page_heading",
                StringResources.ADMINISTRATOR_OPERATIONS.get("viewInfo"));
        return null;
    }

    @RequestMapping("upload")
    public ModelAndView uploadFile () {
        return null;
    }

    @RequestMapping("view-requests")
    public ModelAndView viewRequests () {
        return null;
    }

    @RequestMapping("view-appointments")
    public ModelAndView viewAppointments() {
        return null;
    }

    @RequestMapping("make-appointment")
    public ModelAndView makeAppointment() {
        return null;
    }
}