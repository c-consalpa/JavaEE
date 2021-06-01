package xany.model;

public class Engine {
    private String model;


    public Engine(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "Engine{" +
                "model='" + model + '\'' +
                '}';
    }
}
