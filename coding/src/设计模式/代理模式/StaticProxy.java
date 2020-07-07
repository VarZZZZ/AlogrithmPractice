package 设计模式.代理模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/7/6 20:57
 * @Version 1.0
 * 可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 编程中的一个思想:不要随意去修改别人已经写好的代码或者方法,如果需改修改,可以通过代理的方式来扩展该方法
 */
public class StaticProxy {
}


interface UserDaoInterface{
    void save();
}

class UserDao implements UserDaoInterface{
    @Override
    public void save() {
        System.out.println("saved");
    }
}

class UserDaoProxy implements UserDaoInterface{
    private UserDaoInterface userDao;
    UserDaoProxy(UserDaoInterface target){
        userDao = target;
    }
    @Override
    public void save() {
        userDao.save();
    }
}
