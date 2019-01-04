package com.github.ricommunity.calendar.event;

public class Event {
	private String title;
	private String date;
	private String time;
	private String address;
	private String information;
	private String link;
	private int id;
	private static int nextId = 1;

	public Event() {
		this("Kein Termin gefunden","1.1.1970","01:30 Uhr","","","", nextId++);
	}
		public Event(String title, String date, String time, String address, String information, String link, int id) {
		this.title = title;
		this.date = date;
		this.time = time;
		this.address = address;
		this.information = information;
		this.link = link;
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
	public int getId() {
		return id;
	}
	
	

}
