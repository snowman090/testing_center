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
public class InstructorController {
    @Autowired
    private TestingCenterInfoRetrieval infoRetrieval;
    @Autowired
    private ReservationDao reservationAccess;
    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    private SessionProfile profile;

    private ModelMap model = new ModelMap();

    private String viewName = StringResources.ADMIN_VIEW_NAME;

    @RequestMapping("/INSTRUCTOR/view-requests")
    public String viewRequests() {
        model.clear();
        model.addAttribute("page_heading",
                StringResources.INSTRUCTOR_OPERATIONS.get("viewReservations"));
        String netId = profile.getUserId();
        model.addAttribute("main_content", reservationAccess.findByInstructorId(netId));
        return viewName;
    }

    @RequestMapping("/INSTRUCTOR/schedule-event")
    public String scheduleEvent(){
        model.clear();
        model.addAttribute("page_heading",
                StringResources.INSTRUCTOR_OPERATIONS.get("scheduleEvent"));
        return viewName;
    }
}