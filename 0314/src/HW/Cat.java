package HW;

public class Cat extends Feline {
    public Cat(String picture, Hunger hunger, Boundaries boundaries, Location location) {
        super(picture, hunger, boundaries, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("cat makeNOise");
    }

    @Override
    public void eat() {
        System.out.println("cat eat");
    }
}
