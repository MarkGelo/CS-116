import java.util.*;
public abstract class CardGame{
	private ArrayList<Card> deck;
	private int dealtCards;
	
	public CardGame(){
		this.createDeck();
		this.shuffle();
	}
	
	public void setDealtCards(int d){
		dealtCards = d;
	}
	public int getDealtCards(){
		return dealtCards;
	}
	public Card getCard(){
		return deck.get(0);
	}
	public void removeCard(){
		deck.remove(0);
	}
	public void createDeck(){
		ArrayList<Card> temp = new ArrayList<Card>();
		String[] suits = {"Hearts" , "Spades" , "Clubs" , "Diamonds"};
		for(int k = 0; k < suits.length; k++){
			for(int j = 1; j < 14; j++){
				Card temp1 = new Card(suits[k], j);
				temp.add(temp1);
			}
		}
		deck = temp;
	}
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	public abstract String displayDescription();
	public abstract ArrayList<Card> deal();
}