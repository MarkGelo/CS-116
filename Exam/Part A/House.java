package Midterm.Service;
public class House{
	private String name;
	private int men;
	private int women;
	
	public House(){//default
		name = null;
		men = 0;
		women = 0;
	}
	public House(String n, int m, int w){//non default
		name = n;
		men = m;
		women = w;
	}
	
	public void setName(String n){//setters
		name = n;
	}
	public void setMen(int m){
		men = m;
	}
	public void setWomen(int w){
		women = w;
	}
	
	public String getName(){//getters
		return name;
	}
	public int getMen(){
		return men;
	}
	public int getWomen(){
		return women;
	}
	
	public String toString(){//to string
		String out = "Name of House: " + name + "\n";
		out = out + "Men: " + men + ", Women: " + women + ", Ratio: " + this.ratioMaleFemale();
		return out;
	}
	
	public double ratioMaleFemale(){
		if(women == 0){//cant divide by 0
			return 0;
		}else{
			return (double)men/women;
		}
	}
}