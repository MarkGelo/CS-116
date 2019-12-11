public class tutorial{
	public static void main(String[] args){
		int min = 7;
		int max = 15;
		int rndVal;
		int range = max - min + 1;
		for(int i = 0; i < 10; i++){
			rndVal = (int)(Math.random() * (range) + min);
			System.out.println("Random number is " + rndVal);
		}
	}
}