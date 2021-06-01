package xany.model;

public class Car implements Vehicle {
    private String model;
    private Engine engine;


    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    @Override
    public void move() {
        System.out.println("roll on wheels");
    }

    @Override
    public void getMaxSpeed() {

    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", engine=" + engine +
                '}';
    }
}
