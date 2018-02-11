package src;

import src.aircraft.Flyable;
import src.weather.WeatherTower;

import java.util.List;

public class Application
{

    private static WeatherTower tower;

    public static void main(String[] args)
    {
        List<Flyable> flyables = null;
        try {

             flyables = InputReader.readAndCreate(args[0]);
        }catch (AvajInputException ex)
        {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        tower = new WeatherTower();
        tower.register(flyables);
        tower.simulate(InputReader.countChanges);
        Logger.flushLines();
    }
}
