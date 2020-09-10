import Annotations.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ApplicationContext {

    private AnimalTester tester; //will be used to test all the Animals
    private Config config; //will be used to config all the Dependencies

    public ApplicationContext() {
        config = new Config();
        tester = new AnimalTester();
    }

    /**
     * @param type -> type of seed to invoke
     * @return New object from Config
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private Object getSeed(Class<?> type) throws InvocationTargetException, IllegalAccessException {
        for (Method method : this.config.getClass().getDeclaredMethods()) {
            //If a method is annotated with the Seed annotation
            //and return the dependecy type in need, invoke it.
            if ((method.getAnnotation(Seed.class) != null) &&
                    method.getReturnType().equals(type)) {
                return type.cast(method.invoke(config));
            }
        }
        System.out.println("Nope");
        return null;
    }

    /**
     * Invokes every method with the Test annotation
     * in tester object using reflection.
     *
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private void invokeAllTests() throws InvocationTargetException, IllegalAccessException {
        for (Method method : this.tester.getClass().getDeclaredMethods()) {
            if (method.getAnnotation(Test.class) != null) {
                System.out.println("Invoking: " + method.getName());
                method.invoke(this.tester);
            }
        }
    }

    /**
     * Starting the Application.
     */
    public void startApplication() {
        try {
            System.out.println("LVL 1: Inject all dependencies to tester");
            injectDependencies();
            System.out.println("LVL 2: Run all tests");
            invokeAllTests();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inject dependencies to all tester fields with the annotation Wired.
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private void injectDependencies() throws InvocationTargetException, IllegalAccessException {
        Field[] fields = tester.getClass().getDeclaredFields();
        for (Field fi : fields) {
            if (fi.getAnnotation(Wired.class) !=  null){
                fi.setAccessible(true);
                fi.set(this.tester,getSeed(fi.getType()));
                System.out.println("Dependency Injected");
            }
        }
    }
}
