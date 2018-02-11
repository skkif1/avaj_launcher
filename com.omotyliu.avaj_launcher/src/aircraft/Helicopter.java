package src.aircraft;

import src.Coordinates;
import src.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coord)
    {
        super(name, coord);
    }

    @Override
    public void updateConditions() {

        String weather = weatherTower.getWeather(coord);

        switch (weather)
        {
            case "RAIN":
                coord.change(coord.getLongitude() + 5, coord.getLatitude(), coord.getHeight());
                super.updateConditions("It s rainy, day ....");
                break;
            case "FOG":
                coord.change(coord.getLongitude() + 1, coord.getLatitude(), coord.getHeight());
                super.updateConditions("Cant see anything, God save me");
                break;
            case "SUN":
                coord.change(coord.getLongitude() + 10, coord.getLatitude(), coord.getHeight() + 2);
                super.updateConditions("going well...");
                break;
            case "SNOW":
                coord.change(coord.getLongitude(), coord.getLatitude(), coord.getHeight() - 12);
                super.updateConditions("it is not good , I am falling down");
                break;
        }

        if(coord.getHeight() <= 0)
            weatherTower.unregister(this);
    }

    @Override
    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
    }



}
