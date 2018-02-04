package src.aircraft;

import src.Coordinates;
import src.Flyable;
import src.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{

    public Helicopter(String name, Coordinates coord)
    {
        super(name, coord);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower tower) {

    }
}
