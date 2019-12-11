package classes;
import classes.*;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Map.*;
public class PowerSystem{
	private static ArrayList<Appliances> appliances = new ArrayList<Appliances>();
	private static int time; //current time - for the time interval reports
	private static HashMap<Integer, ArrayList<String>> reportAppliances = new HashMap<Integer, ArrayList<String>>();
	//hashmap for storing the appliances affected for each time interval
	//also for the locations affected for each time interval
	private static HashMap<Integer, ArrayList<Integer>> reportLocations = new HashMap<Integer, ArrayList<Integer>>();
	private static int[] events;
	public static void main(String[] args)throws IOException{
		System.out.println("About how many appliances do you want?");
		Scanner userIn = new Scanner(System.in);
		String[] userApp = new String[1];
		userApp[0] = userIn.next();
		ApplianceGenerator appMake = new ApplianceGenerator();
		appMake.main(userApp);//uses the appliancegenerator class
		inputFile("output.txt");//inputs all the appliances in the file
		askUser();//asks user to find, add, delete, or start simulation
	}
	public static void inputFile(String textFile){
		try{
			File file = new File(textFile);
			Scanner fileInput = new Scanner(file);
			String app;
			while(fileInput.hasNext()){
				app = fileInput.nextLine();
				String[] parts = app.split(",");
				int location = Integer.parseInt(parts[0]);
				String type = parts[1];
				int onWattage = Integer.parseInt(parts[2]);
				float probOn = Float.parseFloat(parts[3]);
				boolean smart = Boolean.parseBoolean(parts[4]);
				float reduction = Float.parseFloat(parts[5]);
				if(smart){
					appliances.add(new Smart(location, type, onWattage, probOn, reduction));
				}else{
					appliances.add(new Regular(location, type, onWattage, probOn));
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void askUser(){
		Scanner in = new Scanner(System.in);
		boolean start = true;
			while(start){
			System.out.println("Type in F to find an appliance by their id");
			System.out.println("Type in A to find add an appliance");
			System.out.println("Type in D to delete an appliance by their id");
			System.out.println("Type in I to input appliances by a text file");
			System.out.println("Type in V1 to view all appliances in a location");
			System.out.println("Type in V2 to view all appliances of same type");
			System.out.println("Type in S to view the summary report");
			System.out.println("Type in Sim to start the simulation");
			System.out.println("Type in X to end");
			String input = in.next();
			switch(input){
				case "F":
					System.out.println("Type in the appliance id you want to find");
					int i = in.nextInt();
					if(find(i).equals("")){
						System.out.println("Could not find the appliance with that id");
					}else{
						System.out.println(find(i));
					}
					break;
				case "A":
					System.out.println("Type in - location,type,on wattage,probability on,smart(true/false),power reduction if smart");
					String temp = in.next() + in.nextLine();
					if(add(temp)){
						System.out.println("Appliance added");
					}else{
						System.out.println("The appliance could not be added. Make sure your arguments are right");
					}
					break;
				case "D":
					System.out.println("Type in the appliance id you want to delete");
					int i2 = in.nextInt();
					if(delete(i2)){
						System.out.println("The appliance has been deleted");
					}else{
						System.out.println("The appliance with that id could not be found");
					}
					break;
				case "I":
					System.out.println("Type in the text file you want to input in the form of file.txt");
					String temp2 = in.next();
					System.out.println("If there is something wrong with the file, it will output the errors.");
					inputFile(temp2);
					break;
				case "V1":
					System.out.println("Type in the location you want to view");
					int locat = in.nextInt();
					if(view(locat).equals("")){
						System.out.println("Invalid location");
					}else{
						System.out.println(view(locat));
					}
					break;
				case "V2":
					System.out.println("Type in the name of the appliance you want to view");
					String ty = in.next() + in.nextLine();
					if(view(ty).equals("")){
						System.out.println("Could not find the appliance you indicated");
					}else{
						System.out.println(view(ty));
					}
					break;
				case "S": 
					summary();
					break;
				case "Sim":
					System.out.println("Total wattage now is: " + totalWattage());
					simulation(); break;
				case "X":
					start = false;
					break;
				default:
					System.out.println("Wrong input. Try again"); break;
			}
		}
	}
	public static String find(int id){
		String out ="";
		for(Appliances apps: appliances){
			if(apps.getId() == id){
				out = apps.toString();
				break;
			}
		}
		return out;
	}
	public static boolean delete(int id){
		boolean out = false;
		int count = 0;
		for(Appliances apps: appliances){
			if(apps.getId() == id){
				System.out.println(apps);
				appliances.remove(count);
				out = true;
				break;
			}
			count += 1;
		}
		return out;
	}
	public static boolean add(String temp){
		boolean out = true;
		try{
			String[] parts = temp.split(",");
			int location = Integer.parseInt(parts[0]);
			String type = parts[1];
			int onWattage = Integer.parseInt(parts[2]);
			float probOn = Float.parseFloat(parts[3]);
			boolean smart = Boolean.parseBoolean(parts[4]);
			float reduction = Float.parseFloat(parts[5]);
			if(smart){
				appliances.add(new Smart(location, type, onWattage, probOn, reduction));
			}else{
				appliances.add(new Regular(location, type, onWattage, probOn));
			}
			System.out.println(appliances.get(appliances.size() - 1));
		}catch(Exception ex){
			out = false;
		}
		return out;
	}
	public static String view(int loc){
		String out = "";
		for(Appliances apps: appliances){
			if(apps.getLocation() == loc){
				out = out + apps.toString() + "\n";
			}
		}
		return out;
	}
	public static String view(String type){
		String out = "";
		for(Appliances apps: appliances){
			if(apps.getType().equals(type)){
				out = out + apps.toString() + "\n";
			}
		}
		return out;
	}
	public static void summary(){
		Set<Integer> totalLocations = new HashSet<>();//makes hashset so i can count how many unique location/type are there
		Set<String> totalTypes = new HashSet<>();
		ArrayList<String> types = new ArrayList<String>();//makes arraylist string of types
		for(Appliances apps: appliances){
			totalLocations.add(apps.getLocation());
			totalTypes.add(apps.getType());
			types.add(apps.getType());
		}
		String[] tempType = new String[totalTypes.size()];//import all unique types in an array
		int count = 0;
		for(String typ: totalTypes){
			tempType[count] = typ;
			count += 1;
		}
		int[] totalTyp = new int[tempType.length];//makes int array to list all the total number of type of appliances
		for(int i = 0; i < totalTyp.length; i++){//initially sets them to 0
			totalTyp[i] = 0;
		}
		for(Appliances apps: appliances){
			for(int i = 0; i < tempType.length; i++){
				if(apps.getType().equals(tempType[i])){
					totalTyp[i] += 1;
				}
			}
		}
		System.out.println("Displaying Summary Report:");
		System.out.println("Total number of locations: " + totalLocations.size());
		for(int i = 0; i < tempType.length; i++){
			System.out.println(tempType[i] + ", Total Amount: " + totalTyp[i]);
		}
	}
	public static void simulation(){
		Scanner in = new Scanner(System.in);
		System.out.println("Type in the wattage warning level for the grid");
		int wat = in.nextInt();
		//default
		if(wat < 0){
			System.out.println("Invalid wattage, Setting to 0");
			wat = 0;
		}
		int timeInterval = 5;//default time checks is 5
		System.out.println("Type Y if you want to change the default simulation of doing 5 time intervals");
		if(in.next().equals("Y")){
			System.out.println("Type in the simulation timing interval");
			timeInterval = in.nextInt();
		}
		time(timeInterval);//sets the amount of intervals to check
		for(int i = 0; i < events.length; i++){//for each interval set the time and use the power control 
			for(Appliances apps: appliances){
				apps.rngState();//each time interval, the appliances are on/off based on probability
			}
			time = events[i];
			powerControl(wat);
		}
		report();
		//reset all the appliances, just in case the user wants to start another simulation
		for(Appliances apps: appliances){
			apps.rngState();
		}
		reportAppliances.clear();
		reportLocations.clear();
		//also reset the static hashmaps
	}
	public static void report(){//summary report and detailed report of the simulation
		//print out locations affected - the locations of the appliances turned to low
		Set<String> totalLocations;//makes hashset so i can count how many unique locations were affected
		HashMap<Integer, Integer> reportNumLocations = new HashMap<Integer, Integer>();//hash map for interval, num locations affected
		//go through reportAppliances hashmap and count unique locations in each interval and input into here
		for(Entry<Integer, ArrayList<String>> out: reportAppliances.entrySet()){//iterates through the appliances affected counting unique locations affected for each interval
			int key = out.getKey();//gets the time interval
			totalLocations = new HashSet<>();
			ArrayList<String> appl = out.getValue();//gets the list of appliances 
			for(String apps: appl){
				String[] parts = apps.split(",");
				String locationes = parts[1];
				totalLocations.add(locationes);//gets the unique locations affected
			}
			ArrayList<Integer> checkLoc = reportLocations.get(key);//gets the browned out locations during the interval, if there were any
			if(checkLoc == null){
			}else{
				for(int gh: checkLoc){
					totalLocations.add(Integer.toString(gh));//adds to hashset because the browned out locations count as the locations affected during the interval too
				}
			}
			reportNumLocations.put(key, totalLocations.size());//hashmap of (time, # locations affected)
		}
		for(Entry<Integer, Integer> out: reportNumLocations.entrySet()){
			int key = out.getKey();
			int totalss = out.getValue();
			System.out.println("Time Interval " + key + ". Total # Locations affected: " + totalss);
		}
		//print to a file a more detailed with all the appliances/locations affected during each time interval
		outputFile();
	}
	
	public static void outputFile(){//more detailed report to a file
		try{
		FileWriter fw = new FileWriter("report.txt", false);
		BufferedWriter bw = new BufferedWriter(fw);
		for(Entry<Integer, ArrayList<String>> out: reportAppliances.entrySet()){
			Integer key = out.getKey();
			ArrayList<String> appl = out.getValue();
			bw.write("Time Interval " + key + ". Smart Appliances turned to Low: ");
			bw.newLine();
			for(String apps: appl){
				bw.write(apps);
				bw.newLine();
				bw.flush();
			}
		}
		for(Entry<Integer, ArrayList<Integer>> out: reportLocations.entrySet()){
			int key = out.getKey();
			ArrayList<Integer> locasti = out.getValue();
			bw.write("Time Interval " + key + ". Locations Browned out: ");
			bw.newLine();
			for(int locast: locasti){
				bw.write(locast + ", ");
			}
			bw.newLine();
			bw.flush();
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void powerControl(int wat){
		while(totalWattage() > wat){
			if(checkSmart()){
				powerControlSmart();//makes an appliance to low(the highest wattage first)
				//System.out.println(totalWattage());
			}else{
				brownOut();//browns out a location (least number of appliances first)
				//System.out.println(totalWattage());
			}
		}
	}
	
	public static double totalWattage(){
		double total = 0;
		for(Appliances apps: appliances){
			total += apps.wattage;
		}
		return total;
	}
	public static boolean checkSmart(){//false if no more "on" smart apps, its all low
		ArrayList<Appliances> on = new ArrayList<Appliances>();//only appliances that are on
		for(Appliances apps: appliances){
			if(apps.state == 2){
				on.add(apps);
			}
		}
		ArrayList<Appliances> smart = new ArrayList<Appliances>();//smart appliances that are on
		for(Appliances apps: on){
			if(apps.smart == 0){
			}else{
				smart.add(apps);
			}
		}
		boolean out = true;
		if(smart.size() == 0){
			out = false;
		}
		return out;
	}
	
	public static void powerControlSmart(){
		ArrayList<Appliances> on = new ArrayList<Appliances>();//only appliances that are "on" not low
		for(Appliances apps: appliances){
			if(apps.state == 2){
				on.add(apps);
			}
		}
		ArrayList<Appliances> smart = new ArrayList<Appliances>();
		for(Appliances apps: on){
			if(apps.smart == 0){
			}else{
				smart.add(apps);
			}
		}
		Collections.sort(smart, new Comparator<Appliances>(){//sorts the smart appliances by wattage, highest to lowest
			@Override
			public int compare(Appliances b, Appliances a){
				return Double.compare(a.wattage, b.wattage);
			}
		});
		
		int lowId = smart.get(0).getId();//get id of the highest wattage smart
		int key = time;
		if(reportAppliances.get(key) == null){//a hashmap for the specific time interval for appliances
			reportAppliances.put(key, new ArrayList<String>());
		}
		for(Appliances apps: appliances){
			if(apps.getId() == lowId){//sets that appliance to low
				apps.state = 1;
				apps.checkWattage();//applies the correct wattage
				reportAppliances.get(key).add(apps.getId() + "," + apps.getLocation() + "," + apps.getType());//storing the appliances turn to low for the time interval
			}
		}
	}
	
	public static void brownOut(){//browns out the locations starting with the locations with smallest number of appliances that are on
		Set<Integer> totalLocations = new HashSet<>();//makes hashset so i can count how many unique location are there
		ArrayList<Appliances> on = new ArrayList<Appliances>();//only appliances that are on
		for(Appliances apps: appliances){
			if(apps.state == 2){
				on.add(apps);
			}else if(apps.state == 1){
				on.add(apps);
			}
		}
		for(Appliances apps: on){
			totalLocations.add(apps.getLocation());
		}
		Integer[] tempLocation = new Integer[totalLocations.size()];//import all unique locations in an array
		int count = 0;
		for(Integer loc: totalLocations){
			tempLocation[count] = loc;
			count += 1;
		}
		int[] totalLoc = new int[tempLocation.length];//makes int array to list all the total number of appliances in a location
		for(int i = 0; i < totalLoc.length; i++){//initially sets them to 0
			totalLoc[i] = 0;
		}
		for(Appliances apps: on){
			for(int i = 0; i < tempLocation.length; i++){//counts the number of appliances in one location
				if(apps.getLocation() == tempLocation[i]){
					totalLoc[i] += 1;
				}
			}
		}
		int smallest = 0;
		for(int i = 0; i < totalLoc.length; i++){//smallest that is not 0
			if(totalLoc[i] == 0){
			}
			else if(totalLoc[i] < totalLoc[smallest]){
				smallest = i;
			}
		}
		int key = time;
		if(reportLocations.get(key) == null){//a hashmap for the specific time interval for locations
			reportLocations.put(key, new ArrayList<Integer>());
		}
		for(Appliances apps: appliances){
			if(apps.getLocation() == tempLocation[smallest]){//sets the appliances in those location to off
				apps.state = 0;
				apps.checkWattage();//applies the correct wattage
			}
		}
		reportLocations.get(key).add(tempLocation[smallest]);//storing the locations browned out for the time interval
	}
	
	public static void time(int t){
		events = new int[t];
		for(int i = 0; i < events.length; i++){
			events[i] = i + 1;
		}
	}
}