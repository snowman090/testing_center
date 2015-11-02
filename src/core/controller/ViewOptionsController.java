package core.controller;

import core.event.AppointmentDao;
import core.event.ExamDao;
import core.event.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class ViewOptionsController {
    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    private ExamDao examDao;

    @ModelAttribute
    public void commonObjects (Model model) {

    }

    @RequestMapping("/view-request/chrono")
    public ModelAndView viewByChronology(){
        ModelAndView model = new ModelAndView();

        return model;
    }
}
