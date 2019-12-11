public class Order{
	private int id;
	private static int count = 0;
	private String customerId;
	private String productId;
	private String date;
	private int orderAmount;
	private int changeDate;//used for sorting by date...
	
	public Order(){
		id = count;
		customerId = "none";
		productId = "none";
		date = "0/0/0000";
		orderAmount = 0;
		count += 1;
	}
	public Order(String c, String p, String d, int a){
		id = count;
		customerId = c;
		productId = p;
		date = d;
		orderAmount = a;
		count += 1;
		changeDate = change(d);
	}
	
	public void setCustomerId(String cust){
		customerId = cust;
	}
	public void setProductId(String prod){
		productId = prod;
	}
	public void setDate(String dat){
		date = dat;
	}
	public void setOrderAmount(int amt){
		orderAmount = amt;
	}
	
	public String getCustomerId(){
		return customerId;
	}
	public String getProductId(){
		return productId;
	}
	public String getDate(){
		return date;
	}
	public int getOrderAmount(){
		return orderAmount;
	}
	public int getId(){
		return id;
	}
	public int getNumberDate(){
		return changeDate;
	}
	
	public static int change(String d){
		String[] temp = d.split("/");
		int out = Integer.parseInt(temp[2]) * 10000;
		out += Integer.parseInt(temp[0]) * 100;
		out += Integer.parseInt(temp[1]);
		return out;
	}
	
	public String toString(){
		String out = "ID: " + id + "\n" + "Customer ID: " + customerId + "\n" + "Product ID: " + productId + "\n" + "Date: " + date + "\n" + "Order Amount: " + orderAmount + "\n";
		return out;
	}
}