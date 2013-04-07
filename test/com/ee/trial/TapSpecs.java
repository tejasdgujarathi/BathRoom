package com.ee.trial;

import static org.junit.Assert.*;

import org.junit.Test;

public class TapSpecs {
	@Test
	public void itSendsWaterFromTap() {
		// Given
		Tap tap = new Tap();
		// When
		String water = tap.sendWater();
		// Then
		assertEquals("water", water);
	}

}
