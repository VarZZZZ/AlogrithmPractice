package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello First test");
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
