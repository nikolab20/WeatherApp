package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
	}

	public static String getContent(String url, JPanel contentPane, JTextField jtfCity) {
		URL obj;
		try {
			obj = new URL(url);
			
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
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(contentPane, "Problems with opening the URL.", "Error!",
					JOptionPane.ERROR_MESSAGE);
			
			jtfCity.setText("");
		} catch (ProtocolException e) {
			JOptionPane.showMessageDialog(contentPane, "Problems with protocol.", "Error!",
					JOptionPane.ERROR_MESSAGE);

			jtfCity.setText("");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(contentPane, "Problems with reading the API.", "Error!",
					JOptionPane.ERROR_MESSAGE);

			jtfCity.setText("");
		}
		
		return null;
		
	}

	public static void getWeather(JTextField jtfCity, JLabel lblLocation, JLabel lblWeather, JLabel lblTemperature,
			JLabel lblIcon, JPanel contentPane) {
		String url = "http://api.openweathermap.org/data/2.5/weather?q=" + jtfCity.getText()
				+ "&APPID=9a3f762719741e83715f0734f751fb5c&units=metric";

		String result;

		result = getContent(url, contentPane, jtfCity);

		Gson gson = new GsonBuilder().create();
		JsonObject jsonResult = gson.fromJson(result, JsonObject.class);

		String name = jsonResult.get("name").getAsString();
		String country = jsonResult.get("sys").getAsJsonObject().get("country").getAsString();
		String currentTemp = jsonResult.get("main").getAsJsonObject().get("temp").getAsString();
		String weather = jsonResult.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("main")
				.getAsString();

		lblLocation.setText(name + ", " + country);
		lblWeather.setText(weather);
		lblTemperature.setText(currentTemp + " °C");
		String icon = jsonResult.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString()
				.toLowerCase();

		lblIcon.setIcon(new ImageIcon(getImage(contentPane, icon)));
		
		jtfCity.setText("");

	}

	public static void getWeatherEntry(String city, JLabel lblLocation, JLabel lblWeather, JLabel lblTemperature,
			JLabel lblIcon, JPanel contentPane) {
		String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city
				+ "&APPID=9a3f762719741e83715f0734f751fb5c&units=metric";

		String result;

		result = getContent(url, contentPane, null);

		Gson gson = new GsonBuilder().create();
		JsonObject jsonResult = gson.fromJson(result, JsonObject.class);

		String name = jsonResult.get("name").getAsString();
		String country = jsonResult.get("sys").getAsJsonObject().get("country").getAsString();
		String currentTemp = jsonResult.get("main").getAsJsonObject().get("temp").getAsString();
		String weather = jsonResult.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("main")
				.getAsString();

		lblLocation.setText(name + ", " + country);
		lblWeather.setText(weather);
		lblTemperature.setText(currentTemp + " °C");

		String icon = jsonResult.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString()
				.toLowerCase();

		lblIcon.setIcon(new ImageIcon(getImage(contentPane, icon)));
		

	}

	public static String getLocation(String ip, JPanel contentPane) {
		String url = "http://api.ipstack.com/" + ip + "?access_key=ab62a78a42b10b9f8c29bcf15dc8083f";

		String result;
		String city = null;

		result = getContent(url, contentPane, null);
		Gson gson = new GsonBuilder().create();
		JsonObject jsonResult = gson.fromJson(result, JsonObject.class);

		city = jsonResult.get("city").getAsString();

		return city;
	}

	public static String getExternalIpAddress(JPanel contentPane) {
		URL whatIsMyIP;
		String ip = null;

		try {
			whatIsMyIP = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(whatIsMyIP.openStream()));
			ip = in.readLine();
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(contentPane, "Impossible access to the URL.", "Error!",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(contentPane, "Problems with stream.", "Error!", JOptionPane.ERROR_MESSAGE);
		}

		return ip;
	}

	public static Image getImage(JPanel contentPane, String icon) {
		Image image = null;
		try {
			URL url = new URL("http://openweathermap.org/img/w/" + icon + ".png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(contentPane, "Impossible access to the image.", "Error!",
					JOptionPane.ERROR_MESSAGE);
		}

		return image;
	}

}
