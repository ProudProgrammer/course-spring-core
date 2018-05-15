package hu.course.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;

import hu.course.spring.core.types.EventType;

public class Event {

	private int id;
	private String msg;
	private Date date;
	private DateFormat df;
	private EventType eventType;

	public Event() {
		id = (int) (Math.random() * 1000);
	}

	public Event(Date date, DateFormat df) {
		this();
		this.date = date;
		this.df = df;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DateFormat getDf() {
		return df;
	}

	public void setDf(DateFormat df) {
		this.df = df;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", msg=" + msg + ", date=" + df.format(date) + ", eventType=" + eventType + "]";
	}

}
