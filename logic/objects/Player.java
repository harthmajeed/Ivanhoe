package objects;

import java.io.Serializable;
import java.util.ArrayList;

import objects.Game;

public class Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8769158828616370691L;
	static Game game;
	private String name; 
	private ArrayList<Card> hand;
	private int playedValue;
	private boolean myTurn;
	private boolean tournamentWinner;
	private boolean gameWinner;
	private boolean pToken;
	private boolean rToken;
	private boolean bToken;
	private boolean yToken; 
	private boolean gToken;
	private boolean forfiet;
	private Card lastCardPlayed;
	private ArrayList<Card> display;
	private boolean tournamentColorNeeded;
	private boolean maidenPlayed;
	private boolean tokenChoiceNeeded;
	private String chosenToken = null;
	private String newTournamentColor = null;
	private int targetPlayer = -1;
	private int chosenCard = -1;
	private ArrayList<Card> keptCards;
	private int givenCard = -1;
	private boolean sheilded;
	private boolean stunned;
	private boolean cardAddedToDisplay;
	private ArrayList<Card> faceUpCards;
	private int numTokens;
	private boolean hasPlayedCardThisTurn;
	//previous settings
	private ArrayList<Card> lastHand = new ArrayList<Card>();
	private int lastPlayedValue;
	private ArrayList<Card> lastDisplay = new ArrayList<Card>();
	private boolean lastMaidenPlayed;
	private boolean lastSheilded;
	private boolean lastStunned;
	private ArrayList<Card> lastFaceUpCards = new ArrayList<Card>();
	
	

/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////CONSTRUCTOR///////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public Player(String name, Game game) {
		Player.game = game; 
		this.name = name;
		setHand(new ArrayList<Card>());
		setDisplay(new ArrayList<Card>());
		setFaceUpCards(new ArrayList<Card>());
		playedValue = 0;
		myTurn = false;
		tournamentWinner = false;
		gameWinner = false;
		pToken = false;
		rToken = false;
		bToken = false;
		yToken = false; 
		gToken = false;
		forfiet = false;
		setTournamentColorNeeded(false);
		setMaidenPlayed(false);
		setSheilded(false);
		setStunned(false);
		setTokenChoiceNeeded(false);
		setNumTokens(0);
		setHasPlayedCardThisTurn(false);
	}

