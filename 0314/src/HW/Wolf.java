package HW;

public class Wolf extends Canine{
    public Wolf(String pic, Hunger hung, Boundaries bound, Location loc) {
        picture = pic;
//        food = Food.GRASS;
        hunger = hung;
        boundaries = bound;
        location = loc;
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
