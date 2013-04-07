package com.ee.trial;

public class LeftFaucet {

	private Tap tap;
	private Shower shower;
	private String waterType = "cold";

	public LeftFaucet(Tap tap, Shower shower) {
		this.tap = tap;
		this.shower = shower;
	}

	public String turn() {
		String water;
		if (shower.isOn()) {
			water = waterType +" "+ shower.sendWater()+ " ";
		} else {
			water = waterType +" "+ tap.sendWater()+ " ";
		}
		return water;
	}

}
