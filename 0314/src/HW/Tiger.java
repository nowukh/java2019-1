package HW;

public class Tiger extends Feline{
    public Tiger(String picture, Hunger hunger, Boundaries boundaries, Location location) {
        super(picture, hunger, boundaries, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("tiger makeNoise");
    }

    @Override
    public void eat() {
        System.out.println("tiger eat");
    }
}
