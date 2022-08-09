package org.example;

import org.w3c.dom.Node;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    private static LinkedList<Integer> fanSpeeds = new LinkedList<>();
    ListIterator<Integer> fanSpeedsIterator;
    Iterator<Integer> descendingIterator;
    private boolean isMovingForward = true;
    private Integer currentSpeed;

    public Main() {

        instantiateSpeeds();
    }

    private void instantiateSpeeds() { // Configurations
        for (int i = 0; i < 4; i++) {
            fanSpeeds.add(i);
        }

        fanSpeedsIterator = fanSpeeds.listIterator();
        descendingIterator = fanSpeeds.descendingIterator();
        currentSpeed = fanSpeeds.getFirst();
    }

    private void reverseDirection() { // Fan Service
        isMovingForward = !isMovingForward;
    }

    private void changeSpeed() { // Fan Service
        if (isMovingForward){
            if (!fanSpeedsIterator.hasNext()) {
                fanSpeedsIterator = fanSpeeds.listIterator();
            }

            currentSpeed = fanSpeedsIterator.next();
        }
        else{
            if (!descendingIterator.hasNext()) {
                descendingIterator = fanSpeeds.descendingIterator();
            }

            currentSpeed = descendingIterator.next();
        }
    }

    public static void main(String[] args) {
        Main runNow = new Main();

        System.out.println("Initializing fan speeds");
        System.out.println(fanSpeeds);

        for (int i = 0; i < 10; i++) {
            runNow.changeSpeed();
            System.out.println("The current speed is " + runNow.currentSpeed);
        }

        runNow.reverseDirection();
        System.out.println("\n\nReversing direction!!!\n\n");

        for (int i = 0; i < 10; i++) {
            runNow.changeSpeed();
            System.out.println("The current speed is " + runNow.currentSpeed);
        }
    }
}