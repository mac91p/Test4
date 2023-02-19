package zad1.model;

public class Car implements Comparable<Car>{

    private String producer;
    private String model;
    private double engineCapacity;

    public Car(String producer, String model, double engineCapacity) {
        this.producer = producer;
        this.model = model;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity=" + engineCapacity +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        int result = producer.compareTo(o.producer);
        if(result == 0)
            result = model.compareTo(o.model);
        if(result == 0)
            result = Double.compare(engineCapacity,o.engineCapacity);
        return result;
    }
}
