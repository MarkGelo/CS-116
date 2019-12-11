import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.*;
class UseInsurance{
	public static ArrayList<InsuranceGroup> d = new ArrayList<InsuranceGroup>();
	public static void main(String []args){		
	//arg[0]: text file  containing the policy information		
		Scanner scan;
		String str;
		try{
			File myFile=new File(args[0]);
            scan=new Scanner(myFile);//each line has the format 
			//name;age;policy-type{Health or Life}
			InsuranceGroup c = new InsuranceGroup();
			while(scan.hasNextLine()){
				str=scan.nextLine();			
				String []tok=str.split(";");
				String name=tok[0];//name of the policy holder
				int age = Integer.parseInt(tok[1]);//age of the policy holder
				String type = tok[2];//type of the insurance values are "Health" or "Life"
				if(type.compareTo("Health")==0){
					//this is a Health insurance policy		
					HealthInsurance a = new HealthInsurance();
					a.setName(name);
					a.setAge(age);
					if(c.addPolicy(a)){
					}else{
						d.add(c);
						c = new InsuranceGroup();
						c.addPolicy(a);
					}
				}
				else{
					//this is a Life insurance policy
					LifeInsurance b = new LifeInsurance();
					b.setName(name);
					b.setAge(age);
					if(c.addPolicy(b)){
					}else{
						d.add(c);
						c = new InsuranceGroup();
						c.addPolicy(b);
					}
				}
				if(scan.hasNextLine()){
				}else{
					d.add(c);
				}
			}
			scan.close();
			for(InsuranceGroup i: d){
				System.out.println(i.toString());
				System.out.println();
			}
        }catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}
		
	}
}