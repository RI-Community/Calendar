package com.github.ricommunity.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.ricommunity.calendar.event.Event;
import com.github.ricommunity.calendar.event.EventService;

@Controller
public class WebController {
	
	@Autowired
	private EventService eventService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("events", eventService.getEvents());
        model.addAttribute("id", "info");
        model.addAttribute("title", "RI-Community Calendar - Home");
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("id", "admin");
        model.addAttribute("title", "Adminpanel");
        return "admin";
    }

    @GetMapping("/admin/{id}")
    public String adminEdit(Model model, @PathVariable("id") int id) {
    	Event event = eventService.getEvent(id);
        model.addAttribute("id", "admin");
        model.addAttribute("title", "Adminpanel");
        model.addAttribute("event", event);
        return "admin";
    }

    @PostMapping("/admin")
    public String saveEvent(@ModelAttribute Event event, Model model) {
    	eventService.addEvent(event);
        model.addAttribute("id", "event");
        model.addAttribute("events", eventService.getEvent(event.getId()));
        return "events";
    }

    @GetMapping("/events")
    public String events(Model model) {
        model.addAttribute("id", "events");
        model.addAttribute("events", eventService.getEvents());
        return "events";
    }

    @GetMapping("/events/{id}")
    public String event(Model model, @PathVariable("id") int id) {
        model.addAttribute("id", "events");
        model.addAttribute("events", eventService.getEvent(id));
        return "events";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("id", "login");
        model.addAttribute("title", "Login");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "login";
    }

}
