package core.controller;

import core.user.Authorization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping("/home/{permission}")
    public ModelAndView goToHome (@PathVariable("permission") Authorization authorization) {
        ModelAndView model = new ModelAndView();
        Map<String, Object> viewVariables = new HashMap<>();
        switch (authorization) {
            case ADMINISTRATOR:
                viewVariables.put("user-level", StringResources.USER_ADMINISTRATOR);
                viewVariables.put("operations", StringResources.ADMINISTRATOR_OPERATIONS);
                    /*...*/
                break;
            case STUDENT:
                viewVariables.put("user-level", StringResources.USER_STUDENT);
                viewVariables.put("operations", StringResources.STUDENT_OPERATIONS);
                    /*...*/
                break;
            case INSTRUCTOR:
                viewVariables.put("user-level", StringResources.USER_INSTRUCTOR);
                viewVariables.put("operations", StringResources.INSTRUCTOR_OPERATIONS);
                    /*...*/
                break;
        }
        //add all objects to the model
        model.addAllObjects(viewVariables);
        return model;
    }
}
