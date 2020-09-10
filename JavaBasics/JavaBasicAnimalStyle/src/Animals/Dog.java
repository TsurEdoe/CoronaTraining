package Animals;

import java.security.PublicKey;

public class Dog implements Animal {
    private String name;

    public Dog(String name){
        this.name = name;
    }

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
