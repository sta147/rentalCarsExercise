import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.JSONValue;


public class Main {

	private static Vehicles[] a;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		URL url;
		try {
			url = new URL("http://www.rentalcars.com/js/vehicles.json");

        //String url = "http://www.rentalcars.com/js/vehicles.json";
        String genreJson = IOUtils.toString(url);
        JSONObject obj = new JSONObject(genreJson);
        //String json = obj.getJSONObject("Search").optString("VehicleList");
        // get the title
        JSONArray arr = obj.getJSONObject("Search").getJSONArray("VehicleList");
        a = new Vehicles[arr.length()];
        //System.out.println(arr);
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
            
            a[i] = new Vehicles(name,sipp,price,supplier,rating);
            
        }
        
         /* json.getJSONObject("VehicleList");
        System.out.println(json.get("sipp"));
        System.out.println(JSONValue.parse("sipp"));
        */
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
		
		// print out arrays.
		for (Vehicles vehicle : a) {
			System.out.println(vehicle.getVehicleName());
			System.out.println(vehicle.getPrice());
			System.out.println(vehicle.getSupplier());
			System.out.println(vehicle.getsIPP());
			System.out.println(vehicle.getRating());
		}
		
	}

}
