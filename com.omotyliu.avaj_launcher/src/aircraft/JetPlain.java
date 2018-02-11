package src.aircraft;

import src.Coordinates;
import src.weather.WeatherTower;


public class JetPlain extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    JetPlain(String name, Coordinates coord) {
        super(name, coord);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coord);

        switch (weather) {
            case "RAIN":
                coord.change(coord.getLongitude(), coord.getLatitude() + 5, coord.getHeight());
                super.updateConditions("It s rainy, changing latitude");
                break;
            case "FOG":
                coord.change(coord.getLongitude(), coord.getLatitude() + 1, coord.getHeight());
                super.updateConditions("Zero visibility, changing latitude");
                break;
            case "SUN":
                coord.change(coord.getLongitude(), coord.getLatitude() + 10, coord.getHeight() + 2);
                super.updateConditions("So good weather, changing latitude");
                break;
            case "SNOW":
                coord.change(coord.getLongitude(), coord.getLatitude(), coord.getHeight() - 7);
                super.updateConditions("Yahhh snow... , changing height");
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
