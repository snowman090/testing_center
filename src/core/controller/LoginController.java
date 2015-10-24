package core.controller;

import core.user.AuthenticationService;
import core.user.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginForm () {
        model.setViewName("login");
        return model;
    }
}
