package classes;

public class Car {

    private double speed;
    private double price;
    private int doors;
    private String name;

    public Car(double speed, double price, int doors, String name) {
        this.speed = speed;
        this.price = price;
        this.doors = doors;
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
