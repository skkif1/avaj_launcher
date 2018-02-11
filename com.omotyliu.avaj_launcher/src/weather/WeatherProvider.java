package src.weather;

import src.Coordinates;

import java.util.Random;

class WeatherProvider {
    private static WeatherProvider weatherProvider;

    private String[] weather = new String[]{"RAIN", "FOG", "SUN", "SNOW",};

    private Random random;


    private WeatherProvider() {
        random = new Random(System.currentTimeMillis());
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            return new WeatherProvider();
        else
            return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        int i = random.nextInt(4);
        i = (coordinates.getHeight() > 20) ? i++ : i--;
        i = (i < 0) ? 3 : i;
        i = (i > 3) ? 0 : i;
        return weather[i];
    }


}
