public class PlayCardGames{
	public static void main(String[] args){
		Poker poke = new Poker();
		Bridge brid = new Bridge();
		System.out.println(poke.displayDescription());
		System.out.println("Dealing Cards for Poker:");
		System.out.println(poke.deal() + "\n");
		
		System.out.println(brid.displayDescription());
		System.out.println("Dealing cards for Bridge:");
		System.out.println(brid.deal() + "\n");
	}
}