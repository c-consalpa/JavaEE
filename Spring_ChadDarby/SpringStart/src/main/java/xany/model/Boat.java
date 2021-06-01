package xany.model;

import java.util.Random;

public class Boat implements Vehicle {
    Engine engine;
    private int[] max_speed = {60, 90, 120};

    public void getMaxSpeed() {
        System.out.println(max_speed[(int) (Math.random() * 3)]);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void move() {

    }

    @Override
    public String toString() {
        return "Boat{" +
                "engine=" + engine +
                '}';
    }
}
