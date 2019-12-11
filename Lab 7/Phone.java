public class Phone{
	private String area, exchange, number;
	
	public Phone(){
		area = "999";
		exchange = "999";
		number = "9999";
	}
	public Phone(String a, String e, String n){
		if(checkAreaExchange(a)){
			area = a;
		}else{
			System.out.println("Invalid input for Area code");
			area = "999";
		}
		if(checkAreaExchange(e)){
			exchange = e;
		}else{
			System.out.println("Invalid input for Exchange");
			exchange = "999";
		}
		if(checkNumber(n)){
			number = n;
		}else{
			System.out.println("Invalid input for number");
			number = "9999";
		}
	}
	
	public boolean checkAreaExchange(String a){//checks if 3 digits and starts with numbers 2 - 9
		boolean out = true;
		if(a.matches("[0-9]+") && a.length() == 3 && Integer.parseInt(a) >= 200){
		}else{
			out = false;
		}
		return out;
	}
	public boolean checkNumber(String a){//checks if the number is 4 digits and all numbers
		boolean out = true;
		if(a.matches("[0-9]+") && a.length() == 4){
		}else{
			out = false;
		}
		return out;
	}
	
	public void setArea(String a){
		if(checkAreaExchange(a)){
			area = a;
		}else{
			System.out.println("Invalid input for Area code");
			area = "999";
		}
	}
	public void setExchange(String a){
		if(checkAreaExchange(a)){
			exchange = a;
		}else{
			System.out.println("Invalid input for Exchange");
			exchange = "999";
		}
	}
	public void setNumber(String a){
		if(checkNumber(a)){
			number = a;
		}else{
			System.out.println("Invalid input for number");
			number = "9999";
		}
	}
	
	public String getArea(){
		return area;
	}
	public String getExchange(){
		return exchange;
	}
	public String getNumber(){
		return number;
	}
	
	public String toString(){
		String out = "Phone Number: (" + area + ") " + exchange + "-" + number;
		return out;
	}
}