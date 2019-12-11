public class OverNightPackage extends Package{
	
	public OverNightPackage(){
		super();
	}
	public OverNightPackage(String f, String t, float w){
		super(f,t,w);
	}
	
	public float calculateCharge(){
		float out = super.calculateCharge();
		out = out + (super.getWeight() * overNightExtraCharge);
		return out;
	}
	
	public String printReceipt(){
		String out;
		out = "Receipt for Package ID: " + super.getId() + "\n";
		out = out + "Type: Over Night Package" + "\n";
		out = out + "From Address: " + super.getFromAddress() + "\n";
		out = out + "To Address: " + super.getToAddress() + "\n";
		out = out + "Weight: " + super.getWeight() + " oz." + "\n";
		out = out + "Charge: $" + this.calculateCharge();
		return out;
	}
}