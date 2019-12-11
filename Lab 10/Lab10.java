public class Lab10{
	
	public static void main(String[] args){
		String test = "racecaer";
		System.out.println(test);
		System.out.println("Palindrome: " + testPalindrome(test));
	}
	
	public static boolean testPalindrome(String p){
		if(p.length() == 0 || p.length() == 1){
			return true;
		}else if(p.charAt(0) == ' '){//ignore spaces
			return testPalindrome(p.substring(1, p.length()));//deletes the space
		}else if(p.charAt(p.length()-  1) == ' '){
			return testPalindrome(p.substring(0, p.length() - 1));//deletes the space
		}else if(Character.toString(p.charAt(0)).equalsIgnoreCase(Character.toString(p.charAt(p.length() - 1)))){//check if first and last are the same, also ignores capitalization
			System.out.println(p.substring(1, p.length() - 1));
			return testPalindrome(p.substring(1, p.length() - 1));//delete the first and last from string
		}
		return false;
	}
}