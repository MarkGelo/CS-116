package MainClass.OtherClasses;
import MainClass.OtherClasses.States;
import MainClass.OtherClasses.Destinations;
public class Ticket{
	private Destinations dest;
	private States state;
	private String lastName;
	private String month;
	private int id;
	private static int count = 1;
	
	public Ticket(){//default
		id = count;
		count += 1;
		dest = Destinations.NONE;
		state = States.NONE;
		lastName = "No_Name";
		month = "No_Month";
	}
	public Ticket(String destin, String stat, String name, String mon){//non default 
		id = count;
		count += 1;
		lastName = name;
		month = mon;
		switch(destin){
			case "CHICAGO": dest = Destinations.CHICAGO; break;
			case "NEW_YORK": dest = Destinations.NEW_YORK; break;
			case "SOME_CITY": dest = Destinations.SOME_CITY; break;
			case "TAMPA": dest = Destinations.TAMPA; break;
			case "MIAMI": dest = Destinations.MIAMI; break;
			case "LOS_ANGELES": dest = Destinations.LOS_ANGELES; break;
			case "SAN_FRANCISCO": dest = Destinations.SAN_FRANCISCO; break;
			case "NONE": dest = Destinations.NONE; break;
			default: dest = null; break;
		}
		switch(stat){
			case "ILLINOIS": state = States.ILLINOIS; break;
			case "NEW_YORK": state = States.NEW_YORK; break;
			case "FLORIDA": state = States.FLORIDA; break;
			case "CALIFORNIA": state = States.CALIFORNIA; break;
			case "NONE": state = States.NONE; break;
			default: state = null; break;
		}
	}
	
	public Destinations getDestination(){//accessors
		return dest;
	}
	public States getStates(){
		return state;
	}
	public String getName(){
		return lastName;
	}
	public String getMonth(){
		return month;
	}
	
	public void setDestination(Destinations destination){//mutators
		dest = destination;
	}
	public void setState(States stat){
		state = stat;
	}
	
	public String toString(){//string method
		String out = "";
		out = out + "Ticket ID: " + id + ", Name: " + lastName + ", Month: " + month + ", State: " + state.name() + ", Destination: " + dest.name();
		return out;
	}
	
	public double price(){//finds price
		double price = 0.0;
		if(dest == null || dest.name().equals("NONE")){
			price = 0.0;
		}else if(dest.name().equals("CHICAGO") || dest.name().equals("SOME_CITY") && state.name().equals("NEW_YORK") || dest.name().equals("MIAMI")){
			price = 200.0;
		}else if(dest.name().equals("NEW_YORK") || dest.name().equals("TAMPA")){
			price = 300.0;
		}else if(dest.name().equals("SOME_CITY") && state.name().equals("CALIFORNIA")){
			price = 400.0;
		}else if(dest.name().equals("LOS_ANGELES") || dest.name().equals("SAN_FRANCISCO")){
			price = 500.0;
		}else{
		}
		return price;
	}
	
	public double calculatePrice(){//calculates price
		double cost = price();
		if(month.equals("Jan") || month.equals("Feb") || month.equals("March")){
			if(state.name().equals("CALIFORNIA") || state.name().equals("FLORIDA")){
				cost = cost * 1.2;
			}
		}else if(month.equals("July") || month.equals("Aug")){
			if(state.name().equals("FLORIDA")){
				cost = cost * 0.8;
			}
		}else{
		}
		return cost;
	}
}