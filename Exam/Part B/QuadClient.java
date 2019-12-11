package Midterm.Client;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import Midterm.Service.House;
import Midterm.Service.Quad;
public class QuadClient{
	
	public static void main(String args[]){
		String line = new String();
		try{
			File textFile = new File("HouseTxt.txt");
			Scanner scan = new Scanner(textFile);
			int count = 0;
			while(scan.hasNextLine())//checks how many houses there are
			{
				line=scan.nextLine();	
				count += 1;
			}
			scan = new Scanner(textFile);//goes back to first line
			Quad q = new Quad(count);
			while(scan.hasNextLine()){
				line = scan.nextLine();
				String[] parts = line.split(":");
				q.addHouse(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));//the addhouse method checks for duplicate entry and adds the men and women to the one already in the data
			}
			q.sortRatio();//sorts the houses by ratio, decreasing order
			q.balance();//balances
			System.out.println(q);
		}catch(IOException e){
			System.out.println("Issuse with reading the file. Aborting");
			System.out.println(e.getMessage());
		}
	}
	
}