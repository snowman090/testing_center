package core.controller;

import core.event.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class ViewOptionsController {
    @Autowired
    private ReservationDao reservationAccess;


    @RequestMapping("/{list-type}/chrono")
    public ModelAndView viewByChronology(@PathVariable("list-type") String listType){
        ModelAndView model = new ModelAndView();
        return model;
    }
}
