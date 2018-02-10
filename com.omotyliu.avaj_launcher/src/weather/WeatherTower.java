package src.weather;

import src.Coordinates;
import src.Logger;
import src.aircraft.Aircraft;
import src.aircraft.Flyable;

import java.util.List;

public class WeatherTower extends Tower
{

    private WeatherProvider provider;

    private String currentWeather;

    public WeatherTower()
    {
        provider = WeatherProvider.getProvider();
    }

    public String getWeather(Coordinates coord)
    {
        return currentWeather;
    }


    private void changeWeather()
    {
        currentWeather = provider.getCurrentWeather(null);

    }

    @Override
    public void register(List<Flyable> flyables)
    {
        super.register(flyables);
        for (Flyable plane : flyables)
        {
            plane.registerTower(this);
        }
    }

    public void simulate(int i)
    {
        for (int j = 1; j < i; j++)
        {
            changeWeather();
            conditionsChanged();
        }

    }
}
