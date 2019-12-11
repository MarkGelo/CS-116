import java.util.*;
public class InsuranceGroup{
	private int id;
	private static int count = 1000;
	private ArrayList<Insurance> group = new ArrayList<Insurance>();
	
	public InsuranceGroup(){
		id = count;
		count += 1;
	}
	public void setId(int i){
		id = i;
	}
	public String getId(){
		String out = "GR-" + id;
		return out;
	}
	public ArrayList<Insurance> getGroup(){
		return group;
	}
	
	public String toString(){
		String out;
		out = "Group id: " + this.getId() + "\n";
		out = out + "No. of Policies: " + group.size() + "\n";
		out = out + "Monthly Fee: " + this.getMonthlyFee() + "\n";
		out = out + "Average age: " + this.getAverageAge();
		return out;
	}
	
	public int getMonthlyFee(){
		int total = 0;
		for(Insurance i: group){
			total += i.getCost();
		}
		return total;
	}
	public double getAverageAge(){
		int totalAge = 0;
		for(Insurance i: group){
			totalAge += i.getAge();
		}
		double avgAge = (double)totalAge/ group.size();
		return avgAge;
	}
	public boolean addPolicy(Insurance a){
		boolean out = true;
		if(group.size() < 5 || this.getAverageAge() < 45){
			group.add(a);
		}else{
			out = false;
		}
		return out;
	}
}