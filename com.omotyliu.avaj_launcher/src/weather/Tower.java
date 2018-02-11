package src.weather;

import src.Logger;
import src.aircraft.*;
import java.util.ArrayList;
import java.util.List;

public class Tower
{
    private List<Flyable> obsorvers;

    private List<Flyable> toDell;

    public Tower()

    {
        obsorvers = new ArrayList<>();
        toDell = new ArrayList<>();
    }

    public void register(Flyable flyable)
    {
        obsorvers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        toDell.add(flyable);
        Logger.logMessage("Tower says: " +  ((Aircraft)flyable).getCompoundName() + "  unregistered from weather tower.");
    }

    protected List<Flyable> getObsorvers()
    {
        return this.obsorvers;
    }

    protected void conditionsChanged()
    {
        obsorvers.removeAll(toDell);
    }

    public void register(List<Flyable> flyables)
    {
        obsorvers.addAll(flyables);
        for (Flyable plane : flyables)
        {
            Logger.logMessage("Tower says: " +  ((Aircraft)plane).getCompoundName() + " registered to weather tower.");
        }
    }

}
