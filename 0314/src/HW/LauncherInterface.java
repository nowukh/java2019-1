package HW;

public class LauncherInterface {

    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Cat(
                "pic_cat",
                Hunger.HIGH,
                new Boundaries(100,200),
                new Location(111,222)
        );

        animals[1]= new Dog(
                "pic_DOG",
                Hunger.LOW,
                new Boundaries(100,200),
                new Location(111,222)
        );


        for(Animal animal :animals) {
            System.out.println("======" + animal.getClass().getSimpleName() + "======");
            animal.makeNoise();
            animal.eat();
            animal.sleep();
            animal.roam();

            if (animal instanceof Pet) {
                ((Pet) animal).hello();
            }
            System.out.println();
        }

        Robot[] robots = new Robot[2];
        robots[0] = new Agent();

        robots[1] = new RobotDog();

        for (Robot robot: robots) {
            System.out.println("======" + robot.getClass().getSimpleName() + "======");
            robot.dance();
            if (robot instanceof Pet){
                ((Pet) robot).hello();
            }
            System.out.println();
        }



    }
}
