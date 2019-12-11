package library.service.classes;
import library.service.classes.BookGenre;
import library.service.classes.BookRecord;
import java.io.*;
import java.util.Scanner;
public class BookClient{
	private static BookRecord[] record = new BookRecord[5];
	private static int numRecord = 0;
	public static void main(String[] args){
		//args[0] text file, args[1] resize factor
		try{
			File text = new File(args[0]);
			Scanner in = new Scanner(text);
			Scanner userInput = new Scanner(System.in);
			String book, title, genre, author;
			int resize = Integer.parseInt(args[1]);
			while(in.hasNextLine()){
				if(recordFull()){//if it needs to expand
					expand(resize);
					System.out.println("Resized the array from " + (numRecord) + " to " + (numRecord + resize));
				}
				book = in.nextLine();
				String[] parts = book.split(":");
				title = parts[0];
				genre = parts[1];
				author = parts[2];
				String[] authors = author.split(",");
				BookRecord temp = new BookRecord(title, authors, genre);//makes a temp object to use the equals method
				if(duplicate(temp)){//checks if duplicate, if true then not duplicate
					record[numRecord] = new BookRecord(title, authors, genre);
					numRecord += 1;
				}
				else{
					System.out.println("Found duplicate");
					System.out.println(temp);
				}
			}
			boolean start = true;
			while(start){
				System.out.println("Select an option:");
				System.out.println("Type \"S\" to list books of a genre");
				System.out.println("Type \"P\" to print out all the book records");
				System.out.println("Type \"Q\" to quit");
				String user = userInput.next();
				String userGenre;
				switch(user){
					case "S": 	System.out.println("Type a genre. The genres are: ");
								for(BookGenre d: BookGenre.values()){
									System.out.println(d);
								}
								userGenre = userInput.next();
								for(int i = 0; i < record.length; i++){//checks and prints out all the books with the same genre
									if(record[i] == null){
									}
									else if(record[i].getGenre().name().equals(userGenre)){
										System.out.println(record[i]);
									}
									else{
									}
								}
								break;
					case "P": 	for(int i = 0; i < record.length; i++){
									if(record[i] == null){
									}
									else{
										System.out.println(record[i]);
									}
								}
								break;
					case "Q":	System.out.println("Quitting program");
								start = false;
								break;
					default: 	System.out.println("Wrong option. Try again");
								break;		
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static boolean duplicate(BookRecord a){//checks if duplicate
		int count = 0;
		boolean out;
		for(int i = 0; i < record.length; i++){
			if(record[i] == null){
			}
			else if(record[i].equals(a)){
				count += 1;
			}
			else{
			}
		}
		if(count == 0){
			out = true;
		}
		else{
			out = false;
		}
		return out;
	}
	public static void expand(int factor){//expands by resize factor
		BookRecord[] temp = new BookRecord[record.length + factor];
		System.arraycopy(record, 0, temp, 0, record.length);
		record = temp;
	}
	public static boolean recordFull(){//checks if the array is full
		int temp = 0;
		for(int i = 0; i < record.length; i++){
			if(record[i] != null){
				temp += 0;
			}
			else{
				temp += 1; 
			}
		}
		if(temp == 0){
			return true;
		}
		else{
			return false;
		}
	}
}