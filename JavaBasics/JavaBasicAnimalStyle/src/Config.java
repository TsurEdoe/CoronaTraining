import Animals.*;
import Annotations.Configuration;
import Annotations.Seed;

@Configuration
public class Config {
    @Seed
    public Dog getDog(){
        return new Dog("Bono");
    }

    @Seed
    public Cat getCat(){
        return new Cat("Leon");
    }

    @Seed
    public Animal[] getAnimals(){
        return new Animal[]{new Dog("Bono"),new Dog("ChupChick"),new Cat("Leon")};
    }
}
