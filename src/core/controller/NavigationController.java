package core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class NavigationController {
    @RequestMapping("view-info")
    public ModelAndView viewCenterInfo () {
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
}
