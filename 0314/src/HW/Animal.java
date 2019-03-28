package HW;


public abstract class Animal {
    public String picture;
    private Food food;
    public Hunger hunger;
    public Boundaries boundaries;
    public Location location;


    //methods

    public void makeNoise(){

    }

    public void eat(){

    }

    public void sleep(){

    }

    public void roam(){

    }
    private void privateMethod(){
        System.out.println("this is private");
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}

