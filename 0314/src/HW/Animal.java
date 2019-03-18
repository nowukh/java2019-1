package HW;


public class Animal {
    private String picture;
    private Food food;
    private Hunger hunger;
    private Boundaries boundaries;
    private Location location;


    public Animal(String picture, Food food, Hunger hunger, Boundaries boundaries, Location location) {
        this.picture = picture;
        this.food = food;
        this.hunger = hunger;
        this.boundaries = boundaries;
        this.location = location;
    }

    //methods

    public void makeNoise(){
        System.out.println("animal makeNoise");
    }

    public void eat(){
        System.out.println("animal eat");
    }

    public void sleep(){
        System.out.println("animal sleep");
    }

    public void roam(){
        System.out.println("animal roam");
    }

    //getter and setter

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Hunger getHunger() {
        return hunger;
    }

    public void setHunger(Hunger hunger) {
        this.hunger = hunger;
    }

    public Boundaries getBoundaries() {
        return boundaries;
    }

    public void setBoundaries(Boundaries boundaries) {
        this.boundaries = boundaries;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    //tostring


    @Override
    public String toString() {
        return "picture='" + picture + '\'' +
                ", food=" + food +
                ", hunger=" + hunger +
                ", boundaries=" + boundaries +
                ", location=" + location ;
    }
}

