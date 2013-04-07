package com.ee.trial;

public class Shower {

	private String showerState = "OFF";

	public void turnOff() {
		showerState = "OFF";
	}

	public void turnOn() {
		showerState = "ON";
	}

	public String sendWater() {
		return "water";
	}

	public boolean isOn() {
		return showerState.equalsIgnoreCase("ON") ? true : false;
	}

}
