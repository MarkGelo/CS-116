package MainClass;
import MainClass.OtherClasses.States;
import MainClass.OtherClasses.Destinations;
import MainClass.OtherClasses.Ticket;
import java.util.Scanner;
import java.io.*;
public class TicketClient{
	public static void main(String[] args){
		try{
			File text = new File("data.txt");//addeda duplicate in the text file to check
			Scanner in = new Scanner(text);
			int count = 0;
			String temp;
			while(in.hasNextLine()){
				count += 1;
				temp = in.nextLine();
			}
			Ticket[] tickets = new Ticket[count];
			in = new Scanner(text);//goes back to the beginning of file
			count = 0;
			int checkDuplicate = 0;
			while(in.hasNextLine()){
				temp = in.nextLine();
				String[] parts = temp.split(",");
				if(count == 0){
				}else{
					for(int i = count - 1; i >= 0; i -= 1){
						if(tickets[i].getDestination().name().equals(parts[0]) && tickets[i].getStates().name().equals(parts[1]) && tickets[i].getName().equals(parts[2]) && tickets[i].getMonth().equals(parts[3])){
							checkDuplicate = 1;
							break;
						}else{
							checkDuplicate = 0;
						}
					}
				}
				if(checkDuplicate == 0){
					tickets[count] = new Ticket(parts[0], parts[1], parts[2], parts[3]);
					System.out.println(tickets[count]);
					System.out.println("Price: " + tickets[count].calculatePrice());
					count += 1;
				}else{
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}