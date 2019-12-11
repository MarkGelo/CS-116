import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class SupplyOrderManagement{
	private static int orderCount = 0;
	private static SupplyOrderSystem[] orders;
	public static void main(String[] args){
		try{
			File text = new File("orders.txt");
			Scanner in = new Scanner(text);
			String temp;
			int count = 0;
			while(in.hasNextLine()){
				temp = in.nextLine();
				count += 1;
			}
			orders = new SupplyOrderSystem[count];
			in = new Scanner(text);
			while(in.hasNextLine()){
				temp = in.nextLine();
				addOrder(temp);//adds the orders
			}
			
			boolean start = true;
			Scanner userInput = new Scanner(System.in);
			while(start){
				System.out.println("Select an option:");
				System.out.println("Type \"A\" to add an order");
				System.out.println("Type \"D\" to delete an order");
				System.out.println("Type \"L\" to list all orders for a particular customer id");
				System.out.println("Type \"Q\" to quit");
				String user = userInput.next();
				switch(user){
					case "A": 	System.out.println("Type in the order in the the correct form like the one in the text file");
								addOrderUser(userInput.next() + " " + userInput.next());
								break;
					case "D": 	System.out.println("Type in a order ID to delete");
								deleteOrder(Integer.parseInt(userInput.next()));
								break;
					case "L":	System.out.println("Type in a customer ID to list all their orders");
								listOrder(userInput.next() + " " + userInput.next());
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
	
	public static void addOrder(String o){
		String[] temp = o.split(",");
		if(temp.length == 7){
			orders[orderCount] = new SupplyOrderSystem(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), temp[6]);
			orderCount += 1;
		}else{
			orders[orderCount] = new SupplyOrderSystem(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4]));
			orderCount += 1;
		}
	}
	
	public static void addOrderUser(String o){
		SupplyOrderSystem[] temp1 = new SupplyOrderSystem[orders.length + 1];
		System.arraycopy(orders, 0, temp1, 0, orders.length);
		orders = temp1;
		String[] temp = o.split(",");
		if(temp.length == 7){
			orders[orderCount] = new SupplyOrderSystem(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), temp[6]);
			System.out.println("Added order:");
			System.out.println(orders[orderCount]);
		}else{
			orders[orderCount] = new SupplyOrderSystem(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4]));
			System.out.println("Added order:");
			System.out.println(orders[orderCount]);
		}
		orderCount += 1;
	}
	
	public static void deleteOrder(int id){
		SupplyOrderSystem[] temp;
		int index = -1;
		for(int i = 0; i < orders.length; i++){
			if(orders[i].getId() == id){
				index = i;
				break;
			}
		}
		if(index == -1){
			System.out.println("Cannot find that order ID");
		}else{
			SupplyOrderSystem temp1 = orders[index];
			temp = new SupplyOrderSystem[orders.length - 1];
			System.arraycopy(orders, 0, temp, 0, index);//copies the objects until the found order
			System.arraycopy(orders, index + 1, temp, index, orders.length - index - 1);//copies the objects after the found order
			orders = temp.clone();
			orderCount -= 1;
			System.out.println("Deleted Order:" + "\n" + temp1);
		}
	}
	
	public static void listOrder(String id){
		SupplyOrderSystem[] temp;
		int count = 0;
		for(int i = 0; i < orders.length; i++){//counts how many matches the id
			if(orders[i].getCustomerId().equals(id)){
				count += 1;
			}
		}
		temp = new SupplyOrderSystem[count];
		count = 0;
		for(int i = 0; i < orders.length; i++){//puts all the matching ids into one array
			if(orders[i].getCustomerId().equals(id)){
				temp[count] = orders[i];
				count += 1;
			}
		}
		temp = sortDate(temp);
		for(int i = 0; i < temp.length; i++){
			System.out.println(temp[i]);
		}
	}
	
	public static SupplyOrderSystem[] sortDate(SupplyOrderSystem[] array1){//sorts the dates
		int number = array1.length;
		SupplyOrderSystem[] array = array1.clone();
		for(int i = 0; i < number; i++){
			int length = array.length - i;
			int index = 0;
			
			for(int j = 1; j < length; j++){
				
				if(array[j].getNumberDate() > array[index].getNumberDate()){//increasing order
					index = j;
				}
			}
			SupplyOrderSystem temp = array[index];
			array[index] = array[length - 1];
			array[length - 1] = temp;
		}
		return array;
	}
}