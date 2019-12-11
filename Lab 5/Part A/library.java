package library.client.classes;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import library.service.classes.BookGenre;
import library.service.classes.BookRecord;
import java.util.Vector;
class library{
	/*Task 1: Declare the vector of objects*/
	Vector<BookRecord> lib;
	
	library(){
		/* Task 2: Initiliaze vector*/
		lib = new Vector<BookRecord>();
		/* Task 3: Print out its capacity and its size*/
		System.out.println("Capacity: " + lib.capacity() + ", Size: " + lib.size());
	}
	
	public void searchByGenre(BookGenre genre){//search the vector for records of specific genre
		/* Task 5: implement searchByGenre() to search for records of a particylar genre in the vector*/
		for(int i = 0; i < lib.size(); i++){
			
			if(genre == lib.elementAt(i).getGenre()){
				System.out.println(lib.elementAt(i));
			}else{
			}
		}
	}
	
	public void print(){//list the records
		/* Task 6: Implement the print() to list out the records*/
		String out = "";
		for(int i = 0 ; i < lib.size(); i++){
			out = out + lib.elementAt(i) + "\n";
		}
		System.out.println(out);
	}
	
		
	public static void main(String []args){//instantiate the library
	//arg[0]: text file
		
		library myLib = new library();
		//read the the files from text files
		String []authors;
		BookRecord aRecord;
		Scanner scan;
		String str;
		try {
			File myFile=new File(args[0]);
            scan=new Scanner(myFile);//each line has the format title:genre:author-name-1,author-name-2..authorname-m
			while(scan.hasNextLine()){
				str=scan.nextLine();				
				String []tok=str.split(":");
				authors=tok[2].split(",");
				aRecord = new BookRecord(tok[0],tok[1],authors);
				/*Task 4: Add the objects to the vector*/
				myLib.lib.addElement(aRecord);
			}
			scan.close();
        }catch(IOException ioe){ 
			System.out.println("The file can not be read");
		}
		
		//User interactive part
		String option1, option2;
		scan = new Scanner(System.in);
		option1="";
		while(!option1.equals("Q")){
			System.out.println("Select an option:");
			System.out.println("Type \"S\" to list books of a genre");
			System.out.println("Type \"P\" to print out all the book recors");		
			System.out.println("Type \"Q\" to Quit");
			option1=scan.nextLine();
			
			switch (option1) {
				case "S":	System.out.println("Type a genre. The genres are:");
							for (BookGenre d : BookGenre.values()) {
									System.out.println(d);
							}
							option2=scan.nextLine(); //assume the user will type in a valid genre
							myLib.searchByGenre(BookGenre.valueOf(option2));//implement this method
							break;									
				
				case "P":   myLib.print();//print the array; implement this method	 
							break;
				
				case "Q":   System.out.println("Quitting interactive part");
							break;
							
				default:	System.out.println("Wrong option! Try again");
							break;
			
			}
		}
			/*Task 7- Create 2 dimensional array using the records from the vector
			The array has rows for GENRE_HISTORY, GENRE_SCIENCE, GENRE_ENGINEERING, GENRE_LITERATURE*/
			BookRecord [][] libAr; //declaration of the 2D array
			libAr = new BookRecord[4][];
	
			int col = 0;
			for (BookGenre d : BookGenre.values()) {//for each genre count the number of records belonging to it and then intantiate its row
			/*add code here*/
				int count = 0;
				for(int i = 0; i < myLib.lib.size(); i++){
					if(d == myLib.lib.elementAt(i).getGenre()){
						count += 1;
					}else{
					}
				}
				libAr[col] = new BookRecord[count];
				int count1 = 0;
				for(int i = 0; i < myLib.lib.size(); i++){
					if(d == myLib.lib.elementAt(i).getGenre()){
						libAr[col][count1] = myLib.lib.elementAt(i);
						count1 += 1;
					}else{
					}
				}
				col += 1;
			}
			System.out.println("Printing out the array. Press enter to proceed");
			option1=scan.nextLine();
			
			/*Task 8: Print out the array*/
			for(int i = 0; i < libAr.length; i++){
				System.out.println(libAr[i][0].getGenre().name());
				for(int j = 0; j < libAr[i].length; j++){
					System.out.print(libAr[i][j]);
				}
				System.out.println("");
			}
			
			System.out.println("Removing the duplicates. Press enter to proceed");
			option1=scan.nextLine();
			
			/* Task 9: Identify and remove the duplicate records IN THE VECTOR (NOT THE ARRAY) and print out the removed records */
			for(int i = 0; i < myLib.lib.size(); i++){
				for(int j = 0; j <myLib.lib.size(); j++){
					if(i != j){
						if(myLib.lib.elementAt(i).equals(myLib.lib.elementAt(j))){
							System.out.println(myLib.lib.elementAt(j));
							myLib.lib.removeElementAt(j);
						}
					}
				}
			}
						
			System.out.println("Note the record nos. of the duplicated records");
			
			System.out.println("Printing out the array. Press enter to proceed");
			option1=scan.nextLine();
			
			/* Task 10: print out the array again; are the duplicated printed out again? */
			libAr = new BookRecord[4][];
	
			col = 0;
			for (BookGenre d : BookGenre.values()) {
				int count = 0;
				for(int i = 0; i < myLib.lib.size(); i++){
					if(d == myLib.lib.elementAt(i).getGenre()){
						count += 1;
					}else{
					}
				}
				libAr[col] = new BookRecord[count];
				int count1 = 0;
				for(int i = 0; i < myLib.lib.size(); i++){
					if(d == myLib.lib.elementAt(i).getGenre()){
						libAr[col][count1] = myLib.lib.elementAt(i);
						count1 += 1;
					}else{
					}
				}
				col += 1;
			}
			for(int i = 0; i < libAr.length; i++){
				System.out.println(libAr[i][0].getGenre().name());
				for(int j = 0; j < libAr[i].length; j++){
					System.out.print(libAr[i][j]);
				}
				System.out.println("");
			}
		}
}