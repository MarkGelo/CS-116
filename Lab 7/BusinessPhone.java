public class BusinessPhone extends Phone{
	private String data;
	
	public BusinessPhone(){
		super();
		data = "9999";
	}
	public BusinessPhone(String a, String e, String n, String d){
		super(a,e,n);
		if(checkNumber(d)){
			data = d;
		}else{
			System.out.println("Invalid input for data extension");
			data = "9999";
		}
	}
	public BusinessPhone(Phone a, String d){
		super(a.getArea(), a.getExchange(), a.getNumber());
		if(checkNumber(d)){
			data = d;
		}else{
			System.out.println("Invalid input for data extension");
			data = "9999";
		}
	}
	
	public boolean checkNumber(String a){//checks if the number is 4 digits and all numbers
		boolean out = true;
		if(a.matches("[0-9]+") && a.length() == 4){
		}else{
			out = false;
		}
		return out;
	}
	
	public void setExtension(String a){
		if(checkNumber(a)){
			data = a;
		}else{
			System.out.println("Invalid input for Extension");
			data = "9999";
		}
	}
	
	public String getExtension(){
		return data;
	}
	
	public String toString(){
		String out = "";
		out = out + super.toString() + " Extension:" + data;
		return out;
		
	}
}