package 设计模式;

public class 单例模式 {
}

// 饿汉式
class HungrySingleInstance{
    private static final HungrySingleInstance instance = new HungrySingleInstance();

    // 利用私有构造器覆盖
    private HungrySingleInstance(){
    }

    public static HungrySingleInstance getInstance(){
        return instance;
    }
}

// 懒汉式
class LazySingleInstance{
    private static volatile LazySingleInstance instance = null; // 需要加上volatile；禁止重排序
    private LazySingleInstance(){
    }
    public static LazySingleInstance getInstance(){
        if(null==instance){
            synchronized (LazySingleInstance.class){
                if(null==instance){
                    instance = new LazySingleInstance();
                }
            }
        }
        return instance;
    }
}
