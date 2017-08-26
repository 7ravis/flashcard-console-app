package com.twrog.dto;

public class Card {
	private String front;
	private String back;
	private int cycleThreshold;
	private int cycleCounter;
	private int priority;
	
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

	public int getCycleThreshold() {
		return cycleThreshold;
	}

	public void setCycleThreshold(int cycleThreshold) {
		this.cycleThreshold = cycleThreshold;
	}

	public int getCycleCounter() {
		return cycleCounter;
	}

	public void setCycleCounter(int cycleCounter) {
		this.cycleCounter = cycleCounter;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
