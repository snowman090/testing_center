package core.controller;

import core.event.form.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController{

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm (Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit (@ModelAttribute Login login, Model model) {
        model.addAttribute("login", login);
        return "login";
    }
}
