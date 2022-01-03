package objects;

import java.io.Serializable;

public class Card implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7825489310112182921L;
	private String color;
	private int value;
	private boolean squire;
	private boolean maiden;
	private boolean unhorse;
	private boolean changeWeapon;
	private boolean dropWeapon;
	private boolean sheild;
	private boolean stunned;
	private boolean ivanhoe;
	private boolean breakLance;
	private boolean riposte;
	private boolean dodge;
	private boolean retreat;
	private boolean knockDown;
	private boolean outmaneuver;
	private boolean charge;
	private boolean countercharge;
	private boolean disgrace;
	private boolean adapt;
	private boolean outwit;
	
/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////CONSTRUCTOR///////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public Card(String col, int val, boolean sq, boolean ma, boolean uh,
			boolean cw, boolean dw, boolean sh, boolean st, boolean i, boolean bl,
			boolean ri, boolean d, boolean re, boolean kd, boolean om, boolean ch,
	        boolean cch, boolean dg, boolean ad, boolean ow) {
		color = col;
		value = val;
		squire = sq;
		maiden = ma;
		unhorse = uh;
	    changeWeapon = cw;
		dropWeapon = dw;
		sheild = sh;
		stunned = st;
		ivanhoe = i;
		breakLance = bl;
		riposte = ri;
		dodge = d;
		retreat = re;
		knockDown = kd;
		outmaneuver = om;
		charge = ch;
		countercharge = cch;
		disgrace = dg;
		adapt = ad;
		outwit = ow;
	}

/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////Getters/Setters///////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isSquire() {
		return squire;
	}

	public void setSquire(boolean squire) {
		this.squire = squire;
	}

	public boolean isMaiden() {
		return maiden;
	}

	public void setMaiden(boolean maiden) {
		this.maiden = maiden;
	}

	public boolean isUnhorse() {
		return unhorse;
	}

	public void setUnhorse(boolean unhorse) {
		this.unhorse = unhorse;
	}

	public boolean isChangeWeapon() {
		return changeWeapon;
	}

	public void setChangeWeapon(boolean changeWeapon) {
		this.changeWeapon = changeWeapon;
	}

	public boolean isDropWeapon() {
		return dropWeapon;
	}

	public void setDropWeapon(boolean dropWeapon) {
		this.dropWeapon = dropWeapon;
	}

	public boolean isSheild() {
		return sheild;
	}

	public void setSheild(boolean sheild) {
		this.sheild = sheild;
	}

	public boolean isStunned() {
		return stunned;
	}

	public void setStunned(boolean stunned) {
		this.stunned = stunned;
	}

	public boolean isIvanhoe() {
		return ivanhoe;
	}

	public void setIvanhoe(boolean ivanhoe) {
		this.ivanhoe = ivanhoe;
	}

	public boolean isBreakLance() {
		return breakLance;
	}

	public void setBreakLance(boolean breakLance) {
		this.breakLance = breakLance;
	}

	public boolean isRiposte() {
		return riposte;
	}

	public void setRiposte(boolean riposte) {
		this.riposte = riposte;
	}

	public boolean isDodge() {
		return dodge;
	}

	public void setDodge(boolean dodge) {
		this.dodge = dodge;
	}

	public boolean isRetreat() {
		return retreat;
	}

	public void setRetreat(boolean retreat) {
		this.retreat = retreat;
	}

	public boolean isKnockDown() {
		return knockDown;
	}

	public void setKnockDown(boolean knockDown) {
		this.knockDown = knockDown;
	}

	public boolean isOutmaneuver() {
		return outmaneuver;
	}

	public void setOutmaneuver(boolean outmaneuver) {
		this.outmaneuver = outmaneuver;
	}

	public boolean isCharge() {
		return charge;
	}

	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	public boolean isCountercharge() {
		return countercharge;
	}

	public void setCountercharge(boolean countercharge) {
		this.countercharge = countercharge;
	}

	public boolean isDisgrace() {
		return disgrace;
	}

	public void setDisgrace(boolean disgrace) {
		this.disgrace = disgrace;
	}

	public boolean isAdapt() {
		return adapt;
	}

	public void setAdapt(boolean adapt) {
		this.adapt = adapt;
	}

	public boolean isOutwit() {
		return outwit;
	}

	public void setOutwit(boolean outwit) {
		this.outwit = outwit;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////methods/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getCardName(){
		if(this.isSquire())
			return "Squire";
		if(this.isMaiden())
			return "Maiden";
		if(this.isDodge())
			return "Dodge";
		if(this.isDisgrace())
			return "Disgrace";
		if(this.isRetreat())
			return "Retreat";
		if(this.isRiposte())
			return "Riposte";
		if(this.isOutmaneuver())
			return "Outmaneuver";
		if(this.isCountercharge())
			return "Counter-charge";
		if(this.isCharge())
			return "Charge";
		if(this.isBreakLance())
			return "Break Lance";
		if(this.isAdapt())
			return "Adapt";
		if(this.isDropWeapon())
			return "Drop weapon";
		if(this.isChangeWeapon())
			return "Change weapon";
		if(this.isUnhorse())
			return "Unhorse";
		if(this.isKnockDown())
			return "Knock down";
		if(this.isOutwit())
			return "Outwit";
		if(this.isSheild())
			return "Sheild";
		if(this.isStunned())
			return "Stunned";
		if(this.isIvanhoe())
			return "Ivanhoe";
		return "regular";
	}
	
	
}
