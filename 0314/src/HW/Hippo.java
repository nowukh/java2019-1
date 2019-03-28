package HW;

public class Hippo extends Animal {
    public Hippo(String pic, Hunger hung, Boundaries bound, Location loc) {
        picture = pic;
//        food = Food.GRASS;
        hunger = hung;
        boundaries = bound;
        location = loc;
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
