package src.aircraft;

import src.Coordinates;
import src.Logger;

public abstract class Aircraft {

    protected long id;

    protected String name;

    protected Coordinates coord;

    private static long idCounter = 0;


    protected Aircraft(String name, Coordinates coord)
    {
        this.id = nextId();
        this.name = name;
        this.coord = coord;
    }


    public String getCompoundName() {
        return getClass().getSimpleName() + "#" + name + "(" + id + ")";
    }

    private static long nextId() {
        return idCounter++;
    }

    protected void updateConditions(String customMess) {
        Logger.logMessage(getCompoundName() + ": " + customMess);
        int height = (coord.getHeight() > 100) ? 100 : coord.getHeight();
        int longit = (coord.getLongitude() < 0)  ? 0 : coord.getLongitude();
        int lat = (coord.getLatitude() < 0)  ? 0 : coord.getLatitude();

        coord.change(longit, lat, height);
        if (height <= 0)
        {
            Logger.logMessage(getCompoundName() + " landing my coordinates (long: " + coord.getLongitude() + ", lat: " + coord.getLatitude() + ")");
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
