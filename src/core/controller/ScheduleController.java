package core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import java.util.Map;

@Controller
public class ScheduleController {
    @RequestMapping("schedule-event/submit")
    public ModelAndView SubmitScheduleRequestForm(@RequestParam Map<String, Object> allPrams) {
        ModelAndView model = new ModelAndView("schedule-event");
        model.addObject("message", "Schedule another event.");
        

        return model;
    }
}
