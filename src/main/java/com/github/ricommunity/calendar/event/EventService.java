package com.github.ricommunity.calendar.event;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventService {
	
	public List<Event> getEvents() {
		Event event = new Event();
        List<Event> events = Arrays.asList(event);
		return events;
	}

}
