package com.weathermining.climetua;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.weathermining.IDataSource;
import com.weathermining.model.Weather;

public class ClimetuaSource implements IDataSource<Weather> {

	private ClimetuaParser parser = new ClimetuaParser();
	
	@Override
	public Weather read() throws IOException {

			Connection connection = Jsoup.connect("http://climetua.fis.ua.pt/legacy/main/current_monitor/cesamet.htm");
			Document doc = connection.get();			
			
			Weather weather = parser.parse(doc);
			
			weather.setDateTime(getLastModified(connection.response()));
			
			return weather;
	
	}
	
	private long getLastModified(Connection.Response response) {
		SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
		try {
			long lastModified = format.parse(response.header("Last-Modified")).getTime();
			long date = format.parse(response.header("Date")).getTime();
			long currentTime = System.currentTimeMillis();			
			long rv = currentTime - (date - lastModified);
			return rv;
		} catch (ParseException e) {
			throw new RuntimeException("Error parsing date headers.", e);
		}
	}

}
