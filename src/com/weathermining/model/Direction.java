package com.weathermining.model;

public enum Direction {
	N, NNE, ENE, NE, E, ESE, SE, SSE, S, SSW, SW, WSW, W, WNW, NW, NNW;
	
	public static String generateRegularExpression() {
		StringBuilder regex = new StringBuilder();
		Direction values[] = Direction.values();
		if(values.length > 0) {
			regex.append(values[0].name());
			for(int i=1; i<values.length; i++)
				regex.append("|").append(values[i].name());
		}
		return regex.toString();
	}
}
