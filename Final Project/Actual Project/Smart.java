package classes;
import classes.Appliances;
import java.util.Random;
public class Smart extends Appliances{
	//private int state;//0 = off, 1 = low, 2 = on
	//private double wattage;
	//i set the wattage and states to public in appliances to make it easier
	public float reduction;
	
	public Smart(){
		super();
		rngState();
		reduction = 0;
		this.checkWattage();
		smart = 1;
	}
	public Smart(int loc, String t, int on, float prob,float red){
		super(loc,t,on,prob);
		reduction = red;
		rngState();
		this.checkWattage();
		smart = 1;
	}
	public void checkWattage(){
		if(state == 0){
			wattage = 0;
		}else if(state == 2){//if on
			wattage = super.getOnWattage();
		}else if(state == 1){//if low
			wattage = super.getOnWattage() * (1 - reduction);
		}
	}
	public void rngState(){//setting appliances on or off based on probability
		state = this.rngOn();
		this.checkWattage();//applies the correct wattage
	}
	public int rngOn(){//calculates if its on or off at the time using the probability
		int out;
		int prob = (int)(super.getProbabilityOn() * 100); //gets the percent
		Random rand = new Random();
		int rng = rand.nextInt(100) + 1; //random number between 1 - 100
		if(rng <= prob){
			out = 2;//on
		}else{
			out = 0;//off
		}
		return out;
	}
	public String toString(){
		String out = super.toString();
		String onOff = "";
		if(state == 0){
			onOff = "off";
		}else if(state == 1){
			onOff = "low";
		}else if(state == 2){
			onOff = "on";
		}else{
		}
		out = out + ",Smart," + reduction + "," + onOff + "," + wattage;
		return out;
	}
}