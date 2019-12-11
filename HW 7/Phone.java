import java.util.Scanner;
import java.util.*;
public class Phone{
	private static final HashMap<String, String> dial = new HashMap<String, String>(){//hashmap for the dials
		{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};
	private static Vector<String> mnemo = new Vector<String>();//where the mnemonics will be placed
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Type in a list of numbers");
		String num = in.next();
		for(int i = 0; i < num.length(); i++){//iterates through string just in case multiple 1 and 0s
			if(num.indexOf('0') != -1){//takes out character 0
				num = num.substring(0, num.indexOf('0')) + num.substring(num.indexOf('0') + 1);
			}else if(num.indexOf('1') != -1){//takes out character 1
				num = num.substring(0, num.indexOf('1')) + num.substring(num.indexOf('1') + 1);
			}
		}
		listMnemonics(num);
		for(String mnem: mnemo){
			System.out.print(mnem + " ");
		}
	}
	
	public static Vector<String> listMnemonics(String number){
		recursionMnemonics("", number);//actual recursive method
		return mnemo;
	}
	
	public static void recursionMnemonics(String comb, String digits){
		if(digits.length() == 0){//base case no more digits to iterate through for the number of options
			mnemo.add(comb);
		}else{//digits left to iterate through
			String dig = digits.substring(0,1);//gets the first digit
			String let = dial.get(dig);//get the letters in hashmap corresponding to the digit
			for(int i = 0; i < let.length(); i++){//iterates through the letters in that number
				String letter = dial.get(dig).substring(i, i + 1);
				//add the letter to the combination and lessen the digits left to go through
				recursionMnemonics(comb + letter, digits.substring(1));
			}
		}
	}
}