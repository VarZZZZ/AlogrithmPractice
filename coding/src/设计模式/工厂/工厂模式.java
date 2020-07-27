package 设计模式.工厂;

public class 工厂模式 {
}

// 抽象产品
abstract class Car_{
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
class Benz_ extends Car_{

    @Override
    public void drive() {
        System.out.println(this.getName()+"-----go------");
    }
}
class Bmw_ extends Car_{

    @Override
    public void drive() {
        System.out.println(this.getName()+"-----go------");
    }
}
//抽象工厂
abstract class Driver_{
    public abstract Car_ createCar(String car);
}
//具体工厂
class BenzDriver extends Driver_{

    @Override
    public Car_ createCar(String car) {
        return new Benz_();
    }
}
class BmwDriver extends Driver_{

    @Override
    public Car_ createCar(String car) {
        return new Bmw_();
    }
}

// 相较于简单工厂模式而言，没有if判断
class Boss{
    public static void main(String[] args) {
        Driver_ d = new BenzDriver();
        Car_ c = d.createCar("benz");
        c.setName("benz");
        c.drive();
    }
}
