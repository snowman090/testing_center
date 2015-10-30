package core.controller;

import core.service.TestingCenterInfoRetrieval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

/**
 * all actions concerning modifications of information
 * are directed to the methods in this controller class, including the
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
     * testing center information. To prompt the user to change the selected
     * field, a popup window will appear, asking for input for the specified
     * field.
     * @return
     */
    @RequestMapping(value = "/edit-info/{field-type}/form", method = RequestMethod.GET)
    public ModelAndView editTestingCenterInfo (@PathVariable("field-type") String fieldType){
        ModelAndView model = new ModelAndView("edit-info");
        model.addObject("modify-field", fieldType);
        return model;
    }

    /**
     * This method is called if the submit button is clicked indicating that the user
     * is ready to commit changes made to the selected field on testing center information
     * @return
     */
    @RequestMapping(value = "/edit-info/{field-type}/form-submit", method = RequestMethod.POST)
    public ModelAndView modifyRequestSubmit (@PathVariable("field-type") String fieldType,
                                             @RequestParam("modified_field") String modifiedField){
        ModelAndView modelAndView = new ModelAndView("edit-info");
        return modelAndView;
    }
}