package core.controller;

import core.event.form.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{
    @RequestMapping(value = "/home/{netId}", method = RequestMethod.POST)
    public ModelAndView loginSubmit (@RequestParam("netId") String userId, @RequestParam("password") String password) {
        ModelAndView model = new ModelAndView("home");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginForm () {
        ModelAndView model = new ModelAndView("login");
        return model;
    }
}
