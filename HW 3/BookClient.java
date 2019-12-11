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
			String book, title, genre, author, tag;
			int length;
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
				tag = parts[3];
				length = Integer.parseInt(parts[4]);
				String[] authors = author.split(",");
				BookRecord temp = new BookRecord(title, authors, genre, tag, length);//makes a temp object to use the equals method
				if(duplicate(temp)){//checks if duplicate, if true then not duplicate
					record[numRecord] = new BookRecord(title, authors, genre, tag, length);
					numRecord += 1;
				}
				else{
					System.out.println("Found duplicate");
					System.out.println(temp);
				}
			}
			record = sortString(record, numRecord).clone();//sorts books by lexi...
			boolean start = true;
			while(start){
				System.out.println("Select an option:");
				System.out.println("Type \"S\" to list books of a genre");
				System.out.println("Type \"P\" to print out all the book records");
				System.out.println("Type \"T\" to search for a record with a specific tag");
				System.out.println("Type \"Q\" to quit");
				String user = userInput.next();
				String userGenre;
				switch(user){
					case "S": 	System.out.println("Type a genre. The genres are: ");
								for(BookGenre d: BookGenre.values()){
									System.out.println(d);
								}
								userGenre = userInput.next();
								BookRecord[] sorted = sortPages(record, numRecord).clone();//sorts by pages
								for(int i = 0; i < sorted.length; i++){//checks and prints out all the books with the same genre
									if(sorted[i] == null){
									}
									else if(sorted[i].getGenre().name().equals(userGenre)){
										System.out.println(sorted[i]);
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
					case "T":	System.out.println("Type in the tag of the book you want to search");//searches by tag
								String tagUser = userInput.next();
								searchTag(tagUser);
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
	public static BookRecord[] sortString(BookRecord[] array1, int number){//sorts tags lexi...
		BookRecord[] out = new BookRecord[number];
		BookRecord[] array = array1.clone();
		for(int i = 0; i < number; i++){
			int count = 0;
			
			for(int j = 0; j < number; j++){
				
				if(array[i].getTag().compareTo(array[j].getTag()) < 0){
					count += 1;
				}else{
				}
			}
			out[number - count - 1] = array[i];
		}
		return out;
	}
	public static BookRecord[] sortPages(BookRecord[] array1, int number){//sorts by pages, selection sort
		BookRecord[] array = array1.clone();
		for(int i = 0; i < number; i++){
			int length = array.length - i;
			int index = 0;
			
			for(int j = 1; j < length; j++){
				
				if(array[j].getLength() > array[index].getLength()){//increasing order
					index = j;
				}
			}
			BookRecord temp = array[index];
			array[index] = array[length - 1];
			array[length - 1] = temp;
		}
		return array;
	}
	public static void searchTag(String tag){//searches by tag. binary search
		int start = 0;
		int end = numRecord - 1;
		String out = null;
		while(end >= start){
			int middle = (start + end) / 2;
			if(record[middle].getTag().equals(tag)){
				out = record[middle].toString();//found
				break;
			}else if(record[middle].getTag().compareTo(tag) > 0){
				end = middle - 1;
			}else{
				start = middle + 1;
			}
		}
		
		if(out == null){
			System.out.println("No Match Found");
		}else{
			System.out.println("Found a match");
			System.out.println(out);
		}
	}
}