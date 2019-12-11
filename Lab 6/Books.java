public class Books extends Record{
	private String eBook;
	private int hard;
	
	public Books(){
		super();
		eBook = "none";
		hard = 0;
	}
	public Books(String e, String t, String a, String d){//for ebooks
		super(t,a,d);
		eBook = e;
		hard = 0;
	}
	public Books(int h, String t, String a, String d){//for hardcopy
		super(t,a,d);
		hard = h;
		eBook = "none";
	}
	
	public void setEbook(String e){
		eBook = e;
	}
	public void setHard(int h){
		hard = h;
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
	
	public String getEbook(){
		return eBook;
	}
	public int getHard(){
		return hard;
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
		if(hard == 0){
			out = out + "Ebook: " + eBook + "\n";
		}else if(eBook.equals("none")){
			out = out + "Edition: " + hard + "\n";
		}else{
		}
		return out;
	}
	
}