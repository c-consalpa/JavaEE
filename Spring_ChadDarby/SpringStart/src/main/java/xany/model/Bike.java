package xany.model;

public class Bike implements Vehicle {
    private Engine engine;
    private int wheelsCnt;
    private int maxSpeed;

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWheelsCnt(int wheelsCnt) {
        this.wheelsCnt = wheelsCnt;
    }

    @Override
    public void move() {

    }

    @Override
    public void getMaxSpeed() {

    }


    @Override
    public String toString() {
        return "Bike{" +
                "engine=" + engine +
                ", wheelsCnt=" + wheelsCnt +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
