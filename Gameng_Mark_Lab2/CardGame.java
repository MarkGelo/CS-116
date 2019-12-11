package library.client.classes;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/*Task 2: Import necessary user defined classes */
import carddeck.service.classes.Card;
import carddeck.service.classes.CardSign;
import carddeck.service.classes.CardValue;
class CardGame{
	Card [] userHand;
	Card [] dealerHand;
	

    private void generateDealerHand(){
		/*Task 5: Implement the class method generateDealerHand() in CardGame class. This method will use a random generator to generate signs, and values of the cards for the dealer.*/
		dealerHand = new Card[5];
		CardSign s = null;
		CardValue v = null;
		int randomSign;
		int randomValue;
		for(int i = 0; i < dealerHand.length; i++){
			randomValue = (int)(Math.random() * 13);
			randomSign = (int)(Math.random() * 4);
			switch(randomValue){
				case 0: v = CardValue.ACE; break;
				case 1: v = CardValue.TWO; break;
				case 2: v = CardValue.THREE; break;
				case 3: v = CardValue.FOUR; break;
				case 4: v = CardValue.FIVE; break;
				case 5: v = CardValue.SIX; break;
				case 6: v = CardValue.SEVEN; break;
				case 7: v = CardValue.EIGHT; break;
				case 8: v = CardValue.NINE; break;
				case 9: v = CardValue.TEN; break;
				case 10: v = CardValue.JACK; break;
				case 11: v = CardValue.QUEEN; break;
				case 12: v = CardValue.KING; break;
			}
			switch(randomSign){
				case 0: s = CardSign.SPADE; break;
				case 1: s = CardSign.CLUB; break;
				case 2: s = CardSign.DIAMOND; break;
				case 3: s = CardSign.HEART; break;
			}
			dealerHand[i] = new Card(s,v);
		}
	}
	
