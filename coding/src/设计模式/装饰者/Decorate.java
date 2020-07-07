package 设计模式.装饰者;

/**
 * @Author: ly
 * @Date: 2020/7/6 20:45
 * @Version 1.0
 * 装饰者  new ADDMore(new Base());  ->大概
 */
public class Decorate {
}

// 用于IO 流和spark rdd

// 定义加料的接口
interface NoodleDecorate{
    void addThings();
}
// 定义基本的面条类 (在面条之上装饰)
class Noodle implements NoodleDecorate{

    @Override
    public void addThings() {
        System.out.println("添加面条");
        System.out.println("添加肉末");
    }
}
class ChildNoodle implements NoodleDecorate{
    private Noodle noodle;
    public ChildNoodle(Noodle noodle){
        this.noodle=noodle;
    }

    @Override
    public void addThings() {
        noodle.addThings(); // 在他的基础之上添加
        System.out.println("添加辣椒");
    }
}
class Test{
    public static void main(String[] args) {
        new ChildNoodle(new Noodle()).addThings();
    }
}



