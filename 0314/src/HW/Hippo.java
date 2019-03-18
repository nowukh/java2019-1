package HW;

public class Hippo extends Animal {
    public Hippo(String picture, Hunger hunger, Boundaries boundaries, Location location) {
        super(picture, Food.GRASS, hunger, boundaries, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("hippo makeNoise");
    }

    @Override
    public void eat() {
        System.out.println("hippo eat");
    }
}