/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////Getters/Setters///////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayedValue() {
		return playedValue;
	}

	public void setPlayedValue(int playedValue) {
		this.playedValue = playedValue;
	}

	public boolean isMyTurn() {
		return myTurn;
	}

	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}

	public boolean isTournamentWinner() {
		return tournamentWinner;
	}

	public void setTournamentWinner(boolean tournamentWinner) {
		this.tournamentWinner = tournamentWinner;
	}

	public boolean isGameWinner() {
		return gameWinner;
	}

	public void setGameWinner(boolean gameWinner) {
		this.gameWinner = gameWinner;
	}

	public boolean hasPToken() {
		return pToken;
	}

	public void setpToken(boolean pToken) {
		this.pToken = pToken;
	}

	public boolean hasRToken() {
		return rToken;
	}

	public void setrToken(boolean rToken) {
		this.rToken = rToken;
	}

	public boolean hasBToken() {
		return bToken;
	}

	public void setbToken(boolean bToken) {
		this.bToken = bToken;
	}

	public boolean hasYToken() {
		return yToken;
	}

	public void setyToken(boolean yToken) {
		this.yToken = yToken;
	}

	public boolean hasGToken() {
		return gToken;
	}

	public void setgToken(boolean gToken) {
		this.gToken = gToken;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public boolean isForfiet() {
		return forfiet;
	}

	public void setForfiet(boolean forfiet) {
		this.forfiet = forfiet;
	}
	
	public Card getLastCardPlayed() {
		return lastCardPlayed;
	}

	public void setLastCardPlayed(Card lastCardPlayed) {
		this.lastCardPlayed = lastCardPlayed;
	}
	
	public ArrayList<Card> getDisplay() {
		return display;
	}

	public void setDisplay(ArrayList<Card> display) {
		this.display = display;
	}
	
	
	public boolean isMaidenPlayed() {
		return maidenPlayed;
	}

	public void setMaidenPlayed(boolean maidenPlayed) {
		this.maidenPlayed = maidenPlayed;
	}
	
	public String getChosenToken() {
		return chosenToken;
	}
	
	public void setChosenToken(String color){
		chosenToken = color;
	}
	
	
	public String getNewTournamentColor() {
		return newTournamentColor;
	}

	public void setNewTournamentColor(String newTournamentColor) {
		this.newTournamentColor = newTournamentColor;
	}
	
	public int getTargetPlayer() {
		return targetPlayer;
	}

	public void setTargetPlayer(int targetPlayer) {
		this.targetPlayer = targetPlayer;
	}
	
	public int getChosenCard() {
		return chosenCard;
	}

	public void setChosenCard(int chosenCard) {
		this.chosenCard = chosenCard;
	}
	
	public ArrayList<Card> getKeptCards() {
		return keptCards;
	}

	public void setKeptCards(ArrayList<Card> keptCards) {
		this.keptCards = keptCards;
	}
	
	public int getGivenCard() {
		return givenCard;
	}

	public void setGivenCard(int givenCard) {
		this.givenCard = givenCard;
	}
	
	public boolean isSheilded() {
		return sheilded;
	}

	public void setSheilded(boolean sheilded) {
		this.sheilded = sheilded;
	}
	
	public boolean isStunned() {
		return stunned;
	}

	public void setStunned(boolean stunned) {
		this.stunned = stunned;
	}
	
	public boolean isCardAddedToDisplay() {
		return cardAddedToDisplay;
	}

	public void setCardAddedToDisplay(boolean cardAddedToDisplay) {
		this.cardAddedToDisplay = cardAddedToDisplay;
	}
	
	public ArrayList<Card> getFaceUpCards() {
		return faceUpCards;
	}

	public void setFaceUpCards(ArrayList<Card> faceUpCards) {
		this.faceUpCards = faceUpCards;
	}
	
	public boolean isTournamentColorNeeded() {
		return tournamentColorNeeded;
	}

	public void setTournamentColorNeeded(boolean tournamentColorNeeded) {
		this.tournamentColorNeeded = tournamentColorNeeded;
	}
	
	public ArrayList<Card> getLastHand() {
		return lastHand;
	}

	public void setLastHand(ArrayList<Card> lastHand) {
		this.lastHand = lastHand;
	}

	public int getLastPlayedValue() {
		return lastPlayedValue;
	}

	public void setLastPlayedValue(int lastPlayedValue) {
		this.lastPlayedValue = lastPlayedValue;
	}

	public ArrayList<Card> getLastDisplay() {
		return lastDisplay;
	}

	public void setLastDisplay(ArrayList<Card> lastDisplay) {
		this.lastDisplay = lastDisplay;
	}

	public boolean isLastMaidenPlayed() {
		return lastMaidenPlayed;
	}

	public void setLastMaidenPlayed(boolean lastMaidenPlayed) {
		this.lastMaidenPlayed = lastMaidenPlayed;
	}

	public boolean isLastSheilded() {
		return lastSheilded;
	}

	public void setLastSheilded(boolean lastSheilded) {
		this.lastSheilded = lastSheilded;
	}

	public boolean isLastStunned() {
		return lastStunned;
	}

	public void setLastStunned(boolean lastStunned) {
		this.lastStunned = lastStunned;
	}

	public ArrayList<Card> getLastFaceUpCards() {
		return lastFaceUpCards;
	}

	public void setLastFaceUpCards(ArrayList<Card> lastFaceUpCards) {
		this.lastFaceUpCards = lastFaceUpCards;
	}
	
	public boolean isTokenChoiceNeeded() {
		return tokenChoiceNeeded;
	}

	public void setTokenChoiceNeeded(boolean tokenChoiceNeeded) {
		this.tokenChoiceNeeded = tokenChoiceNeeded;
	}
	
	public int getNumTokens() {
		return numTokens;
	}

	public void setNumTokens(int numTokens) {
		this.numTokens = numTokens;
	}
	
	public boolean isHasPlayedCardThisTurn() {
		return hasPlayedCardThisTurn;
	}

	public void setHasPlayedCardThisTurn(boolean hasPlayedCardThisTurn) {
		this.hasPlayedCardThisTurn = hasPlayedCardThisTurn;
	}


/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////METHODS///////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public void playerSync(Game game)
	{
		this.game = game;
	}
	
	public void draw() {
		if(game.deck.getCards().isEmpty()){
			game.discardPile.shuffle();
			for(int i = 0; i < game.discardPile.getCards().size(); i++){
				game.deck.getCards().add(game.discardPile.getCards().get(i));
			}
			game.discardPile.getCards().clear();
		}
		Card newCard = game.deck.draw();
		hand.add(newCard);
	}
	

	public boolean doesNotHaveColorInHand(String color) {
		for(int i = 0; i < hand.size(); i++){
			if (color.equals(hand.get(i).getColor())||hand.get(i).getColor().equals("White")){
				return false;
			}
		}
		return true;
	}

	public void removeToken() {
		if(gToken == true){
			gToken = false;
			numTokens--;
			return;
		}else if(bToken == true){
			bToken = false;
			numTokens--;
			return;
		}else if(rToken == true){
			rToken = false;
			numTokens--;
			return;
		}else if(yToken == true){
			yToken = false;
			numTokens--;
			return;
		}else if(pToken == true){
			pToken = false;
			numTokens--;
			return;
		}else{
			return;
		}
	}

	public void awardChosenToken() {
		switch(chosenToken) {
			case "Purple": setpToken(true);
			             break;
			case "Red":    setrToken(true);
			             break;
			case "Blue":   setbToken(true);
			             break;
			case "Yellow": setyToken(true);
			             break;
			case "Green":  setgToken(true);
			             break;
		}
		chosenToken = null;
	}

	public void removeFaceUp() {
		for(int i = faceUpCards.size()-1; i > -1; i--){
			if(notInDisplay(faceUpCards.get(i))&&!faceUpCards.get(i).isSheild()&&!faceUpCards.get(i).isStunned()){
				faceUpCards.remove(i);
			}
		}
	}
	
	private boolean notInDisplay(Card c) {
		for(int i = 0; i < display.size(); i++){
			if(display.get(i)==c){
				return false;
			}
		}
		return true;
	}
	
	public void addFaceUp() {
		for(int i = 0; i < display.size(); i++){
			if(notInFaceUp(display.get(i))){
				faceUpCards.add(display.get(i));
			}
		}
	}
	
	private boolean notInFaceUp(Card c) {
		for(int i = 0; i < faceUpCards.size(); i++){
			if(faceUpCards.get(i)==c){
				return false;
			}
		}
		return true;
	}
	
	boolean notKeptCard(Card c) {
		for(int i = 0; i < keptCards.size(); i++) {
			if(keptCards.get(i) == c){
				return false;
			}
		}
		return true;
	}
}
