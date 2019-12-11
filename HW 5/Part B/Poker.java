import java.util.*;
public class Poker extends CardGame{
	
	public Poker(){
		super();
		super.setDealtCards(5);//pdf says 5
	}
	
	public String displayDescription(){
		String out;
		out = "Poker: Each player tries to make the best possible hand (five cards) from the cards they are allowed to use. To know if one hand beats another hand, the hands are compared against a ranking system used commonly in nearly all poker games.";
		return out;
	}
	
	public ArrayList<Card> deal(){
		ArrayList<Card> temp = new ArrayList<Card>();
		for(int i = 0; i < super.getDealtCards(); i++){
			temp.add(super.getCard());//gets card from top of deck
			super.removeCard();//removes card from top of deck.
		}
		return temp;
	}
}