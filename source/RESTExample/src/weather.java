

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

@Path("/weathersrvc")
public class weather {

  private static String readJsonData(Reader rd) throws Exception {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject getJsonData(String url) throws Exception {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readJsonData(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
	@GET
	@Produces("application/json")
  public String Getweather() throws Exception
  {
	  String city="Delhi";
	  String jsonstr="";
	String api="http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=aecc1ada15291787e9f4ec95ab382165&units=metric";
    JSONObject json = getJsonData(api);
    System.out.println(json.toString());
    jsonstr=json.toString();
    System.out.println(json.get("id"));
    return jsonstr;
  }

}