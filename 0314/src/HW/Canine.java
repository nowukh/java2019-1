package HW;

public class Canine extends Animal {
    public Canine(String picture, Hunger hunger, Boundaries boundaries, Location location) {
        super(picture, Food.MEAT, hunger, boundaries, location);
    }

    @Override
    public void roam() {
        System.out.println("Canine roam");
    }
}
