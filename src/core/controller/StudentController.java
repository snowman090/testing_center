package core.controller;

import core.event.AppointmentDao;
import core.event.ReservationDao;
import core.service.TestingCenterInfoRetrieval;
import core.user.Authorization;
import core.user.SessionProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @Autowired
    private TestingCenterInfoRetrieval infoRetrieval;
    @Autowired
    private ReservationDao reservationAccess;
    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    private SessionProfile profile;

    private ModelMap model = new ModelMap();

    private String viewName;

    @RequestMapping("/student-view-appointments")
    public String viewAppointments() {
        String netId = profile.getUserId();
        model.clear();
        model.addAttribute("main_content", appointmentDao.findAllByStudent(netId));
        return viewName;
    }

    @RequestMapping("/student-make-appointment")
    public String makeAppointment() {
        model.clear();
        model.addAttribute("page_heading",
                StringResources.STUDENT_OPERATIONS.get("makeAppointment"));
        return viewName;
    }
}