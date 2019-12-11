package classes;
public abstract class Appliances{
	private String type;
	private int onWat;
	private float probOn;
	private int location;
	private int id;
	private static int count = 1;
	public int smart;
	public double wattage;
	public int state;//0 = off, 1 = low, 2 = on
	
	public Appliances(){
		type = null;
		onWat = 0;
		probOn = 0;
		location = 0;
		id = count;
		count += 1;
	}
	public Appliances(int loc, String t, int on, float prob){
		location = loc;
		type = t;
		onWat = on;
		probOn = prob;
		id = count;
		count += 1;
	}
	
	public String getType(){
		return type;
	}
	public int getOnWattage(){
		return onWat;
	}
	public float getProbabilityOn(){
		return probOn;
	}
	public int getLocation(){
		return location;
	}
	public int getId(){
		return id;
	}
	
	public String toString(){
		String out;
		out = id + "," + location + "," + type + "," + onWat + "," + probOn + ",";
		return out;
	}
	
	public abstract void rngState();
	public abstract int rngOn();
	public abstract void checkWattage();
}