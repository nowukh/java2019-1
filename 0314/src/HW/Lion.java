package HW;

public class Lion extends Feline{
    public Lion(String picture, Hunger hunger, Boundaries boundaries, Location location) {
        super(picture, hunger, boundaries, location);
    }

    @Override
    public void makeNoise() {
        System.out.println("lion makeNoise");
    }

    @Override
    public void eat() {
        System.out.println("lion eat");
    }
}

