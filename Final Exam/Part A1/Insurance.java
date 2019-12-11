public abstract class Insurance{
	private int id;
	private static int count = 0;
	private String name;
	private int age;
	private String policy;
	private int fee;
	
	public Insurance(){
		count += 1;
		id = count;
	}
	public void setPolicyID(int d){
		id = d;
	}
	public int getPolicyID(){
		return id;
	}
	public void setCost(int c){
		fee = c;
	}
	public int getCost(){
		return fee;
	}
	public void setName(String policyHolderName){
		name = policyHolderName;
	}
	public String getName(){
		return name;
	}
	public void setAge(int policyHolderAge){
		age = policyHolderAge;
	}
	public int getAge(){
		return age;
	}
	public void setType(String policyType){
		policy = policyType;
	}
	public String getType(){
		return policy;
	}
	
	public abstract void setCost();
	
}