public abstract class Package implements ChargeConstants{
	private int id;
	private static int count = 10000;
	private String fromAddress;
	private String toAddress;
	private float weight;
	
	public Package(){
		id = count;
		count += 1;
		fromAddress = null;
		toAddress = null;
		weight = 0;
	}
	public Package(String f, String t, float w){
		id = count;
		count += 1;
		fromAddress = f;
		toAddress = t;
		weight = w;
	}
	
	public void setFromAddress(String f){
		fromAddress = f;
	}
	public void setToAddress(String t){
		toAddress = t;
	}
	public void setWeight(float w){
		weight = w;
	}
	public void setId(int i){
		id = i;
	}
	
	public int getId(){
		return id;
	}
	public String getFromAddress(){
		return fromAddress;
	}
	public String getToAddress(){
		return toAddress;
	}
	public float getWeight(){
		return weight;
	}
	
	public float calculateCharge(){
		float out;
		out = weight * baseCharge;
		return out;
	}
	
	public abstract String printReceipt();
}