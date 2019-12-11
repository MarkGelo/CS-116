public class DailySales{
	private int[] sale;
	
	public DailySales(){//default
		sale = new int[10];
	}
	public DailySales(int TotalDays){//non default
		sale = new int[TotalDays];
	}
	public boolean addSales(int dayNumber, int sales){
		if(dayNumber > 0 && dayNumber <= sale.length && sales > 0){
			sale[dayNumber - 1] = sales;
			return true;
		}
		else{
			return false;
		}
	}
	public int getSales(int day){
		return sale[day - 1];
	}
	public int maxDay(){
		int maxSale = 0;
		int maxDay = 1;
		for(int i = 0; i < sale.length; i++){
			if(sale[i] >= maxSale){
				maxSale = sale[i];
				maxDay = i;
			}
			else{
			}
		}
		return maxDay + 1;
	}
	public int[] daysBelowGoal(){
		int count = 0;
		for(int i = 0; i < sale.length; i++){
			if(sale[i] < 100){
				count += 1;
			}
			else{
			}
		}
		int[] dayBelow = new int[count];
		int j = 0;
		for(int i = 0; i < sale.length; i++){
			if(sale[i] < 100){
				dayBelow[j] = i + 1;
				j += 1;
			}
			else{
			}
		}
		return dayBelow;
	}
	public String toString(){
		String out = "";
		for(int i = 0; i < sale.length; i++){
			out = out + "Day " + (i + 1) + " : " + sale[i] + "\n";
		}
		return out;
	}
}