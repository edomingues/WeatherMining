package com.weathermining.rest;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.edomingues.gae.persistence.jpa.EntityManagerFactorySingleton;
import com.weathermining.model.Weather;

@Path("/")
public class WeatherDataResource {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Weather> getData() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Query q = em.createQuery("SELECT weather FROM " + Weather.class.getName() + " weather");
		@SuppressWarnings("unchecked")
		Collection<Weather> weatherData = q.getResultList();
		return weatherData;
	}
}
