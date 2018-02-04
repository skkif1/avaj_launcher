package src;

import src.aircraft.AircraftFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputReader
{
    BufferedReader reader;
    ArrayList<String> lines;


    public InputReader() {
    }

    private void getReader(String scenario)
    {

        File file = new File(scenario);

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e)
        {
            throw new AvajInputException("File with name " + scenario + " not found");
        }
    }



    public List<Flyable> readAndCreate(String scenario) throws AvajInputException
    {
        lines = new ArrayList<>();
        String line;
        getReader(scenario);


        try {
            while ((line = reader.readLine()) != null)
                lines.add(line);
            reader.close();
        } catch (IOException e) {
            throw new AvajInputException("Something wrong wiith file");
        }
        createAircraft();
        return null;
    }

    private void createAircraft()
    {
        for (String line : lines)
        {
            line = line.trim();
            String[] jet = line.split(" ");
            Flyable flyable = createJet(jet);
        }
    }

    private Flyable createJet(String[] jet)
    {
        if(jet.length != 5)
            throw new AvajInputException("Scenario file is broken");

        Coordinates planeCoord = new Coordinates(Integer.valueOf(jet[2]), Integer.valueOf(jet[3]), Integer.valueOf(jet[4]));
        Flyable plane = AircraftFactory.newAircraft(jet[0], jet[1], planeCoord);
        return null;
    }
}


