package com.weathermining;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weathermining.model.Weather;

@SuppressWarnings("serial")
public class FetchServlet extends HttpServlet {
	
	private static final Logger LOG = LoggerFactory.getLogger(FetchServlet.class);
	
	private static Fetcher fetcher = new Fetcher();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		try {
			
			resp.setContentType("text/plain");
			PrintWriter pw = resp.getWriter();
			
			Weather currentWeather;
			synchronized(fetcher) {
				currentWeather = fetcher.fetchAndSave();
			}
			
			pw.println("Date: "+formatDateTime(currentWeather.getDateTime()));
			
		} catch (Exception e) {
			LOG.error("Error fetching weather.", e);
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

	}
	
	private String formatDateTime(long dateTime) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z");
		Date date = new Date(dateTime);		
		return dateFormat.format(date);
	}
	
	
}
