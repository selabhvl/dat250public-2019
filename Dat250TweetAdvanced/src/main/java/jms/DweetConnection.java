package jms;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.logging.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @Author Alejandro Rodriguez
 * Dat250
 * 
 * Dweet Connection provider
 * 
 */

public class DweetConnection {

	private String API_DWEET_END_POINT = "dweet.io";

	private JsonParser jsonParser = new JsonParser();

	//Customize for own link 
	private String thingName = "dat250";

	
	public DweetConnection() {
		
		
	}
	
	public boolean publish(JsonElement content) throws IOException {
		if (thingName == null || content == null)
			throw new NullPointerException();

		thingName = URLEncoder.encode(thingName, "UTF-8");
		URL url = new URL("http" + "://" + API_DWEET_END_POINT + "/dweet/for/" + thingName);
		Logger logger = Logger.getLogger(getClass().getName());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setRequestMethod("POST");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		
		PrintWriter out = new PrintWriter(connection.getOutputStream());
		out.println(content.toString());
		out.flush();
		out.close();
		
		JsonObject response = readResponse(connection.getInputStream());
		logger.info("DTWEET Platform response: " + response.toString());
		connection.disconnect();

		return (response.has("this") && response.get("this").getAsString().equals("succeeded"));
	}


	private JsonObject readResponse(InputStream in) {
		Scanner scan = new Scanner(in);
		StringBuilder sn = new StringBuilder();
		while (scan.hasNext())
			sn.append(scan.nextLine()).append('\n');
		scan.close();
		return jsonParser.parse(sn.toString()).getAsJsonObject();
	}
}
