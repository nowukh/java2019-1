package HW;

public class Dog extends Canine implements Pet {
    public Dog(String pic, Hunger hung, Boundaries bound, Location loc) {
        picture = pic;
//        food = Food.GRASS;
        hunger = hung;
        boundaries = bound;
        location = loc;
    }
    @Override
    public void makeNoise() {
        System.out.println("dog makeNoise");
    }

    @Override
    public void eat() {
        System.out.println("dog eat");
    }

    @Override
    public void hello() {
        System.out.println("dog hello");
    }
}
