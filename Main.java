package dev.lpa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();

//        flier.takeOff();
//        flier.fly();
//        tracked.track();
//        flier.land();

        inFlight(flier);
        inFlight(new Jet());

        Trackable truck = new Truck();
        truck.track();

        double kmTraveled = 100;
        double milesTraveled = kmTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n",kmTraveled,milesTraveled);

        LinkedList<FlightEnabled> fliers = new LinkedList<>();
        fliers.add(bird);

        List<FlightEnabled> betterFliers = new ArrayList<>();
        betterFliers.add(bird);

        triggerFlier(fliers);
        flyFlier(fliers);
        landFlier(fliers);

        triggerFlier(betterFliers);
        flyFlier(betterFliers);
        landFlier(betterFliers);
    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if(flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void triggerFlier(List<FlightEnabled> fliers) {
        for(var flier : fliers) {
            flier.takeOff();
        }
    }

    private static void flyFlier(List<FlightEnabled> fliers) {
        for(var flier : fliers) {
            flier.fly();
        }
    }

    private static void landFlier(List<FlightEnabled> fliers) {
        for(var flier : fliers) {
            flier.land();
        }
    }
}
