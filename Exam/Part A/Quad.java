package Midterm.Service;
import Midterm.Service.House;
public class Quad{
	private House[] houses;
	private static int count = 0;
	
	public Quad(){//default
		houses = new House[12];
	}
	public Quad(int limit){//non default
		houses = new House[limit];
	}
	
	public int getNumberHouses(){//gets the current number of house object in collection
		return count;
	}
	
	public boolean addHouse(String n, int m, int w){//adds house, if room, true
		House check = new House(n, m, w);
		for(int i = 0; i < count; i++){//checks for duplicate houses, then adds the men and women if there are
			if(houses[i] == null){
			}else if(check.getName().equals(houses[i].getName())){
				houses[i].setMen(houses[i].getMen() + m);
				houses[i].setWomen(houses[i].getWomen() + w);
				return true;
			}else{
			}
		}
		if(count == houses.length - 1){//checks if theres no more room
			return false;
		}else{
			houses[count] = new House(n, m, w);
			count += 1;
			return true;
		}
	}
	
	public String toString(){
		String out = "";
		for(int i = 0; i < houses.length; i++){
			if(houses[i] == null){
			}else{
				out = out + houses[i] + "\n";
			}
		}
		return out;
	}
	
	public void sortRatio(){//sorts the houses by ratio in decreasing order
		House[] temp = houses.clone();
		for(int i = 0; i < count; i++){
			int length = temp.length - i;
			int in = 0;
			for(int j = 1; j < length; j++){
				if(temp[j] == null || temp[in] == null){
				}else if(temp[j].ratioMaleFemale() < temp[in].ratioMaleFemale()){
					in = j;
				}
			}
			House temp1 = temp[in];
			temp[in] = temp[length - 1];
			temp[length - 1] = temp1;
		}
		houses = temp.clone();
	}
}