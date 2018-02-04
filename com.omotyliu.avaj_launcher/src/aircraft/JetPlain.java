package src.aircraft;

import src.Coordinates;
import src.Flyable;
import src.WeatherTower;

public class JetPlain extends Aircraft implements Flyable
{
    public JetPlain(String name, Coordinates coord)
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
