public class Magazines extends Record{
	private int issue;
	private int volume;
	private String electronic;
	private String hardcopy;
	
	public Magazines(){
		super();
		issue = 0;
		volume = 0;
		electronic = "none";
		hardcopy = "none";
	}
	public Magazines(int check, int i, int v, String type, String t, String a, String d){
		super(t,a,d);
		issue = i;
		volume = v;
		if(check == 0){
			electronic = type;
			hardcopy = "none";
		}else if(check == 1){
			hardcopy = type;
			electronic = "none";
		}else{
		}
	}
	
	public void setIssue(int i){
		issue = i;
	}
	public void setVolume(int v){
		volume = v;
	}
	public void setElectronic(String e){
		electronic = e;
	}
	public void setHardcopy(String h){
		hardcopy = h;
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
	
	public int getIssue(){
		return issue;
	}
	public int getVolume(){
		return volume;
	}
	public String getElectronic(){
		return electronic;
	}
	public String getHardcopy(){
		return hardcopy;
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
		out = out + "Issue: " + issue + "\n" + "Volume: " + volume + "\n";
		if(electronic.equals("none")){
			out = out + "Hardcopy: " + hardcopy + "\n";
		}else if(hardcopy.equals("none")){
			out = out + "Electronic: " + electronic + "\n";
		}else{
		}
		return out;
	}
}