

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/restaurantsrvc")
public class Restaurant {

  private static String readJsonData(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int c;
    while ((c = rd.read()) != -1) {
      sb.append((char) c);
    }
    return sb.toString();
  }

  public static JSONObject getJsonData(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader brd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readJsonData(brd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
	@GET
	@Produces("application/json")
  public String GetRestaurant() throws JSONException, IOException
  {
	  String city="Delhi";
	  
	  String jsonstr="";
	String api="https://api.foursquare.com/v2/venues/search" +
            "?client_id=Q0ENF1YHFTNPJ31DCF13ALLENJW0P5MTH13T1SA0ZP1MUOCI" +
            "&client_secret=ZH4CRZNEWBNTALAE3INIB5XG0QI12R4DT5HKAJLWKYE1LHOG" +
            "&v=20160215&limit=10" +
            "&near=" + city +
            "&query=Restaurant";
    JSONObject json = getJsonData(api);
    System.out.println(json.toString());
    jsonstr=json.toString();

    return jsonstr;
  }

}