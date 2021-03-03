package typical.bigdata;

import java.util.BitSet;

/**
 * @Author: ly
 * @Date: 2020/8/10 22:25
 * @Version 1.0
 */
public class 布隆过滤器_黑名单 {
    private static final int SIZE = 1 << 24;
    private static final BitSet bitset = new BitSet();

    //    计算hash值的辅助数组
    static final int[] seeds= {2, 3, 5, 7, 11, 13, 17, 19};

    //获取hash值
    public static int getHash(String data,int seed){
        int hash = 0;
        char arrChar[] = data.toCharArray();
        if (arrChar.length>0){
            for (int i = 0;i<arrChar.length;i++){
                hash = hash*seed+arrChar[i];//自定义hash算法
            }
        }
        return hash&(SIZE-1);
    }

    //  过滤  查找是否存在
    public static boolean isExist(String data){
        if(data==null&&data.length()==0){
            return false;
        }
        boolean res = true;
        for (int i = 0;i<seeds.length;i++){
            int index = getHash(data,seeds[i]);
            res&=bitset.get(index);//与运算，只要有有一个位置为null就false
        }
        return res;
    }
    //    标识  bitset置位
    public static void add(String data){
        for (int i = 0;i<seeds.length;i++){
            int  hash = getHash(data,seeds[i]);
            bitset.set(hash,true);
        }

    }

    public static void main(String[] args) {
        System.out.println(isExist("111111"));//false
        add("111111");
        System.out.println(isExist("111111"));//true

        System.out.println(isExist("1111112"));//false
        add("1111112");
        System.out.println(isExist("1111112"));//true


    }

}
