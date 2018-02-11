package src.aircraft;

import src.Coordinates;
import src.weather.WeatherTower;

public class Balloon extends Aircraft implements Flyable {

    Balloon(String name, Coordinates coord) {
        super(name, coord);
    }

    private WeatherTower weatherTower;


    @Override
    public void updateConditions() {

        String weather = weatherTower.getWeather(coord);

        switch (weather) {
            case "RAIN":
                coord.change(coord.getLongitude(), coord.getLatitude(), coord.getHeight() - 5);
                super.updateConditions("It s rainy, bucket full of watter");
                break;
            case "FOG":
                coord.change(coord.getLongitude(), coord.getLatitude(), coord.getHeight() - 3);
                super.updateConditions("Zero visibility, cant see anything");
                break;
            case "SUN":
                coord.change(coord.getLongitude() + 2, coord.getLatitude(), coord.getHeight() + 4);
                super.updateConditions("So good weather, can fly normally");
                break;
            case "SNOW":
                coord.change(coord.getLongitude(), coord.getLatitude(), coord.getHeight() - 15);
                super.updateConditions("Yahhh snow... , falling down");
                break;
        }
        if (coord.getHeight() <= 0)
            weatherTower.unregister(this);
    }

    @Override
    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
    }
}
