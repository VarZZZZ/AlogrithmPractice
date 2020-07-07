package 设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/7/6 20:37
 * @Version 1.0
 */
public class ObserverModel {
}

// 主题和观察者之间的关系

// 抽象观察者
interface Observer{
    void update();
}

// 主题
class Subject{
    // 定义观察者数组
    private List<Observer> observers = new ArrayList<>();

    // 增加观察者
    public void addObserver(Observer o){
        this.observers.add(o);
    }
    // 删除
    public void deleteObserver(Observer o){
        this.observers.remove(o);
    }
    // 通知所有观察者
    public void notifyObserver(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

//具体主题
class ConcreteSubject extends Subject{
    public void doSomething(){
        super.notifyObserver();
    }
}

// 具体观察者
class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("收到消息");
    }
}

class Client{
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.addObserver(observer);

        subject.doSomething();
    }
}

