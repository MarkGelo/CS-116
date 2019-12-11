public class SupplyOrderSystem extends Order{
	private String orderType;
	private int numDaysRepeat;
	private String endDate;
	
	public SupplyOrderSystem(){//default
		super();
		orderType = "none";
		numDaysRepeat = 0;
		endDate = "none";
	}
	public SupplyOrderSystem(String type, String cust, String prod, String dat, int amt){//order type one time
		super(cust, prod, dat, amt);
		orderType = type;
	}
	public SupplyOrderSystem(String type, String cust, String prod, String dat, int amt, int numDays, String end){//order type repeated
		super(cust, prod, dat, amt);
		orderType = type;
		numDaysRepeat = numDays;
		endDate = end;
	}
	//setters
	public void setOrderType(String order){
		orderType = order;
	}
	public void setCustomerId(String cust){
		super.setCustomerId(cust);
	}
	public void setProductId(String prod){
		super.setProductId(prod);
	}
	public void setDate(String dat){
		super.setDate(dat);
	}
	public void setOrderAmount(int amt){
		super.setOrderAmount(amt);
	}
	public void setNumDaysRepeat(int numDays){
		numDaysRepeat = numDays;
	}
	public void setEndDate(String end){
		endDate = end;
	}
	//getters
	public String getOrderType(){
		return orderType;
	}
	public String getCustomerId(){
		return super.getCustomerId();
	}
	public String getProductId(){
		return super.getProductId();
	}
	public String getDate(){
		return super.getDate();
	}
	public int getOrderAmount(){
		return super.getOrderAmount();
	}
	public int getNumDaysRepeat(){
		return numDaysRepeat;
	}
	public String getEndDate(){
		return endDate;
	}
	public int getId(){
		return super.getId();
	}
	public int getNumberDate(){
		return super.getNumberDate();
	}
	
	public String toString(){
		String out = super.toString();
		out = out + "Order Type: " + orderType + "\n";
		if(orderType.equals("R")){
			out = out + "Period: " + numDaysRepeat + "\n" + "End Date: " + endDate + "\n";
		}
		return out;
	}
}