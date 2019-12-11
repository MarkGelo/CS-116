import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.*;
class PackageClient{
	public static void main(String []args){
		//read the package information from the file
		//file format is 
		//from-address:to-address:wt:package-type
		//package-type=1 (two day) 2(overnight)
		
		String line=new String();
		try{
			//read the file and create the objects
			File textFile = new File("package-dup.txt");
			Scanner scan = new Scanner(textFile);
			ArrayList<Package> packages = new ArrayList<Package>();
			while(scan.hasNextLine())
			{
				line=scan.nextLine();				
				String []tok=line.split(":");
				String fromAddress=tok[0];
				String toAddress=tok[1];
				float wt=Float.parseFloat(tok[2]);
				int type=Integer.parseInt(tok[3]);
				if(type == 1){//type 1 two day
					packages.add(new TwoDayPackage(fromAddress, toAddress, wt));
				}else{//if type 2, overnight
					packages.add(new OverNightPackage(fromAddress, toAddress, wt));
				}
			}
			HashSet<String> checkDups = new HashSet<String>();//only unique strings can be stored here
			for(Package packs: packages){//checks if duplicate
				checkDups.add(packs.getFromAddress() + packs.getToAddress() + packs.getWeight());
			}
			ArrayList<Package> notDuplicates = new ArrayList<Package>();
			for(Package packs: packages){
				String check = packs.getFromAddress() + packs.getToAddress() + packs.getWeight();
				for(String notDups: checkDups){
					if(check.equals(notDups)){
						notDuplicates.add(packs);//adds the packs that are not duplicates
					}
				}
			}
			for(Package packs: notDuplicates){
				System.out.println(packs.printReceipt());
			}
			
		}catch(IOException e){
			System.out.println("Issuse with reading the file. Aborting");
			System.out.println(e.getMessage());
		}
	}
}