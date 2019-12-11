public class RecordClient{
	public static void main(String[] args){
		Books book = new Books(1, "Awesome Book", "Mark Gameng", "3-29-19");
		Magazines magazine = new Magazines(0, 2, 5, "markgameng.com", "Awesome Magazine", "Mark Gameng", "3-29-19");
		Newspapers newspaper = new Newspapers("Mark Gameng Edition", "Awesome Newspaper", "Mark Gameng", "3-29-19");
		System.out.println(book);
		System.out.println(magazine);
		System.out.println(newspaper);
	}
}