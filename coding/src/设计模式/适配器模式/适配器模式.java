package 设计模式.适配器模式;

/**
 * @Author: ly
 * @Date: 2020/8/20 21:34
 * @Version 1.0
 */
public class 适配器模式 {
    /*
     * 定义客户端使用的接口（目标），与业务相关
     */
    interface Target {
        /*
         * 客户端请求处理的方法
         */
        public void request();
    }

    /*
     * 已经存在的接口，这个接口需要配置
     */
    class Adaptee { // 被适配者
        /*
         * 原本存在的方法
         */
        public void specificRequest() {
            //业务代码
        }
    }

    /*
     * 适配器类
     */
    class Adapter implements Target {
        /*
         * 持有需要被适配的接口对象
         */
        private Adaptee adaptee;

        /*
         * 构造方法，传入需要被适配的对象
         * @param adaptee 需要被适配的对象
         */
        public Adapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void request() {
            // TODO Auto-generated method stub
            adaptee.specificRequest();
        }

    }

    /*
     * 使用适配器的客户端
     */
    class Client {
        void main(String[] args) {
            //创建需要被适配的对象
            Adaptee adaptee = new Adaptee();
            //创建客户端需要调用的接口对象
            Target target = new Adapter(adaptee);
            //请求处理
            target.request();
        }
    }

}

