public class Spinner{
	private int arrow;
	private int numbers;
	private final int ARR = 1;
	private final int SECTION = 9;
	
	public Spinner(){//default constructor
		arrow = ARR;
		numbers = SECTION;
	}
	public Spinner(int val, int num){//non default
		if(val >= 0 && val <= SECTION){
			arrow = val;
		}
		else{
			arrow = ARR;
		}
		if(num >= 1){
			numbers = num;
		}
		else{
			numbers = SECTION;
		}
	}
	
	public void setArrow(int val){
		arrow = val;
	}
	public int getArrow(){
		return arrow;
	}
	
	public void spin(){
		int max = numbers - 1;
		int min = 0;
		int range = max - min + 1;
		int rand = (int)((Math.random() * range) + 1);
		arrow = rand;
	}
	
	public String toString(){
		String out = "The arrow is at " + arrow;
		return out;
	}
	
	public boolean equal(Spinner a){
		if(a.getArrow() == this.getArrow()){
			return true;
		}
		else{
			return false;
		}
	}
	
}