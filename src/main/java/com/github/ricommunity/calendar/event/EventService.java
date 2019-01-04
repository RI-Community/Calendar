package com.github.ricommunity.calendar.event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EventService {

	private Map<Integer, Event> events;

	public EventService() {
		events = new HashMap<Integer, Event>();
//		Event event = new Event();
//		events.put(event.getId(), event);
	}

	public Collection<Event> getEvents() {
		return events.values();
	}

	public Event getEvent(int index) {
		Event event = null;
		try {
			event = events.get(index);
		} catch (Exception e) {
		}
		if (event == null) {
			event = new Event();
		}
		return event;
	}

	public void addEvent(Event event) {
		events.put(event.getId(), event);
	}

}
