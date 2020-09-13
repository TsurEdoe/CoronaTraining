package Animals;

import Annotations.Wired;

@Wired
public class Cat implements Animal {
    @Wired
    private String name;

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
