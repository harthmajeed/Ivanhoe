package testing;

import static org.junit.Assert.*;
import objects.Card;

import org.junit.Test;

public class cardConstructorTest {

	@Test
	public void test() {
		Card card = new Card("Yellow", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
		
		String color = "Yellow";
		int value = 3;
		boolean squire = false;
		boolean maiden = false;
		boolean unhorse = false;
		boolean changeWeapon = false;
		boolean dropWeapon = false;
		boolean sheild = false;
		boolean stunned = false;
		boolean ivanhoe = false;
		boolean breakLance = false;
		boolean riposte = false;
		boolean dodge = false;
		boolean retreat = false;
		boolean knockDown = false;
		boolean outmaneuver = false;
		boolean charge = false;
		boolean countercharge = false;
		boolean disgrace = false;
		boolean adapt = false;
		boolean outwit = false;
		
		assertEquals (color, card.getColor());
		assertEquals (value, card.getValue());
		assertEquals (squire, card.isSquire());
		assertEquals (maiden, card.isMaiden());
		assertEquals (unhorse, card.isUnhorse());
		assertEquals (changeWeapon, card.isChangeWeapon());
		assertEquals (dropWeapon, card.isChangeWeapon());
		assertEquals (sheild, card.isSheild());
		assertEquals (stunned, card.isStunned());
		assertEquals (ivanhoe, card.isIvanhoe());
		assertEquals (breakLance, card.isBreakLance());
		assertEquals (riposte, card.isRiposte());
		assertEquals (dodge, card.isDodge());
		assertEquals (retreat, card.isRetreat());
		assertEquals (knockDown, card.isKnockDown());
		assertEquals (outmaneuver, card.isOutmaneuver());
		assertEquals (charge, card.isCharge());
		assertEquals (countercharge, card.isCountercharge());
		assertEquals (disgrace, card.isDisgrace());
		assertEquals (adapt, card.isAdapt());
		assertEquals (outwit, card.isOutwit());
		
	}

}
