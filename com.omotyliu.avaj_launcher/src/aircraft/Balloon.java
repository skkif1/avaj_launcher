package src.aircraft;

import src.Coordinates;
import src.Flyable;
import src.WeatherTower;

public class Balloon extends Aircraft implements Flyable
{

    public Balloon(String name, Coordinates coord) {
        super(name, coord);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower tower) {

    }
}
