package typical.string;

import java.util.Arrays;

/**
 * @Author: ly
 * @Date: 2020/7/20 16:13
 * @Version 1.0
 */
public class 交换位得到_大于给定值的最小值 {

    /**
     * 2 5 4 3 2 1 -> 3 1 2 2 4 5
     */
    private static String getMinMax(String str){
        char[] sc = str.toCharArray();
        int n = sc.length-1;
        int hi = n-1;
        while(hi>=0){
            if(sc[hi]<sc[hi-1]){
                break;
            }
            hi--;
        }
        if(hi>=0){
            // 对sc的fromIdx 到toIdx-1排序， toIdx不参与排序
            Arrays.sort(sc,hi+1,n+1);
        }
        for(int i=hi+1;i<n;i++){
            if(sc[i]>sc[hi]){
                char t = sc[hi];
                sc[hi] = sc[i];
                sc[i] = t;
                break;
            }
        }
        return new String(sc);
    }
    public static void main(String[] args) {
        String s = getMinMax("254321");
        System.out.println(s);
    }
}
