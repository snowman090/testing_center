package core.controller;

import core.service.TestingCenterInfoRetrieval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 * all actions concerning modifications of information
 * are directed to the methods in this class, including the
 * modifications and cancellations of requests, appointments,
 * as well as testing center information
 */
@Controller
public class ModificationController {
    @Autowired
    private TestingCenterInfoRetrieval infoRetrieval;

    @RequestMapping("edit-info-submit")
    public ModelAndView editTestingCenterInfo (){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping("modify-request-submit")
    public ModelAndView modifyRequest (){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
