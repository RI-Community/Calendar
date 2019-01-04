package com.github.ricommunity.calendar;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @GetMapping("/")
    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        Event event = new Event();
        List<Event> events = Arrays.asList(event);
        model.addAttribute("events", events);
        return "home";
    }

}
