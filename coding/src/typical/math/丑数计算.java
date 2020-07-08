package typical.math;

/**
 * @Author: ly
 * @Date: 2020/7/7 23:00
 * @Version 1.0
 */

/**
 * 丑数
 * 只包含2、3、5因子的数被称为丑数，如1,2,3,4,5,6,8；14不是，它包含7；
 */
class 丑数计算{
    //求第idx个丑数
    public int GetUglyNumber(int idx){
        if(idx<7) return idx;
        int[] ugly = new int[idx];
        ugly[0] = 1;
        int min = 1;
        int m2 = 0;
        int m3=0;
        int m5=0;
        for(int i=1;i<idx;i++){ // 每一个丑数，都得经过*2，*3，*5各一次。
            ugly[i] = Math.min(ugly[m2] * 2,Math.min(ugly[m3] * 3,ugly[m5] * 5));
            if(ugly[i] == ugly[m2]*2){
                m2++;
            }
            if(ugly[i] == ugly[m3]*3){
                m3++;
            }
            if(ugly[i] == ugly[m5]*5){
                m5++;
            }
        }
        return ugly[idx-1];
    }
}

