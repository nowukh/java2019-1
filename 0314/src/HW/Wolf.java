package HW;

public class Wolf extends Canine{
    public Wolf(String picture, Hunger hunger, Boundaries boundaries, Location location) {
        super(picture, hunger, boundaries, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("wolf makeNoise");
    }

    @Override
    public void eat() {
        System.out.println("wolf eat");
    }
}
