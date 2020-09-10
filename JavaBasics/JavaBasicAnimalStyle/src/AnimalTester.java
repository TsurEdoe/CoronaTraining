import Animals.Animal;
import Annotations.Test;
import Annotations.Wired;

public class AnimalTester {
    @Wired
    private Animal[] animals;

    @Test
    public void checkAnimalsEndlessLove() {
        for (Animal animal : animals) {
            System.out.print(animal.getName() + " : ");
            animal.endlessLove();
        }
    }

    @Test
    public void checkAnimalsSpeak() {
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " say " + animal.speak());
        }
    }
}
