package com.github.ricommunity.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.ricommunity.calendar.event.EventService;

@Controller
public class WebController {
	
	@Autowired
	private EventService eventService;

    @GetMapping("/")
    public String home(Model model) {
        
        model.addAttribute("events", eventService.getEvents());
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

}
