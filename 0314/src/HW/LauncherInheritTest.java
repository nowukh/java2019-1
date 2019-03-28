package HW;

public class LauncherInheritTest {
    public static void main(String[] args) {
        Animal hippo = new Hippo(
                "pic_hippo",
                Hunger.MID,
                new Boundaries(100,200),
                new Location(111,222));

        System.out.println("before: " + hippo.getFood());
        hippo.setFood(Food.GRASS);
        System.out.println("after: " + hippo.getFood());

    }
}
