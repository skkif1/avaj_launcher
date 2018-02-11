package src.weather;

import src.Coordinates;
import src.aircraft.Flyable;

import java.util.List;

public class WeatherTower extends Tower
{

    private WeatherProvider provider;

    private String currentWeather;

    private Coordinates coord;

    public WeatherTower()
    {
        provider = WeatherProvider.getProvider();
    }

    public String getWeather(Coordinates coord)
    {
        this.coord = coord;
        changeWeather();
        return currentWeather;
    }


    void changeWeather()
    {
        currentWeather = provider.getCurrentWeather(coord);
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

    @Override
    protected void conditionsChanged()
    {
        for (Flyable plane : getObsorvers())
        {
            plane.updateConditions();
        }
        super.conditionsChanged();
    }

    public void simulate(int i)
    {
        for (int j = 0; j < i; j++)
        {
            conditionsChanged();
        }
    }
}
