package HW;

public class Feline extends Animal {

    public Feline(String picture, Hunger hunger, Boundaries boundaries, Location location) {
        super(picture, Food.MEAT, hunger, boundaries, location);
    }

    @Override
    public void roam() {
        System.out.println("feline roam");
    }
}
