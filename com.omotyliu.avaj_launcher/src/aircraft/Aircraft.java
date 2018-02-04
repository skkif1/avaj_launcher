package src.aircraft;

import src.Coordinates;

abstract class Aircraft {

    long id;

    String name;

    Coordinates coord;

    private long IdCounter;


    public Aircraft(String name, Coordinates coord) {
        this.name = name;
        this.coord = coord;
    }
}
