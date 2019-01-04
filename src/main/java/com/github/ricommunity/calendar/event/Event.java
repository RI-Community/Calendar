package com.github.ricommunity.calendar.event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String date;
	private String time;
	private String address;
	private String information;
	private String link;

	public Event() {
		this("Kein Termin gefunden","1.1.1970","01:30 Uhr","","","", 0L);
	}
		public Event(String title, String date, String time, String address, String information, String link, Long id) {
		this.title = title;
		this.date = date;
		this.time = time;
		this.address = address;
		this.information = information;
		this.link = link;
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	public long getId() {
		return id;
	}
	
	

}
