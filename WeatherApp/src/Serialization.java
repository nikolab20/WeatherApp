import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Serialization {

	public static String getContent(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		boolean endReading = false;
		String response = "";

		while (!endReading) {
			String s = in.readLine();

			if (s != null) {
				response += s;
			} else {
				endReading = true;
			}
		}
		in.close();

		return response.toString();
	}

	public static void getWeather(String city) throws IOException {
		String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city
				+ "&APPID=9a3f762719741e83715f0734f751fb5c&units=metric";

		String result = getContent(url);
		Gson gson = new GsonBuilder().create();
		JsonObject jsonResult = gson.fromJson(result, JsonObject.class);

		String name = jsonResult.get("name").getAsString();
		String country = jsonResult.get("sys").getAsJsonObject().get("country").getAsString();
		String currentTemp = jsonResult.get("main").getAsJsonObject().get("temp").getAsString();

		Date date = new Date();
		SimpleDateFormat jdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
		String java_date = jdf.format(date);
		
		System.out.println("\nTime: " + java_date);
		System.out.println(name + ", " + country);
		System.out.println("Current temperature: " + currentTemp + " °C.");
	}
}
