package classes;
import classes.Appliances;
import java.util.Random;
public class Regular extends Appliances{
	//private int state; //0 = off, 2 = on;
	//private int wattage;
	//i set the wattage and states to public in appliances to make it easier
	public Regular(){
		super();
		rngState();
		this.checkWattage();//sets the wattage if on or off
		smart = 0;
	}
	public Regular(int loc, String t, int on, float prob){
		super(loc,t,on,prob);
		rngState();
		this.checkWattage();//sets the wattage if on or off
		smart = 0;
	}
	public void checkWattage(){
		if(state == 0){
			wattage = 0;
		}else{//if on
			wattage = super.getOnWattage();
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
		}else if(state == 2){
			onOff = "on";
		}else{
		}
		out = out + ",Regular," + onOff + "," + wattage;
		return out;
	}
}