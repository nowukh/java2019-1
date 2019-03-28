package HW;

public class Lion extends Feline{
    public Lion(String pic, Hunger hung, Boundaries bound, Location loc) {
        picture = pic;
//        food = Food.GRASS;
        hunger = hung;
        boundaries = bound;
        location = loc;
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

