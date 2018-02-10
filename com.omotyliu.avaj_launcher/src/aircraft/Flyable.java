package src.aircraft;

import src.weather.WeatherTower;

public interface Flyable
{
    void updateConditions();
    void registerTower(WeatherTower tower);

}
