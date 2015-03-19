
/**
 * This class holds all the data required to store the values for the JSON object retrieved from RentalCars.com.
 * We have four lists of enums, (Which are Java's implementation of Singleton design patterns) which each store a
 * value for the table of sipp codes, based on each of the four SIPP codes provided by the JSON web API retrieved
 * from RentalCars.com.
 * 
 * There are also some very basic calculations which have been carried out in order to display the scores and sum
 * of score for each Vehicle.
 * 
 * 
 * @author Saqib Kayani
 *
 */
public class Vehicle {

	private String vehicleName;
	private String sIPP;
	private double price;
	private String supplier;
	private double rating;
	private String carType, carTypeDoors, transmission, fuel;
	private boolean airCon;
	private double score;
	private double sumOfScores;
	
	/** First letter of the sipp code. */
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
	/** Second letter of the sipp code. */
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
		List2(){
			name=null;
		}
		@Override
		public String toString(){
		   return name;
		}
		public static boolean contains(String s)
		{
			for(List2 choice:values())
				if (choice.name().equals(s)) 
					return true;
			return false;
		} 
	}
	/** Third letter of the sipp code. */
	private enum List3{
		M ("Manual"),
		A ("Automatic");
		private final String name;   
		private List3(String s) {
	        name = s;
	    }
		List3(){
			name=null;
		}
		@Override
		public String toString(){
		   return name;
		}
		public static boolean contains(String s)
		{
			for(List3 choice:values())
				if (choice.name().equals(s)) 
					return true;
			return false;
		} 
	}
	/** Fourth letter of the sipp code. */
	private enum List4{
		N ("Petrol/no AC"),
		R ("Petrol/AC");
		private final String name;  
		private List4(String s) {
	        name = s;
	    }
		List4(){
			name=null;
		}
		@Override
		public String toString(){
		   return name;
		}
		public static boolean contains(String s)
		{
			for(List4 choice:values())
				if (choice.name().equals(s)) 
					return true;
			return false;
		} 
	}
	
	
	/** Default Constructor*/
	public Vehicle(){
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
		setScore(0);
		setSumOfScores(0);
		
	}
	
	/** 
	 * Constructor for setting each of the values excluding the values of the specifications retrieved
	 * by the sipp code. 
	 */
	public Vehicle(String vehicleName, String sIPP, double price, String supplier
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
		setScore(0);
		setSumOfScores(0);
	}
	
	/**
	 * Calculates the specifications of each vehicle based on the the sipp code provided.
	 */
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
			if(spec5.contains("no AC")){
				setAirCon(false);	
			}
			else{
				setAirCon(true);				
			}

		}
		
	} 
	
	/**
	 * Calculates the score for each vehicle object and the sum of scores for the
	 * Vehicle score and the Supplier's score.
	 */
	public void calculateScore(){
		//if manual transmission 1 point
		//if auto transmission 2 points
		//if air conditioned 2 points
		sumOfScores += rating;
		if (getTransmission().toLowerCase().contains("automatic")){
			score += 5;
			sumOfScores += 5;
		}
		else{
			score += 1;
			sumOfScores += 1;
		}
		if (isAirCon()==true){
			score += 2;
			sumOfScores += 2;
		}
	}

	/**
	 * @return name of vehicle.
	 */
	public String getVehicleName() {
		return vehicleName;
	}
	
	/**
	 * @return sipp code.
	 */
	public String getsIPP() {
		return sIPP;
	}

	/**
	 * @return price of vehicle.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @return name of supplier.
	 */
	public String getSupplier() {
		return supplier;
	}

	/**
	 * @return the rating for the vehicle.
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @return boolean value for whether the vehicle has AC or not.
	 */
	public boolean isAirCon() {
		return airCon;
	}

	/**
	 * @return the car type for the vehicle.
	 */
	public String getCarType() {
		return carType;
	}

	/**
	 * @return car type and number of doors.
	 */
	public String getCarTypeDoors() {
		return carTypeDoors;
	}

	/**
	 * @return the fuel type.
	 */
	public String getFuel() {
		return fuel;
	}

	/**
	 * @return return vehicle transmission type.
	 */
	public String getTransmission() {
		return transmission;
	}

	/**
	 * @return the calculated score for the vehicle.
	 */
	public double getScore() {
		return score;
	}

	/**
	 * @return the calculated sum of scores combining the spec score and the supplier's score.
	 */
	public double getSumOfScores() {
		return sumOfScores;
	}

	/** 
	 * Private method for setting the Vehicle Name. 
	 */
	private void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	/** 
	 * Private method for setting the Sipp Code. 
	 */
	private void setsIPP(String sIPP) {
		this.sIPP = sIPP;
	}
	
	/** 
	 * Private method for setting the Vehicle's Price. 
	 */
	private void setPrice(double price) {
		this.price = price;
	}
	
	/** 
	 * Private method for setting the Vehicle's Supplier. 
	 */
	private void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	/** 
	 * Private method for setting the Supplier's Rating for the Vehicle. 
	 */
	private void setRating(double rating) {
		this.rating = rating;
	}
	
	/** 
	 * Private method for setting the Vehicle's AC value as boolean. 
	 */
	private void setAirCon(boolean airCon) {
		this.airCon = airCon;
	}
	
	/** 
	 * Private method for setting the Vehicle's Car Type. 
	 */
	private void setCarType(String carType) {
		this.carType = carType;
	}
	
	/** 
	 * Private method for setting the Vehicle's Car Type/Doors. 
	 */
	private void setCarTypeDoors(String carTypeDoors) {
		this.carTypeDoors = carTypeDoors;
	}
	
	/** 
	 * Private method for setting the Vehicle's Fuel Type. 
	 */
	private void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	/** 
	 * Private method for setting the Vehicle's Transmission Type. 
	 */
	private void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	/** 
	 * Private method for setting the Vehicle's calculated Score. 
	 */
	public void setScore(double score) {
		this.score = score;
	}
	
	/** 
	 * Private method for setting the Vehicle's Sum of calculated Score and Supplier's score. 
	 */
	public void setSumOfScores(double sumOfScores) {
		this.sumOfScores = sumOfScores;
	}
}
