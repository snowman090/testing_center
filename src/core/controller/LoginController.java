package core.controller;

import core.service.AuthenticationService;
import core.user.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{
    @Autowired
    private AuthenticationService authenticationService;//injected service

    private ModelMap model = new ModelMap();

    @RequestMapping(value = "/authorizing", method = RequestMethod.POST)
    public String authorizing (@RequestParam("netId") String userId,
                               @RequestParam("password") String password) {
        Authorization authorization = authenticationService.login(userId, password);
        if (authorization != null) {
            return "redirect:/home";
        }else {
            if (authenticationService.registeredUserId(userId)) {
                model.addAttribute("error-message", StringResources.LOGIN_PASSWORD_ERROR);
            }else {
                model.addAttribute("error-message", StringResources.LOGIN_USER_ERROR);
            }

            return "redirect:/login";
        }
    }
}
