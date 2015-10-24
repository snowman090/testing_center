package core.controller;

import core.user.AuthenticationService;
import core.user.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController{
    @Autowired
    private AuthenticationService authenticationService;//injected service

    private ModelAndView model = new ModelAndView();

    @RequestMapping("/authorizing")
    public String authorizing (@RequestParam("netId") String userId,
                               @RequestParam("password") String password) {
        Authorization authorization = authenticationService.login(userId, password);
        if (authorization != null) {
                //code here to determine user permission
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
            return "redirect:/home";
        }else {
            if (authenticationService.registeredUserId(userId)) {
                model.addObject("error-message", StringResources.LOGIN_PASSWORD_ERROR);
            }else {
                model.addObject("error-message", StringResources.LOGIN_USER_ERROR);
            }

            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView goToHome () {
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginForm () {
        ModelAndView model = new ModelAndView("login");
        return model;
    }
}
