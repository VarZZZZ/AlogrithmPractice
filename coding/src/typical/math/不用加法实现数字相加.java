package typical.math;

import java.util.HashMap;

/**
 * @Author: ly
 * @Date: 2020/8/7 17:13
 * @Version 1.0
 */
public class 不用加法实现数字相加 {
    public int add(int a, int b) {
        while(b!=0){ // b 进位
            int c = (a&b)<<1; // 获得所有进位 ;
            a ^=b;  // 非进位相加
            b=c;
        }
        return a;
    }
}
