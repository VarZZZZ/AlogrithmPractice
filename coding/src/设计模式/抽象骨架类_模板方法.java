package 设计模式;

/**
 * @Author: ly
 * @Date: 2020/10/14 20:56
 * @Version 1.0
 */
public class 抽象骨架类_模板方法 {


}

interface IAndroidPhone {
    void powerOn();

    void setVolume(int volume);

    void downloadApp(String appName);
}

// 抽象骨架类
abstract class AbstractIAndroidPhone implements IAndroidPhone {
    private int volume;

    @Override
    public void powerOn() {
        System.out.println("长按开机");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("音量调节为" + this.volume);
    }

    public int getVolume() {
        return volume;
    }
//        @Override // 根据子类不同而实现不同方法
//        public void downloadApp(String appName) {
//        }
}

class SamsungPhone implements IAndroidPhone {

    private final SamsungPhoneImp s = new SamsungPhoneImp();

    @Override
    public void powerOn() {
        s.powerOn();
    }

    @Override
    public void setVolume(int volume) {
        s.setVolume(volume);
    }

    @Override
    public void downloadApp(String appName) {
        s.downloadApp(appName);
    }

    // 私有类，组合由于继承
    private static class SamsungPhoneImp extends AbstractIAndroidPhone {
        @Override
        public void downloadApp(String appName) {
            System.out.println("SamsungPhone downloading");
        }
    }

}
