import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.JSONValue;


public class Main {

	private static Vehicles[] a;
	private static List<Vehicles> b;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		URL url;
		try {
			url = new URL("http://www.rentalcars.com/js/vehicles.json");
        //String url = "http://www.rentalcars.com/js/vehicles.json";
			
        String genreJson = IOUtils.toString(url);
        JSONObject obj = new JSONObject(genreJson);
        
        JSONArray arr = obj.getJSONObject("Search").getJSONArray("VehicleList");
        b = new ArrayList<Vehicles>();
        
        for (int i = 0; i < arr.length(); i++)
        {
            String sipp = arr.getJSONObject(i).getString("sipp");
            //System.out.println("sipp: "+sipp);
            double price = arr.getJSONObject(i).getDouble("price");
            //System.out.println("price: "+price);
            String supplier = arr.getJSONObject(i).getString("supplier");
            //System.out.println("supplier: "+supplier);
            String name = arr.getJSONObject(i).getString("name");
            //System.out.println("name: "+name);
            double rating = arr.getJSONObject(i).getDouble("rating");
            //System.out.println("rating: "+rating);
            
            /** After we have retrieved data from the JSON vehicle Object, we use the data
             * to create a new Vehicle object and add it to a List. */
            b.add(new Vehicles(name,sipp,price,supplier,rating));
        }
        
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		//Arrays.sort(a, Collections.reverseOrder());
		
		/** Here we sort the array in ascending price order */
		Collections.sort(b, new Comparator<Vehicles>() {
		    @Override
		    public int compare(Vehicles c1, Vehicles c2) {
		        return Double.compare(c1.getPrice(), c2.getPrice());
		    }
		});

		/** This prints all the cars in ascending price order.*/
		for (Vehicles vehicle : b) {
			System.out.print(vehicle.getVehicleName()+", ");
			System.out.println(vehicle.getPrice()+", ");
			//System.out.print(vehicle.getSupplier()+", ");
			//System.out.print(vehicle.getsIPP()+", ");
			//System.out.println(vehicle.getRating()+".");
		}
		
		
	}

}
