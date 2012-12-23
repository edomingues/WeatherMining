package com.weathermining.rest;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.edomingues.gae.persistence.jpa.EntityManagerFactorySingleton;
import com.weathermining.model.Weather;
import com.weathermining.weka.WeatherWekaConverterUtils;

@Path("/")
public class WeatherDataResource {

	private static final Logger LOG = LoggerFactory.getLogger(WeatherDataResource.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Weather> getData() {
		Collection<Weather> weatherData = getAllWeatherData();
		return weatherData;
	}
	
	@GET
	@Produces("application/arff")
	public String getArffData() {
		Collection<Weather> weatherData = getAllWeatherData();		
		try {
			return WeatherWekaConverterUtils.convertWeatherDataToArff(weatherData);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new WebApplicationException(e, Status.INTERNAL_SERVER_ERROR); 
//			return "Error: " + e.getMessage();
		}
	}

	private Collection<Weather> getAllWeatherData() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Query q = em.createQuery("SELECT weather FROM " + Weather.class.getName() + " weather");
		@SuppressWarnings("unchecked")
		Collection<Weather> weatherData = q.getResultList();
		return weatherData;
	}
	
	
}
