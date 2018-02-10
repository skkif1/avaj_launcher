package src;

public class Coordinates
{

    private int longitude;

    private int latitude;

    private int height;

    public Coordinates(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;

        if((height < 0 || longitude < 0 || latitude < 0) || height > 100)
            throw new AvajInputException("coordinates are incorrect");
    }



    public Coordinates(String longitude, String latitude, String height)
    {
        try {
            new Coordinates(Integer.valueOf(longitude), Integer.valueOf(latitude), Integer.valueOf(height));
        }catch (RuntimeException ex)
        {
            throw new AvajInputException("bad coordinates");
        }
    }

    public void change(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }



    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", height=" + height +
                '}';
    }
}
