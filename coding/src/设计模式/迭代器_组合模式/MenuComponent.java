package 设计模式.迭代器_组合模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/10/28 21:55
 * @Version 1.0
 */
public abstract class MenuComponent {
    public void add(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent){
        throw  new UnsupportedOperationException();
    }
    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }
    public String getName(){
        throw new UnsupportedOperationException();
    }
    public void print(){
        throw new UnsupportedOperationException();
    }
}

class MenuItem extends MenuComponent{
    String name;
    public MenuItem(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void print(){
        System.out.println("Item: "+name);
    }
}

class Menu extends MenuComponent{

    List<MenuComponent> list;
    String name;

    public Menu(String name){
        this.name = name;
        list = new ArrayList<>();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        list.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        list.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return list.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        Iterator<MenuComponent> iter = list.iterator();
        while(iter.hasNext()){
            MenuComponent m = iter.next();
            m.print();
        }
    }
}


