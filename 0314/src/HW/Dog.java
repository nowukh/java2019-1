package HW;

public class Dog extends Canine {
    public Dog(String picture, Hunger hunger, Boundaries boundaries, Location location) {
        super(picture, hunger, boundaries, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("dog makeNoise");
    }

    @Override
    public void eat() {
        System.out.println("dog eat");
    }
}
