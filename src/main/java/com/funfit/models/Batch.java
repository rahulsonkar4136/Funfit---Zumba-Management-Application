package com.funfit.models;

import java.util.List;

public class Batch {
	private int bid;
	private String name;
	private String time;
	private List<Participant> participants;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	 public List<Participant> getParticipants() {
	        return participants;
	    }

	    public void setParticipants(List<Participant> participants) {
	        this.participants = participants;
	    }
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}
	
	

}
