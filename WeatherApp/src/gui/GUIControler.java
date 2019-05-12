package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class GUIControler {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherGUI frame = new WeatherGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		GUIControler g = new GUIControler();
	}

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

	public static void getWeather(JTextField jtfCity, JLabel lblLocation, JLabel lblTime, JLabel lblTemperature) throws IOException {
		String url = "http://api.openweathermap.org/data/2.5/weather?q=" + jtfCity.getText()
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

		lblLocation.setText(name + ", " + country);
		lblTime.setText(java_date);
		lblTemperature.setText(currentTemp + " °C");
	}
	
	public static void getWeatherEntry(String city, JLabel lblLocation, JLabel lblTime, JLabel lblTemperature) throws IOException {
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

		lblLocation.setText(name + ", " + country);
		lblTime.setText(java_date);
		lblTemperature.setText(currentTemp + " °C");
	}

	public static String getLocation(String ip) throws IOException {
		String url = "http://api.ipstack.com/" + ip + "?access_key=ab62a78a42b10b9f8c29bcf15dc8083f";

		String result = getContent(url);
		Gson gson = new GsonBuilder().create();
		JsonObject jsonResult = gson.fromJson(result, JsonObject.class);

		String city = jsonResult.get("city").getAsString();

		return city;
	}

	public static String getExternalIpAddress() throws IOException {
		URL whatIsMyIP = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(whatIsMyIP.openStream()));
		String ip = in.readLine();

		return ip;
	}

	public static Image getImage() {
		Image image = null;
		try {
			URL url = new URL("http://openweathermap.org/img/w/10d.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return image;
	}

}
