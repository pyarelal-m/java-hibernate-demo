package mastek;

public class Product {
	private int pid,quantity;
	String pname;
	double price,bill;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(double bill, int pid, String pname, double price,
			int quantity) {
		super();
		this.bill = bill;
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
	}
	
	public double getBill() {
		return bill;
	}
	public int getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getPrice() {
		return price;
	}
	
	public void setBill(double bill) {
		this.bill = bill;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
