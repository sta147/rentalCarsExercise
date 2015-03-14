import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.JSONValue;


public class Main {

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
        
        //System.out.println(arr);
        for (int i = 0; i < arr.length(); i++)
        {
            String sipp = arr.getJSONObject(i).getString("sipp");
            double price = arr.getJSONObject(i).getDouble("price");
            String supplier = arr.getJSONObject(i).getString("supplier");
            String name = arr.getJSONObject(i).getString("name");
            double rating = arr.getJSONObject(i).getDouble("rating");

            //System.out.println("sipp: "+sipp);
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
		
	}

}
