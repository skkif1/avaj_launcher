package src.aircraft;

import src.Coordinates;
import src.Logger;
import src.weather.Tower;
import src.weather.WeatherTower;

public abstract class Aircraft implements Flyable {

    private long id;

    protected String name;

    protected Coordinates coord;

    private WeatherTower weatherTower;

    private static long idCounter = 0;


    public Aircraft(String name, Coordinates coord) {
        this.id = nextId();
        this.name = name;
        this.coord = coord;
    }

    @Override
    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
    }

    public String getCompoundName() {
        return getClass().getSimpleName() + "#" + name + "(" + id + ")";
    }

    private static long nextId() {
        return idCounter++;
    }

    WeatherTower getWeatherTower() {
        return this.weatherTower;
    }

    public void updateConditions(String customMess) {
        Logger.logMessage(getCompoundName() + ": " + customMess);
        int height = (coord.getHeight() > 100) ? 100 : coord.getHeight();

        coord.change(coord.getLongitude(), coord.getLatitude(), height);
        if (height <= 0)
        {
            Logger.logMessage(getCompoundName() + " landing my coordinates (long: " + coord.getLongitude() + ", lat: " + coord.getLatitude() + ")");
            getWeatherTower().unregister(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;

        Aircraft aircraft = (Aircraft) o;

        if (id != aircraft.id) return false;
        return name.equals(aircraft.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                '}';
    }
}
