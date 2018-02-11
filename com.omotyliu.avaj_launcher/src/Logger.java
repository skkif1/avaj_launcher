package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Logger
{

    private static List<String> lines = new ArrayList<>();


    public static void logMessage(String message)
    {
        lines.add(message);
        System.out.println(message);
    }

    public static void flushLines()
    {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("simulation.txt"), false))) {
            for (String line : lines)
            {
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("file problem");
        }


    }
}
