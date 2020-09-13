import Animals.*;
import Annotations.Test;
import Annotations.Wired;

public class AnimalTester {
    @Wired
    private Cat cat;
    @Wired
    private Dog dog;

    @Test
    public void checkAnimalsEndlessLove() {
        for (Animal animal : new Animal[]{cat,dog}) {
            System.out.print(animal.getName() + " : ");
            animal.endlessLove();
        }
    }

    @Test
    public void checkAnimalsSpeak() {
        for (Animal animal : new Animal[]{cat,dog}) {
            System.out.println(animal.getName() + " say " + animal.speak());
        }
    }
}
