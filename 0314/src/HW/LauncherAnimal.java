package HW;

public class LauncherAnimal {
    public static void main(String[] args) {
        Animal[] animals = new Animal[6];

        animals [0] = new Lion(
                "pic_lion",
                Hunger.HIGH,
                new Boundaries(100,200),
                new Location(111,222)
        );

        animals [1] = new Tiger(
                "pic_tiger",
                Hunger.LOW,
                new Boundaries(200,500),
                new Location(222,333)
        );

        animals [2] = new Cat(
                "pic_cat",
                Hunger.HIGH,
                new Boundaries(100,200),
                new Location(111,222)
        );

        animals [3] = new Hippo(
                "pic_hippo",
                Hunger.MID,
                new Boundaries(100,200),
                new Location(111,222)
        );

        animals [4] = new Wolf(
                "pic_wolf",
                Hunger.HIGH,
                new Boundaries(100,200),
                new Location(111,222)
        );

        animals [5] = new Dog(
                "pic_DOG",
                Hunger.LOW,
                new Boundaries(100,200),
                new Location(111,222)
        );

        for (Animal animal: animals) {

            System.out.println("======"+animal.getClass().getSimpleName()+"======");
            animal.makeNoise();
            animal.eat();
            animal.sleep();
            animal.roam();
            System.out.println();

        }
    }

}
