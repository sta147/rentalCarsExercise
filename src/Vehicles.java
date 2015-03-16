
public class Vehicles implements Comparable<Vehicles> {

	private String vehicleName;
	private String sIPP;
	private double price;
	private String supplier;
	private double rating;
	
	/* Default Constructor*/
	
	public Vehicles(){
		super();
		vehicleName = "";
		sIPP = "";
		price = 0.0;
		supplier = "";
		rating = 0.0;
	}
	
	public Vehicles(String vehicleName, String sIPP, double price, String supplier
			,double rating){
		super();
		setVehicleName(vehicleName);
		setsIPP(sIPP);
		setPrice(price);
		setSupplier(supplier);
		setRating(rating);
	}


	public String getVehicleName() {
		return vehicleName;
	}


	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}


	public String getsIPP() {
		return sIPP;
	}


	public void setsIPP(String sIPP) {
		this.sIPP = sIPP;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public int compareTo(Vehicles v) {
		
		int comparePrice = (int) ((Vehicles) v).getPrice();
		return (int) (this.price - comparePrice);
	}
}
