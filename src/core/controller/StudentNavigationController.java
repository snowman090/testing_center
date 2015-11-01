package core.controller;

import core.event.AppointmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class StudentNavigationController {
    private ModelMap model = new ModelMap();
    @Autowired
    private AppointmentDao appointmentDao;


}
