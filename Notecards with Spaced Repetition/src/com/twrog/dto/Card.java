package com.twrog.dto;

public class Card {
	private String front;
	private String back;
	private byte cycleThreshold;
	private byte cycleCounter;
	private byte priority;
	
	public Card(String front, String back) {
		this.front = front;
		this.back = back;
		cycleThreshold = 0;
		cycleCounter = 0;
		priority = 1;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public byte getCycleThreshold() {
		return cycleThreshold;
	}

	public void setCycleThreshold(byte cycleThreshold) {
		this.cycleThreshold = cycleThreshold;
	}

	public byte getCycleCounter() {
		return cycleCounter;
	}

	public void setCycleCounter(byte cycleCounter) {
		this.cycleCounter = cycleCounter;
	}

	public byte getPriority() {
		return priority;
	}

	public void setPriority(byte priority) {
		this.priority = priority;
	}

}
