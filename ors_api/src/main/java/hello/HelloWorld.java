package hello;

import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class HelloWorld {
	
	
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		Entity<String> payload = Entity.json("{\"coordinates\":[[8.681495,49.41461],[8.686507,49.41943]],\"alternative_routes\":{\"target_count\":3,\"weight_factor\":1.4}}");
	    
	//    
	    Response response = client.target("https://api.openrouteservice.org/v2/directions/driving-car/geojson")
	    		  .request()
	    		  .header("Authorization", "5b3ce3597851110001cf6248356061cc93834cf6a6153f3dd72b3d72")
	    		  .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
	    		  .header("Content-Type", "application/json; charset=utf-8")
	    		  .post(payload);
	    
//	    Map<String, List<String>> map = response.readEntity(new GenericType<Map<String, List<String>>>() { });
//	    List<String> values = map.get("features");
	    
	    System.out.println(response.readEntity(String.class));
	    // System.out.println(values);
	  }
}