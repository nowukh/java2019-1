package HW;

public class RobotDog extends Robot implements Pet {
    @Override
    public void dance() {
        System.out.println("robotdog dance");
    }

    @Override
    public void hello() {
        System.out.println("robotdog hello");
    }
}
