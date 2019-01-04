package com.github.ricommunity.calendar.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

//	private Map<Long, Event> events;
	
	@Autowired
	private EventRepository eventRepository;

	public EventService() {
//		events = new HashMap<Long, Event>();
//		Event event = new Event();
//		events.put(event.getId(), event);
	}

	public Iterable<Event> getEvents() {
		return eventRepository.findAll();
	}

	public Event getEvent(long index) {
		Event event = null;
		try {
			event = eventRepository.findById(index);
		} catch (Exception e) {
		}
		if (event == null) {
			event = new Event();
		}
		return event;
	}

	public Event addEvent(Event event) {
		return eventRepository.save(event);
	}

}
