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
			File textFile = new File("package.txt");
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
			for(Package packs: packages){
				System.out.println(packs.printReceipt());
			}
			
		}catch(IOException e){
			System.out.println("Issuse with reading the file. Aborting");
			System.out.println(e.getMessage());
		}
	}
}