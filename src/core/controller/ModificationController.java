package core.controller;

import core.service.TestingCenterInfoRetrieval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * this method is called when a information cell is clicked and
     * the user is then allowed to change the contents of the fields of
     * testing center information
     * @return
     */
    @RequestMapping(value = "/edit-info-form", method = RequestMethod.GET)
    public ModelAndView editTestingCenterInfo (){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/edit-info-submit", method = RequestMethod.POST)
    public ModelAndView modifyRequest (){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
