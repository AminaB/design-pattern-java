package singleton;

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