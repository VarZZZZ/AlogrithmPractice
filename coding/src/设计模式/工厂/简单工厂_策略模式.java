package 设计模式.工厂;

public class 简单工厂_策略模式 {
}


// 抽象产品
abstract class Car{
    private String name;
    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 具体产品
class Benz extends Car{

    @Override
    public void drive() {
        System.out.println(this.getName()+"-----go------");
    }
}
class Bmw extends Car{

    @Override
    public void drive() {
        System.out.println(this.getName()+"-----go------");
    }
}
//简单工厂
class Driver{
    public static Car createCar(String car){
        Car c = null;
        if("Benz".equalsIgnoreCase(car))
            c=new Benz();
        else if("Bmw".equalsIgnoreCase(car))
            c=new Bmw();
        return c;
    }
}

// 策略模式
class CarStrategyDriver{
    Car car = null;

    public CarStrategyDriver(Car car) {
        this.car = car;
    }
    public void drive(){
        this.car.drive();
    }
}

class SimplyFactory{
    public static void main(String[] args) {
        Car car = Driver.createCar("Benz");
        car.setName("benz");
        car.drive();
    }
}

// 策略模式
class StrategyFactory{
    public static void main(String[] args) {
        Car c = new Benz();
        CarStrategyDriver context = new CarStrategyDriver(c);
        context.drive();
    }
}