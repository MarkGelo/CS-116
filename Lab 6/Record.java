public class Record{
	private String title;
	private String authors;
	private String date;
	private static int count = 0;
	private int id;
	
	public Record(){
		title = "no title";
		authors = "no authors";
		date = "no date";
		count += 1;
		id = count;
	}
	
	public Record(String t, String a, String d){
		count += 1;
		id = count;
		title = t;
		authors = a;
		date = d;
	}
	
	public void setTitle(String t){
		title = t;
	}
	public void setAuthors(String a){
		authors = a;
	}
	public void setDate(String d){
		date = d;
	}
	public String getTitle(){
		return title;
	}
	public String getAuthors(){
		return authors;
	}
	public String getDate(){
		return date;
	}
	public int getID(){
		return id;
	}
	
	public String toString(){
		String out = "ID: " + id + "\n" + "Title: " + title + "\n" + "Authors: " + authors + "\n" + "Date: " + date + "\n";
		return out;
	}
}