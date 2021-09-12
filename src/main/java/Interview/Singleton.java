package Interview;

/**
 * @author: gefeng
 * @created: 2021/08/22 16:18
 */
public class Singleton {
    private static volatile Singleton INSTANCE = null;
    private Singleton(){};

    public static Singleton getInstance() {
        Singleton result = INSTANCE;
        if (result == null) {
            synchronized (Singleton.class) {
                result = INSTANCE;
                if (result == null) {
                    INSTANCE = result = new Singleton();
                }
            }
        }
        return result;
    }

}
