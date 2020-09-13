package Animals;

import Annotations.Wired;


@Wired
public class Dog implements Animal {
    @Wired
    private String name;

    @Override
    public void endlessLove() {
        System.out.println("IMAGOODBOY");
    }

    @Override
    public String speak() {
        return "Woff";
    }
    @Override
    public String getName() {
        return this.name;
    }
}
