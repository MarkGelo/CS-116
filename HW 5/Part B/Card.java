public class Card{
	private String suit;
	private int value;
	
	public Card(){
		suit = "None";
		value = 0;
	}
	public Card(String s, int v){
		suit = s;
		value = v;
	}
	
	public void setSuit(String s){
		suit = s;
	}
	public void setValue(int v){
		value = v;
	}
	
	public String getSuit(){
		return suit;
	}
	public int getValue(){
		return value;
	}
	
	public String toString(){
		String out;
		out = value + " of " + suit;
		return out;
	}
	
}