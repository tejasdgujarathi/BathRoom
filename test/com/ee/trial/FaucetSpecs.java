package com.ee.trial;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ee.trial.LeftFaucet;
import com.ee.trial.RightFaucet;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FaucetSpecs {

	@Test
	public void itSendsHotWaterWhenRightFaucetIsTurned() {
		// Given
		Tap tap = new Tap();
		Shower shower = new Shower();
		RightFaucet rightFaucet = new RightFaucet(tap,shower); 
		// When
		String hotWater = rightFaucet.turn();
		// Then
		assertEquals("hot water ", hotWater);
	}

	@Test
	public void itSendsColdWaterWhenLeftFaucetIsTurned() {
		// Given
		Tap tap = new Tap();
		LeftFaucet leftFaucet = new LeftFaucet(tap,shower); 
		// When
		String coldWater = leftFaucet.turn();
		// Then
		assertEquals("cold water ", coldWater);	}
	
	@Mock Tap tap;
	@Test
	public void itSendsHotWaterFromTapWhenRightFaucetIsTurned() {
		// Given
		Shower shower = new Shower();
		RightFaucet rightFaucet = new RightFaucet(tap,shower); 
		// When
		when(tap.sendWater()).thenReturn("water");
		String hotWater = rightFaucet.turn();
		// Then
		verify(tap).sendWater();
		assertEquals("hot water ", hotWater);
	}

	@Test
	public void itSendsColdWaterFromTapWhenLeftFaucetIsTurned() {
		// Given
		LeftFaucet leftFaucet = new LeftFaucet(tap,shower); 
		// When
		when(tap.sendWater()).thenReturn("water");
		String coldWater = leftFaucet.turn();
		// Then
		verify(tap).sendWater();
		assertEquals("cold water ", coldWater);
	}
	
	@Mock Shower shower;
	@Test
	public void itSendsHotWaterFromShowerWhenRightFaucetIsTurnedAndShowerFaucetIsOn() {
		// Given
		RightFaucet rightFaucet = new RightFaucet(tap,shower); 
		// When
		when(shower.isOn()).thenReturn(true);
		when(shower.sendWater()).thenReturn("water");
		String hotWater = rightFaucet.turn();
		// Then
		verify(shower).sendWater();
		assertEquals("hot water ", hotWater);
	}

	@Test
	public void itSendsColdWaterFromShowerWhenLeftFaucetIsTurnedAndShowerFaucetIsOn() {
		// Given
		LeftFaucet leftFaucet = new LeftFaucet(tap,shower); 
		// When
		when(shower.isOn()).thenReturn(true);
		when(shower.sendWater()).thenReturn("water");
		String hotWater = leftFaucet.turn();
		// Then
		verify(shower).sendWater();
		assertEquals("cold water ", hotWater);
	}
	
	@Mock Tap tap1;
	@Test
	public void itSendsLukeWarnWaterFromTapWhenLeftFaucetAndRightFaucetIsTurnedAndShowerFaucetIsOff() {
		// Given
		LeftFaucet leftFaucet = new LeftFaucet(tap,shower); 
		RightFaucet rightFaucet = new RightFaucet(tap, shower);
		// When
		when(shower.isOn()).thenReturn(false);
		when(tap.sendWater()).thenReturn("water");
		String hotWater = leftFaucet.turn();
		hotWater += rightFaucet.turn();
		// Then
		verify(tap,times(2)).sendWater();
		verify(tap1,times(0)).sendWater();
		assertEquals("cold water hot water ", hotWater);
	}

}
