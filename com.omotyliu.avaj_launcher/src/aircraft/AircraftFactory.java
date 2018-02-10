package src.aircraft;

import src.AvajInputException;
import src.Coordinates;

public class AircraftFactory
{

    private static final String[] SUPPORTED_TYPES = {"HELICOPTER", "BALOON", "JETPLANE"};

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        return newAircraft(type, name, new Coordinates(longitude, latitude, height));
    }

    public static Flyable newAircraft(String type, String name, Coordinates coord)
    {
        if(!checkType(type))
            throw new AvajInputException("Type not suported");

        switch (type.toUpperCase())
        {
            case "HELICOPTER":
                return new Helicopter(name, coord);
            case "BALOON":
                return new Balloon(name, coord);
            case "JETPLANE":
                return new JetPlain(name, coord);
        }
        return null;
    }

    private static boolean checkType(String type)
    {
        boolean contains = false;
        for (String supType : SUPPORTED_TYPES)
        {
            if(supType.equalsIgnoreCase(type))
            {
                contains = true;
            }
        }
        return contains;
    }
}
