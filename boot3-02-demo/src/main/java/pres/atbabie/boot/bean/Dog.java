package pres.atbabie.boot.bean;

public class Dog {
    private String name;
    private boolean eating;

    public Dog() {
    }

    public Dog(String name, boolean eating) {
        this.name = name;
        this.eating = eating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEating() {
        return eating;
    }

    public void setEating(boolean eating) {
        this.eating = eating;
    }
}
