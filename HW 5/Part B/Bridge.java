import java.util.*;
public class Bridge extends CardGame{
	
	public Bridge(){
		super();
		super.setDealtCards(13);
	}
	
	public String displayDescription(){
		String out;
		out = "Bridge: each player holds 13 cards; and the object of play is to win tricks, each trick consisting of one card played by each player. ";
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