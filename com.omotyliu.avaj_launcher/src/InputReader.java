package src;

import src.aircraft.AircraftFactory;
import src.aircraft.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputReader
{
    private static BufferedReader reader;
    private static ArrayList<String> lines;
    private static List<Flyable> flayable = new ArrayList<>();
    static int countChanges;


    public InputReader() {
    }

    private static void getReader(String scenario)
    {

        File file = new File(scenario);

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e)
        {
            throw new AvajInputException("File with name " + scenario + " not found");
        }
    }

    private static void getCount()
    {
      
        try
        {
            String count = lines.get(0);
            long temp  = Long.valueOf(count);
            if(temp < 1 || temp > Integer.MAX_VALUE)
            {
                throw new RuntimeException();
            }
            countChanges = (int) temp;
            lines.remove(0);
        }catch (Exception ex)
        {
            throw new AvajInputException("Number of simulations is wrong (min 0  - max ?)");
        }
    }

    static List<Flyable> readAndCreate(String scenario) throws AvajInputException
    {
        lines = new ArrayList<>();
        String line;
        getReader(scenario);


        try {
            while ((line = reader.readLine()) != null)
                lines.add(line);
            reader.close();
        } catch (IOException e) {
            throw new AvajInputException("Something wrong with file");
        }
        getCount();
        createAircraft();
        return flayable;
    }

    private static void createAircraft()
    {
        for (String line : lines)
        {
            line = line.trim();
            String[] jet = line.split(" ");
            flayable.add(createJet(jet));
        }
    }

    private static Flyable createJet(String[] jet)
    {
        if(jet.length != 5)
            throw new AvajInputException("Scenario file is broken");
        Coordinates planeCoord;
        try
        {
            planeCoord = new Coordinates(Integer.valueOf(jet[2]), Integer.valueOf(jet[3]), Integer.valueOf(jet[4]));
        }catch (RuntimeException ex)
        {
            throw new AvajInputException("Coordinates incorrect");
        }
        return AircraftFactory.newAircraft(jet[0], jet[1], planeCoord);
    }
}


