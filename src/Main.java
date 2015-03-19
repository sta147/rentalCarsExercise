import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;


public class Main {

	/**
	 * An ArrayList of Vehicle objects.
	 */
	private static List<Vehicles> vehiclesList;
	
	public static void main(String[] args) {
		
		URL url;
		try {
			url = new URL("http://www.rentalcars.com/js/vehicles.json");
			
        String genreJson = IOUtils.toString(url);
        JSONObject obj = new JSONObject(genreJson);
        
        JSONArray arr = obj.getJSONObject("Search").getJSONArray("VehicleList");
        vehiclesList = new ArrayList<Vehicles>();
        
        for (int i = 0; i < arr.length(); i++)
        {
            String sipp = arr.getJSONObject(i).getString("sipp");
            //System.out.println("sipp: "+sipp);
            double price = arr.getJSONObject(i).getDouble("price");
            String supplier = arr.getJSONObject(i).getString("supplier");
            String name = arr.getJSONObject(i).getString("name");
            double rating = arr.getJSONObject(i).getDouble("rating");
            
            /** After we have retrieved data from the JSON vehicle Object, we use the data
             * to create a new Vehicle object and add it to a List. */
            vehiclesList.add(new Vehicles(name,sipp,price,supplier,rating));
        }
        
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}catch (JSONException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		
		
		/** Here we sort the array in ascending price order */
		Collections.sort(vehiclesList, new Comparator<Vehicles>() {
		    @Override
		    public int compare(Vehicles c1, Vehicles c2) {
		        return Double.compare(c1.getPrice(), c2.getPrice());
		    }
		});
		System.out.println("******* list of all the cars, in ascending price order ********\n");
		/** This prints all the cars in ascending price order.*/
		for (Vehicles vehicle : vehiclesList) {
			System.out.print(vehicle.getVehicleName()+" - ");
			System.out.println(vehicle.getPrice());
		}
		/* Converts the sipp into vehicle specifications */
		for (Vehicles vehicle : vehiclesList) {
			// calculates the specs for each vehicle.
			vehicle.getSpecs();
			// calculates the Sum of scores for each vehicle.
			vehicle.calculateScore();
		}
		
		System.out.println("\n**** list of all the cars, with Specifications calculated ****\n");
		/** This prints all the cars in ascending price order.*/
		for (Vehicles vehicle : vehiclesList) {
			System.out.print(vehicle.getVehicleName()+" - ");
			System.out.print(vehicle.getsIPP()+" - ");
			System.out.print(vehicle.getCarType()+" - ");
			System.out.print(vehicle.getCarTypeDoors()+" - ");
			System.out.print(vehicle.getTransmission()+" - ");
			System.out.print(vehicle.getFuel()+" - ");
			if(vehicle.isAirCon() == false){
				System.out.println("no AC");
			}
			else{
				System.out.println("AC");
			}
		}
		
		/** Here we sort the array in descending order of highest rated supplier,
		 * 	per car type. */
		Collections.sort(vehiclesList, new Comparator<Vehicles>() {
		    @Override
		    public int compare(Vehicles c1, Vehicles c2) {
		        return Double.compare(c2.getRating(), c1.getRating());
		    }
		});
		
		System.out.println("\n******* Highest rated cars in descending order. ********\n");
		/** This prints all the cars in ascending price order.*/
		for (Vehicles vehicle : vehiclesList) {
			System.out.print(vehicle.getVehicleName()+" - ");
			System.out.print(vehicle.getCarType()+" - ");
			System.out.print(vehicle.getSupplier()+" - ");
			System.out.println(vehicle.getRating());
		}
		
		/** Here we sort the array in descending order of highest sum of scores. */
		Collections.sort(vehiclesList, new Comparator<Vehicles>() {
		    @Override
		    public int compare(Vehicles c1, Vehicles c2) {
		        return Double.compare(c2.getScore(), c1.getScore());
		    }
		});
		System.out.println("\n******* Cars with  Highest sum of scores in descending order. ********\n");
		/** This prints all the cars in ascending price order.*/
		for (Vehicles vehicle : vehiclesList) {
			System.out.print(vehicle.getVehicleName()+" - ");
			System.out.print(vehicle.getScore()+" - ");
			System.out.print(vehicle.getRating()+" - ");
			System.out.println(vehicle.getSumOfScores());
		}
		
	}

}
