package Animals;

public class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void endlessLove() {
        System.out.println("U May Rub My Beautiful Belly.");
    }

    @Override
    public String speak() {
        return "Meow";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
