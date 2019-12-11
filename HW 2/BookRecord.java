package library.service.classes;
import library.service.classes.BookGenre;
public class BookRecord{
	private int id;//instance variables
	private static int count = 0;
	private String title;
	private String[] authors;
	private BookGenre genre;
	
	public BookRecord(){//default
		count += 1;
		id = count;
		title = null;
		authors = new String[1];
		authors[0] = null;
		genre = null;
	}
	public BookRecord(String t, String[] a,String g){// non default
		count += 1;
		id = count;
		title = t;
		authors = new String[a.length];
		for(int i = 0; i < authors.length; i++){
			authors[i] = a[i];
		}
		if(g.equals("GENRE_HISTORY")){
			genre = BookGenre.GENRE_HISTORY;
		}
		else if(g.equals("GENRE_SCIENCE")){
			genre = BookGenre.GENRE_SCIENCE;
		}
		else if(g.equals("GENRE_ENGINEERING")){
			genre = BookGenre.GENRE_ENGINEERING;
		}
		else if(g.equals("GENRE_LITERATURE")){
			genre = BookGenre.GENRE_LITERATURE;
		}
		else{
		}
	}
	public int getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
	public String[] getAuthors(){
		return authors;
	}
	public BookGenre getGenre(){
		return genre;
	}
	public void setTitle(String t){
		title = t;
	}
	public void setGenre(BookGenre g){
		genre = g;
	}
	public void setAuthors(String[] a){
		authors = a.clone();
	}
	public boolean equals(BookRecord a){//checks if the books are equal
		boolean out;
		int temp = 0;
		if(a.getAuthors().length == this.getAuthors().length && a.getTitle().equals(this.getTitle()) && a.getGenre() == this.getGenre()){
			for(int i = 0; i < a.getAuthors().length; i++){
				if(a.getAuthors()[i].equals(this.getAuthors()[i])){
					temp += 0;
				}
				else{
					temp += 1;
				}
			}
		}
		else{
			temp += 1;
		}
		if(temp == 0){
			out = true;
		}
		else{
			out = false;
		}
		return out;
	}
	public String toString(){
		String out = "";
		out = out + "Record Number: " + id + "\n";
		out = out + "Title: " + title + "\n";
		out = out + "Authors: ";
		for(int i = 0; i < authors.length; i++){
			out = out + authors[i] + ", ";
		}
		out = out + "\n";
		out = out + "Genre: " + genre.name() + "\n";
		return out;
	}
}