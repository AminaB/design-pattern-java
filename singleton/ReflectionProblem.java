package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionProblem {
    public static void main(String[] args) {
        DateUtil instance1= DateUtil.getInstance();
        DateUtil instance2= null;
        Constructor[] constructors=DateUtil.class.getDeclaredConstructors();
        for (Constructor c: constructors) {
            c.setAccessible(true); // with that, now we cn access private constructor
            try {
               instance2= (DateUtil) c.newInstance();
               break;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

        // test with ENAM Singleton
        EnumSingletonDemo instance= EnumSingletonDemo.INSTANCE;
        System.out.println(instance.getName());
        instance.setName("aminatou");
        System.out.println(instance.getName());
    }
}
// to fix reflection problem, use ENUM, they do not have constructor
