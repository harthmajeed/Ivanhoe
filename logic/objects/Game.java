package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1576714491569863806L;
	private int numPlayers;
	private ArrayList<Player> playerArray = new ArrayList<Player>();
	private int numPlayersInTournament;
	public Deck deck = new Deck();
	public Deck discardPile = new Deck("empty");
	public static final String Purple = "Purple";
	public static final String Red = "Red";
	public static final String Blue = "Blue";
	public static final String Yellow = "Yellow";
	public static final String Green = "Green";
	private String currTournamentColor = null;
	private String lastTournamentColor = null;
	private int lastTournamentWinner;
	private boolean gameOver;
	private String lastCurrTournamentColor = null;
	private String lastLastTournamentColor = null;
	private Card lastCardPlayedInGame;
	private boolean adaptPlayed = false;
	
/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////CONSTRUCTOR///////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public Game(int numP, ArrayList<String> names){
		numPlayers = numP;
		setGameOver(false);
		for (int i = 0; i < numP; i++){
			Player p = new Player(names.get(i), this);
			playerArray.add(p);
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////Getters/Setters///////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}
	
	public int getNumPlayersInTournament() {
		return numPlayersInTournament;
	}

	public void setNumPlayersInTournament(int numPlayersInTournament) {
		this.numPlayersInTournament = numPlayersInTournament;
	}

	public ArrayList<Player> getPlayerArray() {
		return playerArray;
	}

	public void setPlayerArray(ArrayList<Player> playerArray) {
		this.playerArray = playerArray;
	}
	
	
	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	public String getCurrTournamentColor() {
		return currTournamentColor;
	}

	public void setCurrTournamentColor(String currTournamentColor) {
		this.currTournamentColor = currTournamentColor;
	}
	
	public int getLastTournamentWinner() {
		return lastTournamentWinner;
	}

	public void setLastTournamentWinner(int lastTournamentWinner) {
		this.lastTournamentWinner = lastTournamentWinner;
	}
	
	public String getLastTournamentColor() {
		return lastTournamentColor;
	}

	public void setLastTournamentColor(String lastTournamentColor) {
		this.lastTournamentColor = lastTournamentColor;
	}
	

	public String getLastCurrTournamentColor() {
		return lastCurrTournamentColor;
	}

	public void setLastCurrTournamentColor(String lastCurrTournamentColor) {
		this.lastCurrTournamentColor = lastCurrTournamentColor;
	}

	public String getLastLastTournamentColor() {
		return lastLastTournamentColor;
	}

	public void setLastLastTournamentColor(String lastLastTournamentColor) {
		this.lastLastTournamentColor = lastLastTournamentColor;
	}
	
	public boolean isAdaptPlayed() {
		return adaptPlayed;
	}

	public void setAdaptPlayed(boolean adaptPlayed) {
		this.adaptPlayed = adaptPlayed;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////METHODS///////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////Start Game/////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////	
	public Game startGame(){
		deck.shuffle();
		for (int i = 0; i < numPlayers; i++) {
			for (int j = 0; j < 8; j++) {
				playerArray.get(i).draw();
			}
		}
		playerArray.get(0).setMyTurn(true);
		playerArray.get(0).setTournamentColorNeeded(true);
		playerArray.get(0).draw();
		return this;
	}

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////Choose Tournament COLOR/////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	public Game update(int i, String color) {
		if(!playerArray.get(i).isMyTurn())
			return this;
		if(color.equals("")){
			playerArray.get(i).setTournamentColorNeeded(false);
			nextPlayersTurn(i);
			playerArray.get(whosTurn()).setTournamentColorNeeded(true);
			playerArray.get(whosTurn()).draw();
			return this;
		}else{
				if (Purple.equals(lastTournamentColor) && color.equals("Purple")){
					return this;
				}else if(playerArray.get(i).doesNotHaveColorInHand(color)){
					return this;
				}else{
					currTournamentColor = color;
					playerArray.get(i).setTournamentColorNeeded(false);
					numPlayersInTournament = numPlayers;
					return this;
				}
			}
	}

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Play Card Dispatch /////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	public Game update(int i, int j) {
		if (currTournamentColor == null) {
			return this;
		}else{
			if(!playerArray.get(i).getHand().get(j).getColor().equals(currTournamentColor)&&!playerArray.get(i).getHand().get(j).getColor().equals("White")&&!playerArray.get(i).getHand().get(j).getColor().equals("Action")){
				return this;
			}else{
				switch(playerArray.get(i).getHand().get(j).getCardName()){
				case "Drop weapon":     playDropWeapon(i, j);
				                        break;
				case "Unhorse":         playUnhorse(i, j);
                                        break;
				case "Change weapon":   playChangeWeapon(i, j);
				                        break;
				case "Sheild":          playSheild(i, j);
                                        break;
				case "Break Lance":     playBreakLance(i, j);
				                        break;
				case "Riposte":         playRiposte(i, j);
                                        break;
				case "Dodge":           playDodge(i, j);
                                        break;
				case "Retreat":         playRetreat(i, j);
					                    break;
				case "Knock down":      playKnockDown(i, j);
					                    break;
				case "Outmaneuver":     playOutmaneuver(i, j);
					                    break;
				case "Charge":          playCharge(i, j);
					                    break;
				case "Counter-charge":  playCounterCharge(i, j);
					                    break;
				case "Disgrace":        playDisgrace(i, j);
					                    break;
				case "Adapt":           playAdapt(i, j);
					                    break;
				case "Outwit":          playOutwit(i, j);
					                    break;
				case "Stunned":         playStunned(i, j);
					                    break;
				case "Ivanhoe":         playIvanhoe(i, j);
					                    break;
				case "Squire":          playSquire(i, j);
				                        break;
				case "Maiden":          playMaiden(i, j);
				                        break;
				case "regular":         playRegular(i, j);
				                        break;
				}
				return this;
			}
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////End Turn///////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	public Game update(int i, boolean b) {
		if(!playerArray.get(i).isMyTurn())
			return this;
		if (b) {
			if(!playedHighestValue(i)||!playerArray.get(i).isHasPlayedCardThisTurn()){
				return this;
			}else{
				nextPlayersTurn(i);
				playerArray.get(whosTurn()).draw();
				playerArray.get(i).setHasPlayedCardThisTurn(false);
			}
		}else{
			playerArray.get(i).setForfiet(true);
			playerArray.get(i).setHasPlayedCardThisTurn(false);
			if (playerArray.get(i).isMaidenPlayed()){
				playerArray.get(i).removeToken();
			}
			numPlayersInTournament--;
			if (numPlayersInTournament == 1) {
				for (int j = 0; j < numPlayers; j++) {
					if (!playerArray.get(j).isForfiet()){
						switch(currTournamentColor) {
						case "Purple": playerArray.get(j).setTokenChoiceNeeded(true);
						               playerArray.get(j).setMyTurn(true);
						               return this;
						case "Red":    if(!playerArray.get(j).hasRToken()){
							               playerArray.get(j).setrToken(true);
						                   playerArray.get(j).setNumTokens(playerArray.get(j).getNumTokens() + 1);
						               }
						               break;
						case "Blue":   if(!playerArray.get(j).hasBToken()){
							               playerArray.get(j).setbToken(true);
						                   playerArray.get(j).setNumTokens(playerArray.get(j).getNumTokens() + 1);
						               }
						               break;
						case "Yellow": if(!playerArray.get(j).hasYToken()){
							               playerArray.get(j).setyToken(true);
						                   playerArray.get(j).setNumTokens(playerArray.get(j).getNumTokens() + 1);
						               }
						               break;
						case "Green":  if(!playerArray.get(j).hasGToken()){
							               playerArray.get(j).setgToken(true);
						                   playerArray.get(j).setNumTokens(playerArray.get(j).getNumTokens() + 1);
						               }
						               break;
						}
						lastTournamentWinner = j;
						numPlayersInTournament = numPlayers;
						for(int m = 0; m < numPlayers; m++){
						    playerArray.get(m).setMyTurn(false);
						}
						playerArray.get(j).setMyTurn(true);
						playerArray.get(j).setTournamentColorNeeded(true);
						playerArray.get(j).draw();
						if(playerArray.get(j).getNumTokens() == 5 && numPlayers < 4) {
							playerArray.get(j).setGameWinner(true);
							gameOver = true;
						}
						if(playerArray.get(j).getNumTokens() == 4 && numPlayers > 3) {
							playerArray.get(j).setGameWinner(true);
							gameOver = true;
						}
					}
				}
				lastTournamentColor = currTournamentColor;
				currTournamentColor = null;
				for (int l = 0; l < numPlayers; l++) {
					for(int n = 0; n < playerArray.get(l).getFaceUpCards().size(); n++) {
						discardPile.getCards().add(playerArray.get(l).getFaceUpCards().get(n));
					}
					playerArray.get(l).setForfiet(false);
					playerArray.get(l).getDisplay().clear();
					playerArray.get(l).getFaceUpCards().clear();
					playerArray.get(l).setSheilded(false);
					playerArray.get(l).setStunned(false);
					playerArray.get(l).setPlayedValue(0);
					playerArray.get(l).setMaidenPlayed(false);
				}
			}
			if(numPlayersInTournament != 1) {
				nextPlayersTurn(i);
				playerArray.get(whosTurn()).draw();
			}
		}
		
		return this;
	}
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public Game afterTokenChoice () {
		for (int j = 0; j < numPlayers; j++) {
			if (!playerArray.get(j).isForfiet()){
				switch(playerArray.get(j).getChosenToken()) {
				case "Purple": if(!playerArray.get(j).hasPToken()){
					               playerArray.get(j).setpToken(true);
				                   playerArray.get(j).setNumTokens(playerArray.get(j).getNumTokens() + 1);
				               }else{
				            	   return this;
				               }
				               break;
				case "Red":    if(!playerArray.get(j).hasRToken()){
		                           playerArray.get(j).setrToken(true);
	                               playerArray.get(j).setNumTokens(playerArray.get(j).getNumTokens() + 1);
	                           }else{
				            	   return this;
				               }
	                           break;
	            case "Blue":   if(!playerArray.get(j).hasBToken()){
                                   playerArray.get(j).setbToken(true);
                                   playerArray.get(j).setNumTokens(playerArray.get(j).getNumTokens() + 1);
                               }else{
				            	   return this;
				               }
	                           break;
	            case "Yellow": if(!playerArray.get(j).hasYToken()){
		                           playerArray.get(j).setyToken(true);
	                               playerArray.get(j).setNumTokens(playerArray.get(j).getNumTokens() + 1);
	                           }else{
				            	   return this;
				               }
	                           break;
	            case "Green":  if(!playerArray.get(j).hasGToken()){
		                           playerArray.get(j).setgToken(true);
	                               playerArray.get(j).setNumTokens(playerArray.get(j).getNumTokens() + 1);
	                           }else{
				            	   return this;
				               }
	                           break;
				}
				playerArray.get(j).setTokenChoiceNeeded(false);
				lastTournamentWinner = j;
				numPlayersInTournament = numPlayers;
				for(int m = 0; m < numPlayers; m++){
				    playerArray.get(m).setMyTurn(false);
				}
				playerArray.get(j).setMyTurn(true);
				playerArray.get(j).setTournamentColorNeeded(true);
				playerArray.get(j).draw();
				if(playerArray.get(j).getNumTokens() == 5 && numPlayers < 4) {
					playerArray.get(j).setGameWinner(true);
					gameOver = true;
				}
				if(playerArray.get(j).getNumTokens() == 4 && numPlayers > 3) {
					playerArray.get(j).setGameWinner(true);
					gameOver = true;
				}
			}
		}
		lastTournamentColor = currTournamentColor;
		currTournamentColor = null;
		for (int l = 0; l < numPlayers; l++) {
			for(int n = 0; n < playerArray.get(l).getFaceUpCards().size(); n++) {
				discardPile.getCards().add(playerArray.get(l).getFaceUpCards().get(n));
			}
			playerArray.get(l).setForfiet(false);
			playerArray.get(l).getDisplay().clear();
			playerArray.get(l).getFaceUpCards().clear();
			playerArray.get(l).setSheilded(false);
			playerArray.get(l).setStunned(false);
			playerArray.get(l).setPlayedValue(0);
			playerArray.get(l).setMaidenPlayed(false);
		}
		return this;
	}

/////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////Play Card Methods ///////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

	private void playUnhorse(int i, int j) {
		if (!currTournamentColor.equals("Purple")||playerArray.get(i).getNewTournamentColor().equals("Purple")||playerArray.get(i).getNewTournamentColor().equals("Green") || !playerArray.get(i).isMyTurn()){
			return;
		}else{
			playerArray.get(i).setHasPlayedCardThisTurn(true);
			playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
			discardPile.getCards().add(playerArray.get(i).getHand().get(j));
			lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
			prepForIvanhoe();
			currTournamentColor = playerArray.get(i).getNewTournamentColor();
			playerArray.get(i).setNewTournamentColor(null);
		}
		return;
	}
/////////////////////////////////////////////////////////////////////////////////////////////
    private void playChangeWeapon(int i, int j) {
    	if(currTournamentColor.equals("Green")||currTournamentColor.equals("Purple")||currTournamentColor.equals(playerArray.get(i).getNewTournamentColor()) || !playerArray.get(i).isMyTurn()){
			return;
		}else{
			playerArray.get(i).setHasPlayedCardThisTurn(true);
			playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
			discardPile.getCards().add(playerArray.get(i).getHand().get(j));
			lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
			prepForIvanhoe();
	        currTournamentColor = playerArray.get(i).getNewTournamentColor();
			playerArray.get(i).setNewTournamentColor(null);
		}	
    	return;
	}
/////////////////////////////////////////////////////////////////////////////////////////////
    private void playDropWeapon(int i, int j) {
    	if(currTournamentColor.equals("Green")||currTournamentColor.equals("Purple") || !playerArray.get(i).isMyTurn()){
			return;
		}else{
			playerArray.get(i).setHasPlayedCardThisTurn(true);
			playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
			discardPile.getCards().add(playerArray.get(i).getHand().get(j));
			lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
			prepForIvanhoe();
			currTournamentColor = "Green";
			for(int q = 0; q < playerArray.size(); q++){
				recalculatePlayedValue(q);
			}
			return;
		}
	}


	/////////////////////////////////////////////////////////////////////////////////////////////
    private void playSheild(int i, int j) {
    	if(playerArray.get(i).isSheilded() || !playerArray.get(i).isMyTurn()){
			return;
		}else{
			Card temp;
			temp = playerArray.get(i).getHand().get(j);
			playerArray.get(i).setHasPlayedCardThisTurn(true);
			playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
			lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
			prepForIvanhoe();
			playerArray.get(i).setSheilded(true);
			playerArray.get(i).getFaceUpCards().add(temp);
			return;
		}
    }
/////////////////////////////////////////////////////////////////////////////////////////////
    private void playStunned(int i, int j) {
    	if(playerArray.get(playerArray.get(i).getTargetPlayer()).isStunned() || !playerArray.get(i).isMyTurn()){
			return;
		}else{
			Card temp;
			temp = playerArray.get(i).getHand().get(j);
			playerArray.get(i).setHasPlayedCardThisTurn(true);
			playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
			lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
			prepForIvanhoe();
			playerArray.get(playerArray.get(i).getTargetPlayer()).setStunned(true);
			playerArray.get(i).getFaceUpCards().add(temp);
			return;
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////	
    private  void playIvanhoe(int i, int j) {
    	if(!lastCardPlayedInGame.getColor().equals("Action")){
    		return;
    	}else{
    		for(int s = 0; s < playerArray.size(); s++){
    			playerArray.get(s).setPlayedValue(playerArray.get(s).getLastPlayedValue());
    			playerArray.get(s).setMaidenPlayed(playerArray.get(s).isLastMaidenPlayed());
    			playerArray.get(s).setSheilded(playerArray.get(s).isLastSheilded());
    			playerArray.get(s).setStunned(playerArray.get(s).isLastStunned());
    			playerArray.get(s).getHand().clear();
    			playerArray.get(s).getDisplay().clear();
    			playerArray.get(s).getFaceUpCards().clear();
    			for(int u = 0; u < playerArray.get(s).getLastHand().size(); u++){
    				playerArray.get(s).getHand().add(playerArray.get(s).getLastHand().get(u));
    			}
    			for(int v = 0; v < playerArray.get(s).getLastDisplay().size(); v++){
    				playerArray.get(s).getDisplay().add(playerArray.get(s).getLastDisplay().get(v));
    			}
    			for(int x = 0; x < playerArray.get(s).getLastFaceUpCards().size(); x++){
    				playerArray.get(s).getFaceUpCards().add(playerArray.get(s).getLastFaceUpCards().get(x));
    			}
    			playerArray.get(s).getLastHand().clear();
    			playerArray.get(s).getLastDisplay().clear();
    			playerArray.get(s).getLastFaceUpCards().clear();
    		}
    		setCurrTournamentColor(getLastCurrTournamentColor());
    		setLastTournamentColor(getLastLastTournamentColor());
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
    		lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
    		discardPile.getCards().add(playerArray.get(i).getHand().get(j));
			playerArray.get(i).getHand().remove(j);
			
    		return;
    	}
	}
/////////////////////////////////////////////////////////////////////////////////////////////    
    private void playBreakLance(int i, int j) {
    	if(playerArray.get(i).getTargetPlayer() == -1  || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
    		discardPile.getCards().add(playerArray.get(i).getHand().get(j));
    		lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
    		prepForIvanhoe();
    		for (int k = (playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().size()-1); k >= 0; k--){
    	        if(playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().get(k).getColor() == "Purple"&&!playerArray.get(playerArray.get(i).getTargetPlayer()).isSheilded() && playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().size() > 1){
    	        	playerArray.get(playerArray.get(i).getTargetPlayer()).setPlayedValue(playerArray.get(playerArray.get(i).getTargetPlayer()).getPlayedValue() - playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().get(k).getValue());
    	        	discardPile.getCards().add(playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().get(k));
    	        	playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().remove(k);
    	        }
    		}
    		playerArray.get(playerArray.get(i).getTargetPlayer()).removeFaceUp();
    		playerArray.get(i).setTargetPlayer(-1);
		    return;
    	}
	}
/////////////////////////////////////////////////////////////////////////////////////////////
    private void playRiposte(int i, int j) {
    	if(playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().size() <2||playerArray.get(playerArray.get(i).getTargetPlayer()).isSheilded() || playerArray.get(i).isStunned() && playerArray.get(i).isCardAddedToDisplay() || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
    		discardPile.getCards().add(playerArray.get(i).getHand().get(j));
        	lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
    		playerArray.get(i).getHand().remove(j);
    		prepForIvanhoe();
    		Card temp;
    		temp = playerArray.get(playerArray.get(i).getTargetPlayer()).getLastCardPlayed();
    		playerArray.get(playerArray.get(i).getTargetPlayer()).setPlayedValue(playerArray.get(playerArray.get(i).getTargetPlayer()).getPlayedValue()-temp.getValue());
    		playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().remove(playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().size()-1);
    		playerArray.get(i).getDisplay().add(temp);
    		playerArray.get(i).setPlayedValue(playerArray.get(i).getPlayedValue() + temp.getValue());
    	}
    	playerArray.get(playerArray.get(i).getTargetPlayer()).removeFaceUp();
    	playerArray.get(i).addFaceUp();
    	playerArray.get(i).setTargetPlayer(-1);
		playerArray.get(i).setCardAddedToDisplay(true);
    	return;
    }
/////////////////////////////////////////////////////////////////////////////////////////////    
	private void playDodge(int i, int j) {
		if(playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().size() <2||playerArray.get(playerArray.get(i).getTargetPlayer()).isSheilded() || !playerArray.get(i).isMyTurn()){
			return;
		}else{
			playerArray.get(i).setHasPlayedCardThisTurn(true);
			playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
			discardPile.getCards().add(playerArray.get(i).getHand().get(j));
        	lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
    		playerArray.get(i).getHand().remove(j);
			prepForIvanhoe();
			Card temp;
			temp = playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().get(playerArray.get(i).getChosenCard());
			playerArray.get(playerArray.get(i).getTargetPlayer()).setPlayedValue(playerArray.get(playerArray.get(i).getTargetPlayer()).getPlayedValue() - temp.getValue());
			playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().remove(playerArray.get(i).getChosenCard());
			discardPile.getCards().add(temp);
			playerArray.get(playerArray.get(i).getTargetPlayer()).removeFaceUp();
        	playerArray.get(i).setTargetPlayer(-1);
        	playerArray.get(i).setChosenCard(-1);
			return;
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////	
    private void playRetreat(int i, int j) {
    	if(playerArray.get(i).getDisplay().size() <2||playerArray.get(i).isSheilded() || !playerArray.get(i).isMyTurn()){
			return;
		}else{
			playerArray.get(i).setHasPlayedCardThisTurn(true);
			playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
	    	discardPile.getCards().add(playerArray.get(i).getHand().get(j));
	    	lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
			prepForIvanhoe();
			Card temp;
			temp = playerArray.get(i).getDisplay().get(playerArray.get(i).getChosenCard());
			playerArray.get(i).setPlayedValue(playerArray.get(i).getPlayedValue() - temp.getValue());
			playerArray.get(i).getDisplay().remove(playerArray.get(i).getChosenCard());
			playerArray.get(i).getHand().add(temp);
			playerArray.get(i).removeFaceUp();
			playerArray.get(i).setChosenCard(-1);
			return;
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////    
    private void playKnockDown(int i, int j) {
    	if(playerArray.get(playerArray.get(i).getTargetPlayer()).getHand().size() ==0||playerArray.get(playerArray.get(i).getTargetPlayer()).isSheilded() || playerArray.get(i).isStunned() && playerArray.get(i).isCardAddedToDisplay() || !playerArray.get(i).isMyTurn()){
			return;
		}else{
			playerArray.get(i).setHasPlayedCardThisTurn(true);
			playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
	    	discardPile.getCards().add(playerArray.get(i).getHand().get(j));
	    	lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
			prepForIvanhoe();
			Random rand = new Random();
			int r = rand.nextInt(playerArray.get(playerArray.get(i).getTargetPlayer()).getHand().size());
			Card temp;
			temp = playerArray.get(playerArray.get(i).getTargetPlayer()).getHand().get(r);
			playerArray.get(playerArray.get(i).getTargetPlayer()).getHand().remove(r);
			playerArray.get(i).getHand().add(temp);
	    	playerArray.get(i).setTargetPlayer(-1);
			playerArray.get(i).setCardAddedToDisplay(true);
			return;
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////
    private void playOutmaneuver(int i, int j) {
    	boolean noEffect = true;
    	for(int l = 0; l < playerArray.size(); l++){
    		if(playerArray.get(l).getDisplay().size() > 1 && l!=i && !playerArray.get(l).isSheilded()){
    			noEffect = false;
    		}
    	}
    	if(noEffect == true || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
	    	discardPile.getCards().add(playerArray.get(i).getHand().get(j));
	    	lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
    		prepForIvanhoe();
    		for(int k = 0; k < playerArray.size(); k++){
    			if(playerArray.get(k).getDisplay().size() > 1 && k!=i && !playerArray.get(k).isSheilded()){
    				playerArray.get(k).setPlayedValue(playerArray.get(k).getPlayedValue()-playerArray.get(k).getDisplay().get(playerArray.get(k).getDisplay().size()-1).getValue());
    				discardPile.getCards().add(playerArray.get(k).getDisplay().get(playerArray.get(k).getDisplay().size()-1));
    				playerArray.get(k).getDisplay().remove(playerArray.get(k).getDisplay().size()-1);
    				playerArray.get(k).removeFaceUp();
    			}
    		}
    		return;
    	}
    }
/////////////////////////////////////////////////////////////////////////////////////////////    
    private void playCharge(int i, int j) {
    	boolean noEffect = true;
    	for(int o = 0; o < playerArray.size(); o++){
    		if(playerArray.get(o).getDisplay().size() > 1 && o!=i && !playerArray.get(o).isSheilded()){
    			noEffect = false;
    		}
    	}
    	if(noEffect == true || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
	    	discardPile.getCards().add(playerArray.get(i).getHand().get(j));
	    	lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
    		prepForIvanhoe();
    		int minVal = 100;
    		for(int m = 0; m < playerArray.size(); m++){
    			for(int n = 0; n < playerArray.get(m).getDisplay().size(); n++){
    				if(playerArray.get(m).getDisplay().get(n).getValue() < minVal && playerArray.get(m).getDisplay().get(n).getValue() > 0 && !playerArray.get(m).isSheilded()){
    					minVal = playerArray.get(m).getDisplay().get(n).getValue();
    				}
    			}
    		}
    		for(int k = 0; k < playerArray.size(); k++){
    			if(playerArray.get(k).getDisplay().size() > 1 && k!=i && !playerArray.get(k).isSheilded()){
    				for(int l = playerArray.get(k).getDisplay().size()-1; l > -1; l--){
    					if(playerArray.get(k).getDisplay().get(l).getValue() == minVal && playerArray.get(k).getDisplay().size() > 1){
    						playerArray.get(k).setPlayedValue(playerArray.get(k).getPlayedValue() - minVal);
    						discardPile.getCards().add(playerArray.get(k).getDisplay().get(l));
    						playerArray.get(k).getDisplay().remove(l);
    					}
    				}
    				playerArray.get(k).removeFaceUp();
    			}
    		}
    		return;
    	}
	}
/////////////////////////////////////////////////////////////////////////////////////////////	
    private void playCounterCharge(int i, int j) {
    	boolean noEffect = true;
    	for(int o = 0; o < playerArray.size(); o++){
    		if(playerArray.get(o).getDisplay().size() > 1 && o!=i && !playerArray.get(o).isSheilded()){
    			noEffect = false;
    		}
    	}
    	if(noEffect == true || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
	    	discardPile.getCards().add(playerArray.get(i).getHand().get(j));
	    	lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
    		prepForIvanhoe();
    		int maxVal = 0;
    		for(int m = 0; m < playerArray.size(); m++){
    			for(int n = 0; n < playerArray.get(m).getDisplay().size(); n++){
    				if(playerArray.get(m).getDisplay().get(n).getValue() > maxVal && !playerArray.get(m).isSheilded()){
    					maxVal = playerArray.get(m).getDisplay().get(n).getValue();
    				}
    			}
    		}
    		for(int k = 0; k < playerArray.size(); k++){
    			if(playerArray.get(k).getDisplay().size() > 1 && k!=i && !playerArray.get(k).isSheilded()){
    				for(int l = playerArray.get(k).getDisplay().size()-1; l > -1; l--){
    					if(playerArray.get(k).getDisplay().get(l).getValue() == maxVal){
    						playerArray.get(k).setPlayedValue(playerArray.get(k).getPlayedValue() - maxVal);
    						discardPile.getCards().add(playerArray.get(k).getDisplay().get(l));
    						playerArray.get(k).getDisplay().remove(l);
    					}
    				}
    				playerArray.get(k).removeFaceUp();
    			}
    		}
    		return;
    	}
	}
/////////////////////////////////////////////////////////////////////////////////////////////    
    private void playDisgrace(int i, int j) {
    	boolean noEffectDueToDisplaySize = true;
    	boolean noEffectDueToNoSupporters = true;
    	for(int p = 0; p < playerArray.size(); p++){
    		if(playerArray.get(p).getDisplay().size() > 1 && !playerArray.get(p).isSheilded()){
    			noEffectDueToDisplaySize = false;
    		}
    		for(int o = 0; o < playerArray.get(p).getDisplay().size(); o++){
    			if(playerArray.get(p).getDisplay().get(o).getColor().equals("White") && !playerArray.get(p).isSheilded()){
    				noEffectDueToNoSupporters = false;
    			}
    		}
    	}

    	if(noEffectDueToDisplaySize == true || noEffectDueToNoSupporters == true || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
	    	discardPile.getCards().add(playerArray.get(i).getHand().get(j));
	    	lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
    		prepForIvanhoe();
    		for(int k = 0; k < playerArray.size(); k++){
    			if(playerArray.get(k).getDisplay().size() > 1 && !playerArray.get(k).isSheilded()){
    				for(int l = playerArray.get(k).getDisplay().size()-1; l > -1; l--){
    					if(playerArray.get(k).getDisplay().get(l).getColor().equals("White")){
    						playerArray.get(k).setPlayedValue(playerArray.get(k).getPlayedValue() - playerArray.get(k).getDisplay().get(l).getValue());
    						discardPile.getCards().add(playerArray.get(k).getDisplay().get(l));
    						playerArray.get(k).getDisplay().remove(l);
    					}
    				}
    				playerArray.get(k).removeFaceUp();
    			}
    		}
    		return;
    	}
	}
/////////////////////////////////////////////////////////////////////////////////////////////
    private void playAdapt(int i, int j) {
    	boolean noEffect = true;
    	for(int m = 0; m < playerArray.size(); m++){
    		for(int n = 0; n < playerArray.get(m).getDisplay().size(); n++){
    			for(int k = 1; k < playerArray.get(m).getDisplay().size(); k++){
    				if(playerArray.get(m).getDisplay().get(n).getValue() == playerArray.get(m).getDisplay().get(k).getValue() && !playerArray.get(m).isSheilded()){
    	    			noEffect = false;
    	    		}
    			}
    		}
    	}
    	if(noEffect || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
	    	discardPile.getCards().add(playerArray.get(i).getHand().get(j));
	    	lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
    		prepForIvanhoe();
    		setAdaptPlayed(true);
    		return;
    	}
    }
/////////////////////////////////////////////////////////////////////////////////////////////	
    public void afterAdaptPopup () {
    	for(int l = 0; l < playerArray.size(); l++){
			if(!playerArray.get(l).isSheilded()){       
	    	    for(int m = playerArray.get(l).getDisplay().size()-1; m > -1; m--){
	    	    	playerArray.get(l).setPlayedValue(playerArray.get(l).getPlayedValue() - playerArray.get(l).getDisplay().get(m).getValue());
	    	    	if(playerArray.get(l).notKeptCard(playerArray.get(l).getDisplay().get(m))){
	    	    		discardPile.getCards().add(playerArray.get(l).getDisplay().get(m));
	    	    	}
	    	    	playerArray.get(l).getDisplay().remove(m);
	    	    }
	    	    for(int n = playerArray.get(l).getKeptCards().size()-1; n > -1; n--){
	    	    	playerArray.get(l).setPlayedValue(playerArray.get(l).getPlayedValue() + playerArray.get(l).getKeptCards().get(n).getValue());
	    	    	playerArray.get(l).getDisplay().add(playerArray.get(l).getKeptCards().get(n));
	    	    	playerArray.get(l).getKeptCards().remove(n);
	    	    }
	    	    playerArray.get(l).removeFaceUp();
			}
		}
    	setAdaptPlayed(false);
    }
/////////////////////////////////////////////////////////////////////////////////////////////    
    private void playOutwit(int i, int j) {
    	boolean noEffect = true;
        if(playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().size() > 1 && !playerArray.get(playerArray.get(i).getTargetPlayer()).isSheilded()){
    	    noEffect = false;
    	}
    	if(noEffect == true || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
	    	discardPile.getCards().add(playerArray.get(i).getHand().get(j));
	    	lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
			playerArray.get(i).getHand().remove(j);
    		prepForIvanhoe();
    		Card temp1;
    		Card temp2;
    		temp1 = playerArray.get(i).getFaceUpCards().get(playerArray.get(i).getGivenCard());
    		temp2 = playerArray.get(playerArray.get(i).getTargetPlayer()).getFaceUpCards().get(playerArray.get(i).getChosenCard());
    		playerArray.get(i).setPlayedValue(playerArray.get(i).getPlayedValue() - temp1.getValue());
    		playerArray.get(playerArray.get(i).getTargetPlayer()).setPlayedValue(playerArray.get(playerArray.get(i).getTargetPlayer()).getPlayedValue() - temp2.getValue());
    		playerArray.get(i).getFaceUpCards().remove(playerArray.get(i).getGivenCard());
    		playerArray.get(playerArray.get(i).getTargetPlayer()).getFaceUpCards().remove(playerArray.get(i).getChosenCard());
    		playerArray.get(i).setPlayedValue(playerArray.get(i).getPlayedValue() + temp2.getValue());
    	    playerArray.get(playerArray.get(i).getTargetPlayer()).setPlayedValue(playerArray.get(playerArray.get(i).getTargetPlayer()).getPlayedValue() + temp1.getValue());
    		playerArray.get(i).getFaceUpCards().add(temp2);
    		playerArray.get(playerArray.get(i).getTargetPlayer()).getFaceUpCards().add(temp1);
    		if(temp1.getCardName().equals("Sheild")){
    			playerArray.get(i).setSheilded(false);
    			playerArray.get(playerArray.get(i).getTargetPlayer()).setSheilded(true);
    		}
    		if(temp1.getCardName().equals("Stunned")){
    			playerArray.get(i).setStunned(false);
    			playerArray.get(playerArray.get(i).getTargetPlayer()).setStunned(true);
    		}
    		if(temp2.getCardName().equals("Sheild")){
    			playerArray.get(i).setSheilded(true);
    			playerArray.get(playerArray.get(i).getTargetPlayer()).setSheilded(false);
    		}
    		if(temp2.getCardName().equals("Stunned")){
    			playerArray.get(i).setStunned(true);
    			playerArray.get(playerArray.get(i).getTargetPlayer()).setStunned(false);
    		}
    		if(temp1.getCardName().equals("regular") || temp1.getColor().equals("White")){
    			if(temp1.getCardName().equals("Maiden")){
    				playerArray.get(i).setMaidenPlayed(false);
        			playerArray.get(playerArray.get(i).getTargetPlayer()).setMaidenPlayed(true);
    			}
    			for(int r = 0; r < playerArray.get(i).getDisplay().size(); r++){
    				if(playerArray.get(i).getDisplay().get(r).getColor().equals(temp1.getColor())&&playerArray.get(i).getDisplay().get(r).getValue() == temp1.getValue()){
    					playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().add(temp1);
    					playerArray.get(i).getDisplay().remove(r);
    					break;
    				}
    			}
    		}
    		if(temp2.getCardName().equals("regular") || temp2.getColor().equals("White")){
    			if(temp2.getCardName().equals("Maiden")){
    				playerArray.get(i).setMaidenPlayed(true);
        			playerArray.get(playerArray.get(i).getTargetPlayer()).setMaidenPlayed(false);
    			}
    			for(int r = 0; r < playerArray.get(i).getDisplay().size(); r++){
    				if(playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().get(r).getColor().equals(temp2.getColor())&&playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().get(r).getValue() == temp2.getValue()){
    					playerArray.get(i).getDisplay().add(temp2);
    					playerArray.get(playerArray.get(i).getTargetPlayer()).getDisplay().remove(r);
    					break;
    				}
    			}
    			
    		}
			playerArray.get(i).setTargetPlayer(-1);
			playerArray.get(i).setChosenCard(-1);
			playerArray.get(i).setGivenCard(-1);
    		return;
    	}
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////	
    private  void playSquire(int i, int j) {
    	if(playerArray.get(i).isStunned() && playerArray.get(i).isCardAddedToDisplay() || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		if(currTournamentColor.equals("Green")){
    			playerArray.get(i).setPlayedValue(playerArray.get(i).getPlayedValue() + 1);
    		}else{
    			playerArray.get(i).setPlayedValue(playerArray.get(i).getPlayedValue() + playerArray.get(i).getHand().get(j).getValue());
    		}
    		playerArray.get(i).getDisplay().add(playerArray.get(i).getHand().get(j));
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
    		playerArray.get(i).getFaceUpCards().add(playerArray.get(i).getHand().get(j));
    		lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
    		playerArray.get(i).getHand().remove(j);
    		playerArray.get(i).setCardAddedToDisplay(true);
    		return;
    	}
    }
	
/////////////////////////////////////////////////////////////////////////////////////////////	
    private  void playMaiden(int i, int j) {
    	if(playerArray.get(i).isStunned() && playerArray.get(i).isCardAddedToDisplay() || playerArray.get(i).isMaidenPlayed() || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		if(currTournamentColor.equals("Green")){
    			playerArray.get(i).setPlayedValue(playerArray.get(i).getPlayedValue() + 1);
    		}else{
    			playerArray.get(i).setPlayedValue(playerArray.get(i).getPlayedValue() + playerArray.get(i).getHand().get(j).getValue());
    		}
    		playerArray.get(i).setMaidenPlayed(true);
    		playerArray.get(i).getDisplay().add(playerArray.get(i).getHand().get(j));
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
    		playerArray.get(i).getFaceUpCards().add(playerArray.get(i).getHand().get(j));
    		lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
    		playerArray.get(i).getHand().remove(j);
    		playerArray.get(i).setCardAddedToDisplay(true);
    		return;
    	}
    }
    
/////////////////////////////////////////////////////////////////////////////////////////////	
    private  void playRegular(int i, int j) {
    	if(playerArray.get(i).isStunned() && playerArray.get(i).isCardAddedToDisplay() || !playerArray.get(i).isMyTurn()){
    		return;
    	}else{
    		playerArray.get(i).setHasPlayedCardThisTurn(true);
    		if(currTournamentColor.equals("Green")){
    			playerArray.get(i).setPlayedValue(playerArray.get(i).getPlayedValue() + 1);
    		}else{
    			playerArray.get(i).setPlayedValue(playerArray.get(i).getPlayedValue() + playerArray.get(i).getHand().get(j).getValue());
    		}
    		playerArray.get(i).getDisplay().add(playerArray.get(i).getHand().get(j));
    		playerArray.get(i).setLastCardPlayed(playerArray.get(i).getHand().get(j));
    		playerArray.get(i).getFaceUpCards().add(playerArray.get(i).getHand().get(j));
    		lastCardPlayedInGame = playerArray.get(i).getHand().get(j);
    		playerArray.get(i).getHand().remove(j);
    		playerArray.get(i).setCardAddedToDisplay(true);
    		return;
    	}
    }
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////Helper Methods//////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	private boolean playedHighestValue(int i) {
		for(int j = 0; j < (numPlayers -1); j++){
			if (playerArray.get(i).getPlayedValue() < playerArray.get((i + 1 + j) % numPlayers).getPlayedValue()){
				return false;
			}
		}
		return true;
	}
/////////////////////////////////////////////////////////////////////////////////////////////
	private void nextPlayersTurn(int k) {
		playerArray.get(k).setMyTurn(false);
		for (int i = 0; i < (numPlayers -1); i++) {
			if (!playerArray.get(((i + 1) + k) % numPlayers).isForfiet()) {
				playerArray.get(((i+1)+k) % numPlayers).setMyTurn(true);
				break;
			}  
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////	
	public int whosTurn() {
		int index = 0;
		for (int j = 0; j < numPlayers; j++) {
			if (playerArray.get(j).isMyTurn()) {
				index = j;
				break;
			}
		}
		return index;
	}
/////////////////////////////////////////////////////////////////////////////////////////////	
	private void recalculatePlayedValue(int q) {
		if(currTournamentColor.equals("Green")){
			playerArray.get(q).setPlayedValue(0);
			for(int i = 0; i < playerArray.get(q).getDisplay().size(); i++){
				playerArray.get(q).setPlayedValue(playerArray.get(q).getPlayedValue() + 1);
			}
		}else{
			playerArray.get(q).setPlayedValue(0);
			for(int i = 0; i < playerArray.get(q).getDisplay().size(); i++){
				playerArray.get(q).setPlayedValue(playerArray.get(q).getPlayedValue() + playerArray.get(q).getDisplay().get(i).getValue());
			}
		}
		return;
	}
/////////////////////////////////////////////////////////////////////////////////////////////
	private void prepForIvanhoe() {
		for(int s = 0; s < playerArray.size(); s++){
			playerArray.get(s).setLastPlayedValue(playerArray.get(s).getPlayedValue());
			playerArray.get(s).getLastHand().clear();
			playerArray.get(s).getLastDisplay().clear();
			playerArray.get(s).getLastFaceUpCards().clear();
			for(int t = 0; t < playerArray.get(s).getHand().size(); t++){
				playerArray.get(s).getLastHand().add(playerArray.get(s).getHand().get(t));
			}
			for(int u = 0; u < playerArray.get(s).getDisplay().size(); u++){
				playerArray.get(s).getLastDisplay().add(playerArray.get(s).getDisplay().get(u));
			}
			for(int v = 0; v < playerArray.get(s).getFaceUpCards().size(); v++){
				playerArray.get(s).getLastFaceUpCards().add(playerArray.get(s).getFaceUpCards().get(v));
			}
			playerArray.get(s).setLastMaidenPlayed(playerArray.get(s).isMaidenPlayed());
			playerArray.get(s).setLastSheilded(playerArray.get(s).isSheilded());
			playerArray.get(s).setLastStunned(playerArray.get(s).isStunned());
			
		}
		setLastCurrTournamentColor(currTournamentColor);
		setLastLastTournamentColor(lastTournamentColor);
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////

}
