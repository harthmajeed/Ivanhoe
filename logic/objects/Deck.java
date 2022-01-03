package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2391981035850685569L;
	private ArrayList<Card> cards = new ArrayList<Card>();


/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////CONSTRUCTOR///////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public Deck(){
		for(int i = 0; i < 110; i++){
			if(i < 4){
				Card currCard = new Card("Purple", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 3 && i < 8){
				Card currCard = new Card("Purple", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 7 && i < 12){
				Card currCard = new Card("Purple", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 11 && i < 14){
				Card currCard = new Card("Purple", 7, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 13 && i < 20){
				Card currCard = new Card("Red", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 19 && i < 26){
				Card currCard = new Card("Red", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 25 && i < 28){
				Card currCard = new Card("Red", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 27 && i < 32){
				Card currCard = new Card("Blue", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 31 && i < 36){
				Card currCard = new Card("Blue", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 35 && i < 40){
				Card currCard = new Card("Blue", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 39 && i <42){
				Card currCard = new Card("Blue", 5, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 41 && i < 46){
				Card currCard = new Card("Yellow", 2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 45 && i < 54){
				Card currCard = new Card("Yellow", 3, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 53 && i < 56){
				Card currCard = new Card("Yellow", 4, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 55 && i < 70){
				Card currCard = new Card("Green", 1, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 69 && i < 78){
				Card currCard = new Card("White", 2, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 77 && i < 86){
				Card currCard = new Card("White", 3, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 85 && i < 90){
				Card currCard = new Card("White", 6, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 89 && i < 91){
				Card currCard = new Card("Action", 0, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 90 && i < 92){
				Card currCard = new Card("Action", 0, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 91 && i < 93){
				Card currCard = new Card("Action", 0, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 92 && i < 94){
				Card currCard = new Card("Action", 0, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 93 && i < 95){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 94 && i < 96){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 95 && i < 97){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 96 && i < 100){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 99 && i < 101){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 100 && i < 102){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 101 && i < 104){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 103 && i < 105){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 104 && i < 106){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false);
				cards.add(currCard);
			}
			if(i > 105 && i < 107){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false);
				cards.add(currCard);
			}
			if(i > 106 && i < 108){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false);
				cards.add(currCard);
			}
			if(i > 107 && i < 109){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false);
				cards.add(currCard);
			}
			if(i > 108 && i < 110){
				Card currCard = new Card("Action", 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true);
				cards.add(currCard);
			}
		}
	}
	
	public Deck(String s){
		//empty deck constructor.
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////Getters/Setters///////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////METHODS///////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	public Card draw() {
		Card temp = cards.get(0);
		cards.remove(0);
		return temp;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////Testing Shuffle///////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/*public static void main(String[] args){
		Deck deck = new Deck();
		for(int i = 0; i < 110; i++){
			System.out.println(deck.getCards().get(i).getColor() + " " + deck.getCards().get(i).getValue());
		}
		System.out.println("-----------------------------------------------------------");
		deck.shuffle();
		for(int i = 0; i < 110; i++){
			System.out.println(deck.getCards().get(i).getColor() + " " + deck.getCards().get(i).getValue());
		}
	}*/
}
