package src.weather;

import src.Logger;
import src.aircraft.Aircraft;
import src.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower
{
    private List<Flyable> obsorved;

    private List<Flyable> toDell;

    public Tower()

    {
        obsorved = new ArrayList<>();
        toDell = new ArrayList<>();
    }

    public void register(Flyable flyable)
    {
        obsorved.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        toDell.add(flyable);
        Logger.logMessage("Tower says: " +  ((Aircraft)flyable).getCompoundName() + "  unregistered from weather tower.");
    }


    protected void conditionsChanged()
    {
        for (Flyable plane : obsorved)
        {
            plane.updateConditions();
        }
        obsorved.removeAll(toDell);
    }

    public void register(List<Flyable> flyables)
    {
        obsorved.addAll(flyables);
        for (Flyable plane : flyables)
        {
            Logger.logMessage("Tower says: " +  ((Aircraft)plane).getCompoundName() + " registered to weather tower.");
        }
    }


}
