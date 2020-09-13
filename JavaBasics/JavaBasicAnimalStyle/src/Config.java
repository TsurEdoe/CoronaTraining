import Animals.*;
import Annotations.Configuration;
import Annotations.Seed;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class Config {
    // a cooler naming system
    private String[] animalNames;

    public Config() {
        this.animalNames = new String[]{"Bono","Leon","Chupchick","Snow","Poonch"};
    }

    @Seed
    public Dog getDog(){
        System.out.println("dog is annotated with: " + Arrays.asList(Dog.class.getDeclaredAnnotations()));
        return new Dog();
    }

    @Seed
    public Cat getCat(){
        return new Cat();
    }


    /**
     *
     * @return a random name from the animals array
     */
    @Seed
    public String getName(){
        return this.animalNames[ThreadLocalRandom.current().nextInt(0, animalNames.length)];
    }
}
