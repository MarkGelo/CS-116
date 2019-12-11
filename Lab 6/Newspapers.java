public class Newspapers extends Record{
	private String edition;
	
	public Newspapers(){
		super();
		edition = "none";
	}
	public Newspapers(String e, String t, String a, String d){
		super(t,a,d);
		edition = e;
	}
	
	public void setEdition(String e){
		edition = e;
	}
	public void setTitle(String t){
		super.setTitle(t);
	}
	public void setAuthors(String a){
		super.setAuthors(a);
	}
	public void setDate(String d){
		super.setDate(d);
	}
	
	public String getEdition(){
		return edition;
	}
	public String getTitle(){
		return super.getTitle();
	}
	public String getAuthors(){
		return super.getAuthors();
	}
	public String getDate(){
		return super.getDate();
	}
	public int getID(){
		return super.getID();
	}
	
	public String toString(){
		String out = super.toString();
		out = out + "Edition: " + edition + "\n";
		return out;
	}
}