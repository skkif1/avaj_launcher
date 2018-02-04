package src.weather;

import src.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower
{
    private List<Flyable> obsorved;


    public Tower()
    {
        obsorved = new ArrayList<>();
    }

    void register(Flyable flyable)
    {
        obsorved.add(flyable);
    }

    void unregister(Flyable flyable)
    {
        obsorved.remove(flyable);
    }

}
