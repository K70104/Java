package thread;

class Singleton2 {
    // 1．就不是立即就初始化实例.
    private static volatile Singleton2 instance = null;

    // 2．把构造方法设为 private
    private Singleton2() {}

    // 3．提供一个方法来获取到上述单例的实例
    //    只有当真正需要用到这个实例的时候，才会真正去创建这个实例
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) { // 类对象作为锁对象*
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}



public class demo2 {

}
