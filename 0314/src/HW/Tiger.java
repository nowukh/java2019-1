package HW;

public class Tiger extends Feline{
    public Tiger(String pic, Hunger hung, Boundaries bound, Location loc) {
        picture = pic;
        food = Food.GRASS;
        hunger = hung;
        boundaries = bound;
        location = loc;
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
