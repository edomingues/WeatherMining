package com.weathermining;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.edomingues.gae.persistence.jpa.EntityManagerFactorySingleton;
import com.weathermining.climetua.ClimetuaSource;
import com.weathermining.model.Weather;

public class Fetcher {
	private IDataSource<Weather> weatherSource = new ClimetuaSource();
	private long dateTimeOfLastSavedWeather = 0;
	
	public Weather fetchAndSave() throws IOException {
		Weather currentWeather = weatherSource.read();

		if(currentWeather.getDateTime() > dateTimeOfLastSavedWeather) {
			save(currentWeather);
			dateTimeOfLastSavedWeather = currentWeather.getDateTime();
		}
		
		return currentWeather;
	}
	
	private void save(Weather weather) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
		    tx.begin();
		    
		    em.persist(weather);

		    tx.commit();
		}
		finally
		{
		    if (tx.isActive())
		    {
		        tx.rollback();
		    }

		    em.close();
		}
	}
}
