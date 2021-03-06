package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println(s2);//计算机
        System.out.println(s1 == s2);//false，因为一个是堆内存中的String对象一个是常量池中的String对象，
        System.out.println(s3 == s2);//true，因为两个都是常量池中的String对象
    }

    public int nextGreaterElement(int n) {
        String ns = String.valueOf(n);
        char[] nsc = ns.toCharArray();
        char min = nsc[nsc.length-1];
        int idx=0;
        for(int i=nsc.length-2;i>=0;i--){
            if(nsc[i]<min){
                char t = nsc[i];
                nsc[i] = min;
                nsc[0] = t;
                return Integer.parseInt(Arrays.toString(nsc));
            }
        }
        return -1;

    }
}
