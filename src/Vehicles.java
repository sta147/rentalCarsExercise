
public class Vehicles /*implements Comparable<Vehicles>*/ {

	private String vehicleName;
	private String sIPP;
	private double price;
	private String supplier;
	private double rating;
	private String carType, carTypeDoors, transmission, fuel;
	private boolean airCon;
	
	private enum List1{
		M ("Mini"),
		E ("Economy"),
		C ("Compact"),
		I ("Intermediate"),
		S ("Standard"),
		F ("Full size"),
		P ("Premium"),
		L ("Luxury"),
		X ("Special");
		private final String name;
		private List1(String s) {
	        name = s;
	    }
		List1(){
			name=null;
		}
		@Override
		public String toString(){
		   return name;
		}
		public static boolean contains(String s)
		{
			for(List1 choice:values())
				if (choice.name().equals(s)) 
					return true;
			return false;
		} 
	}
	private enum List2{
		B ("2 doors"),
		C ("4 doors"),
		D ("5 doors"),
		W ("Estate"),
		T ("Convertible"),
		F ("SUV"),
		P ("Pick up"),
		V ("Passenger Van");
		private final String name;  
		private List2(String s) {
	        name = s;
	    }
		public static boolean contains(String s)
		{
			for(List2 choice:values())
				if (choice.name().equals(s)) 
					return true;
			return false;
		} 
	}
	private enum List3{
		M ("MAnual"),
		A ("Automatic");
		private final String name;   
		private List3(String s) {
	        name = s;
	    }
		public static boolean contains(String s)
		{
			for(List3 choice:values())
				if (choice.name().equals(s)) 
					return true;
			return false;
		} 
	}
	private enum List4{
		N ("Petrol/no AC"),
		R ("Petrol/AC");
		private final String name;  
		private List4(String s) {
	        name = s;
	    }
		public static boolean contains(String s)
		{
			for(List4 choice:values())
				if (choice.name().equals(s)) 
					return true;
			return false;
		} 
	}
	
	
	/* Default Constructor*/
	
	public Vehicles(){
		super();
		vehicleName = "";
		sIPP = "";
		price = 0.0;
		supplier = "";
		rating = 0.0;
		carType = "";
		carTypeDoors = "";
		transmission = "";
		fuel = "";
		airCon = false;
		
	}
	
	public Vehicles(String vehicleName, String sIPP, double price, String supplier
			,double rating){
		super();
		setVehicleName(vehicleName);
		setsIPP(sIPP);
		setPrice(price);
		setSupplier(supplier);
		setRating(rating);
		carType = "";
		carTypeDoors = "";
		transmission = "";
		fuel = "";
		airCon = false;
	}
	
	public void getSpecs(){
		String char1 = String.valueOf(sIPP.charAt(0));
		String char2 = String.valueOf(sIPP.charAt(1));
		String char3 = String.valueOf(sIPP.charAt(2));
		String char4 = String.valueOf(sIPP.charAt(3));
		//if (char1.equals(l1.valueOf(l1))){
		//	l1.values().
		//}
		if(List1.contains(char1)){
			setCarType(List1.valueOf(char1).toString());
		}
		if(List2.contains(char2)){
			setCarTypeDoors(List2.valueOf(char2).toString());
		}
		if(List3.contains(char3)){
			setTransmission(List3.valueOf(char3).toString());
		}
		if(List4.contains(char4)){
			String[] spec4And5 = List4.valueOf(char4).toString().split("/");
			String spec4 = spec4And5[0]; 
			String spec5 = spec4And5[1];
			setFuel(spec4);
			if(spec5.equalsIgnoreCase("no"))
				setAirCon(false);
			else
				setAirCon(true);
		}
		
	}

	public String getVehicleName() {
		return vehicleName;
	}

	private void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}


	public String getsIPP() {
		return sIPP;
	}


	private void setsIPP(String sIPP) {
		this.sIPP = sIPP;
	}


	public double getPrice() {
		return price;
	}


	private void setPrice(double price) {
		this.price = price;
	}


	public String getSupplier() {
		return supplier;
	}


	private void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	public double getRating() {
		return rating;
	}


	private void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isAirCon() {
		return airCon;
	}

	private void setAirCon(boolean airCon) {
		this.airCon = airCon;
	}

	public String getCarType() {
		return carType;
	}

	private void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarTypeDoors() {
		return carTypeDoors;
	}

	private void setCarTypeDoors(String carTypeDoors) {
		this.carTypeDoors = carTypeDoors;
	}

	public String getFuel() {
		return fuel;
	}

	private void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getTransmission() {
		return transmission;
	}

	private void setTransmission(String transmission) {
		this.transmission = transmission;
	}
}
