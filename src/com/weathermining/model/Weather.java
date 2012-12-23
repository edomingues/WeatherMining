package com.weathermining.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Weather {
	@Id
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	private long dateTime;
	private double temperatureCelcius;
	private double humidityPercentage;
	private double dewpointCelcius;
	private double windSpeedMetersPerSecond;
	private Direction windDirection;
	private double barometerPressurePascal;
	private String barometerTendency; // TODO change type to enum
	private double totalRainTodayMillimeters;
	private double rainRateMillimetersPerHour;
	private double totalStormMillimeters;
	private double totalMonthlyRainMillimeters;
	private double totalYearlyRainMillimeters;
	private double windChillCelcius;
	private double thwIndexCelcius;
	private double heatIndexCelcius;
	private double uvIndex;
	private int solarRadiationWattsPerSquareMeter;

	public Weather() {}
	
	public Long getId() { 
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTemperatureCelcius() {
		return temperatureCelcius;
	}

	public void setTemperatureCelcius(double temperatureCelcius) {
		this.temperatureCelcius = temperatureCelcius;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	public double getHumidityPercentage() {
		return humidityPercentage;
	}

	public void setHumidityPercentage(double humidityPercentage) {
		this.humidityPercentage = humidityPercentage;
	}

	public double getDewpointCelcius() {
		return dewpointCelcius;
	}

	public void setDewpointCelcius(double dewpointCelcius) {
		this.dewpointCelcius = dewpointCelcius;
	}

	public double getWindSpeedMetersPerSecond() {
		return windSpeedMetersPerSecond;
	}

	public void setWindSpeedMetersPerSecond(double windSpeedMetersPerSecond) {
		this.windSpeedMetersPerSecond = windSpeedMetersPerSecond;
	}

	public Direction getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(Direction windDirection) {
		this.windDirection = windDirection;
	}

	public double getBarometerPressurePascal() {
		return barometerPressurePascal;
	}

	public void setBarometerPressurePascal(double barometerPressurePascal) {
		this.barometerPressurePascal = barometerPressurePascal;
	}

	public String getBarometerTendency() {
		return barometerTendency;
	}

	public void setBarometerTendency(String barometerTendency) {
		this.barometerTendency = barometerTendency;
	}

	public double getTotalRainTodayMillimeters() {
		return totalRainTodayMillimeters;
	}

	public void setTotalRainTodayMillimeters(double totalRainTodayMillimeters) {
		this.totalRainTodayMillimeters = totalRainTodayMillimeters;
	}

	public double getRainRateMillimetersPerHour() {
		return rainRateMillimetersPerHour;
	}

	public void setRainRateMillimetersPerHour(double rainRateMillimetersPerHour) {
		this.rainRateMillimetersPerHour = rainRateMillimetersPerHour;
	}

	public double getTotalStormMillimeters() {
		return totalStormMillimeters;
	}

	public void setTotalStormMillimeters(double totalStormMillimeters) {
		this.totalStormMillimeters = totalStormMillimeters;
	}

	public double getTotalMonthlyRainMillimeters() {
		return totalMonthlyRainMillimeters;
	}

	public void setTotalMonthlyRainMillimeters(double totalMonthlyRainMillimeters) {
		this.totalMonthlyRainMillimeters = totalMonthlyRainMillimeters;
	}

	public double getTotalYearlyRainMillimeters() {
		return totalYearlyRainMillimeters;
	}

	public void setTotalYearlyRainMillimeters(double totalYearlyRainMillimeters) {
		this.totalYearlyRainMillimeters = totalYearlyRainMillimeters;
	}

	public double getWindChillCelcius() {
		return windChillCelcius;
	}

	public void setWindChillCelcius(double windChillCelcius) {
		this.windChillCelcius = windChillCelcius;
	}

	public double getThwIndexCelcius() {
		return thwIndexCelcius;
	}

	public void setThwIndexCelcius(double thwIndexCelcius) {
		this.thwIndexCelcius = thwIndexCelcius;
	}

	public double getHeatIndexCelcius() {
		return heatIndexCelcius;
	}

	public void setHeatIndexCelcius(double heatIndexCelcius) {
		this.heatIndexCelcius = heatIndexCelcius;
	}

	public double getUvIndex() {
		return uvIndex;
	}

	public void setUvIndex(double uvIndex) {
		this.uvIndex = uvIndex;
	}

	public int getSolarRadiationWattsPerSquareMeter() {
		return solarRadiationWattsPerSquareMeter;
	}

	public void setSolarRadiationWattsPerSquareMeter(
			int solarRadiationWattsPerSquareMeter) {
		this.solarRadiationWattsPerSquareMeter = solarRadiationWattsPerSquareMeter;
	}
	
	
}
