package HW;

public class Cat extends Feline implements Pet {
    public Cat(String pic, Hunger hung, Boundaries bound, Location loc) {
        picture = pic;
//        food = Food.GRASS;
        hunger = hung;
        boundaries = bound;
        location = loc;
    }

    @Override
    public void makeNoise() {
        System.out.println("cat makeNOise");
    }

    @Override
    public void eat() {
        System.out.println("cat eat");
    }

    @Override
    public void hello() {
        System.out.println("cat hello");
    }
}
