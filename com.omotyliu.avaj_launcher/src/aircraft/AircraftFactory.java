package src.aircraft;

import src.AvajInputException;
import src.Coordinates;
import src.Flyable;

public class AircraftFactory
{

    private static final String[] SUPPORTED_TYPES = {"HELLICOPTER", "BALOON", "JETAIRCRAFT"};

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        return null;
    }

    public static Flyable newAircraft(String type, String name, Coordinates coord)
    {
        if(!checkType(type))
            throw new AvajInputException("Type not suported");
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
