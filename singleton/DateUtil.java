package singleton;

import java.io.Serializable;

public class DateUtil {
    private static  DateUtil instance;
    private DateUtil(){
    }
    public static DateUtil getInstance(){
        if(instance==null){
            instance= new DateUtil();
        }
        return  instance;
    }
}
// using instantiation
class DateUtil2 {
    private static  DateUtil2 instance= new DateUtil2();
    private DateUtil2(){
    }
    public static DateUtil2 getInstance(){
        return  instance;
    }
}

// using static bloc
class DateUtil3 {
    private static  DateUtil3 instance;
    static {
        instance= new DateUtil3();
    }
    private DateUtil3(){
    }
    public static DateUtil3 getInstance(){
        return  instance;
    }
}

// make it thread safe and serialization problem
// Cloneable avoid cloning object
class DateUtil4 implements Serializable, Cloneable {
    //volatile It prevents threads from caching the variable locally
    private static  volatile DateUtil4 instance;

    private DateUtil4(){
    }
    public static DateUtil4 getInstance(){
        if(instance==null){
            synchronized (DateUtil4.class) {
                if(instance==null) {
                    instance = new DateUtil4();
                }
            }
        }
        return  instance;
    }
    protected Object readResolve(){
        return instance;
    }

    @Override
    public DateUtil4 clone() throws CloneNotSupportedException {
       throw new CloneNotSupportedException();
    }
}