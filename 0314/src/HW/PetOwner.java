package HW;

public class PetOwner {
    public void start(){
        Vet vet = new Vet();

        Dog dog = new Dog(
                "pic_DOG",
                Hunger.LOW,
                new Boundaries(100,200),
                new Location(222,444)
        );

        Hippo hippo = new Hippo(
                "pic_hippo",
                Hunger.MID,
                new Boundaries(100,200),
                new Location(111,222)
        );

        vet.giveShot(dog);
        vet.giveShot(hippo);
    }
}
