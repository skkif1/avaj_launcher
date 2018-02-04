package src.weather;

import src.Coordinates;

public class WeatherProvider
{
    private WeatherProvider weatherProvider;

    private String[] weather;

    public WeatherProvider() {

    }

    public WeatherProvider getProvider()
    {
        return null;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        return "cirrentWeather";
    }
}