	private int getScore(){
		/*Task 3: Implement the class method getScore() in CardGame class. This method will compare the cards of the dealer and player and provide a score. If the score is zero, it means the game is a tie. If the score is positive, then the player has won the game. You should implement other methods as needed.*/
		int dealerScore;
		int userScore;
		int out;
		if(flush(dealerHand) && royalFlush(dealerHand)){
			dealerScore = 2;
		}
		else if(flush(dealerHand)){
			dealerScore = 1;
		}
		else{
			dealerScore = 0;
		}
		if(flush(userHand) && royalFlush(userHand)){
			userScore = 2;
		}
		else if(flush(userHand)){
			userScore = 1;
		}
		else{
			userScore = 0;
		}
		if(userScore > dealerScore){
			out = 1;
		}
		else if(userScore < dealerScore){
			out = -1;
		}
		else{
			out = 0;
		}
		return out;
	}
	private static boolean royalFlush(Card[] a){//checks if royal flush
		int[] check = {1,1,1,1,1};
		int sum = 0;
		CardValue q,w,e,r,t;
		q = CardValue.ACE; w = CardValue.KING; e = CardValue.QUEEN; r = CardValue.JACK; t = CardValue.TEN;
		for(int i = 0; i < a.length; i++){
			if(a[i].getValue() == q){
				check[0] = 0;
			}
			else if(a[i].getValue() == w){
				check[1] = 0;
			}
			else if(a[i].getValue() == e){
				check[2] = 0;
			}
			else if(a[i].getValue() == r){
				check[3] = 0;
			}
			else if(a[i].getValue() == t){
				check[4] = 0;
			}
		}
		for(int i = 0; i < check.length; i++){
			sum += check[i];
		}
		if(sum == 0){
			return true;
		}
		else{
			return false;
		}
	}
	private static boolean flush(Card[] a){//check if flush
		if(a[0].getSign() == a[1].getSign() && a[1].getSign() == a[2].getSign() && a[2].getSign() == a[3].getSign() && a[3].getSign() == a[4].getSign()){
			return true;
		}
		else{
			return false;
		}
	}
	public void printHand(){//prints the hand
		System.out.println("User's hand:");
		for(int i = 0; i < userHand.length; i++){
			System.out.println("Card: " + userHand[i].getValue() + " of " + userHand[i].getSign());
		}
		System.out.println("Dealer's hand:");
		for(int i = 0; i < dealerHand.length; i++){
			System.out.println("Card: " + dealerHand[i].getValue() + " of " + dealerHand[i].getSign());
		}
	}
	public static void main(String []args){
	//arg[0]: file containing user hand
		CardGame game=new CardGame();
		//read the the files from text files
		int counter=0;
		Card aCard;
		Scanner scan;
		String str;
		game.userHand = new Card[5];
		int temp = 0;
		CardSign s = null;
		CardValue v = null;
		try {
			File myFile=new File(args[0]);
            scan=new Scanner(myFile);
			while(scan.hasNextLine()){
				str=scan.nextLine();				
				String []tok=str.split(":");
				if(tok[0].equals("SPADE")){
					s = CardSign.SPADE;
				}
				else if(tok[0].equals("CLUB")){
					s = CardSign.CLUB;
				}
				else if(tok[0].equals("DIAMOND")){
					s = CardSign.DIAMOND;
				}
				else if(tok[0].equals("HEART")){
					s = CardSign.HEART;
				}
				if(tok[1].equals("ACE")){
					v = CardValue.ACE;
				}
				else if(tok[1].equals("TWO")){
					v = CardValue.TWO;
				}
				else if(tok[1].equals("THREE")){
					v = CardValue.THREE;
				}
				else if(tok[1].equals("FOUR")){
					v = CardValue.FOUR;
				}
				else if(tok[1].equals("FIVE")){
					v = CardValue.FIVE;
				}
				else if(tok[1].equals("SIX")){
					v = CardValue.SIX;
				}
				else if(tok[1].equals("SEVEN")){
					v = CardValue.SEVEN;
				}
				else if(tok[1].equals("EIGHT")){
					v = CardValue.EIGHT;
				}
				else if(tok[1].equals("NINE")){
					v = CardValue.NINE;
				}
				else if(tok[1].equals("TEN")){
					v = CardValue.TEN;
				}
				else if(tok[1].equals("JACK")){
					v = CardValue.JACK;
				}
				else if(tok[1].equals("QUEEN")){
					v = CardValue.QUEEN;
				}
				else if(tok[1].equals("KING")){
					v = CardValue.KING;
				}
				game.userHand[temp] = new Card(s, v);
				temp += 1;
			/*Task 4: Implement the code in the main method of the CardGame class, that will take the values read from the text file, create Card objects and populate the array Hand. userHand is an attribute of the CardGame class.*/
			}			
		
		//lets play iPoker!!
		//User interactive part
		String option1;
		scan = new Scanner(System.in);
		int score;
		while(true){
			System.out.println("Select an option:");
			System.out.println("Type \"P\" to play a round of iPoker");			
			System.out.println("Type \"Q\" to Quit");
			option1=scan.nextLine();
			
			switch (option1) {								 
				case "P":   game.generateDealerHand();
				            score=game.getScore();
							game.printHand();///First print out the hands
							System.out.println("\n\nCompare the two hands:");
							if(score < 0)
								System.out.println("Dealer Wins :-(");
							else if (score == 0)
								System.out.println("Its a draw");
							else if (score > 0)
								System.out.println("Congrats You win !!");
							else
								System.out.println("Somethings wrong!");
							break;
				
				case "Q":   System.out.println("Quitting program");
							System.exit(0);
							
				default:	System.out.println("Wrong option! Try again");
							break;
			
			}			
		}
		}catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}catch(IllegalArgumentException ia){ 
            System.out.println(ia.getMessage());
		} catch(NullPointerException np){
			System.out.println(np.getMessage());
		}
	}	

}