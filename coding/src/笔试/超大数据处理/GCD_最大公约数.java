package 笔试.超大数据处理;

import java.util.Scanner;

public class GCD_最大公约数 {
    // a 范围超大，超过了long类型；
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        long b = sc.nextLong();
        long ans = demo(a,b);
        if(ans==0){
            System.out.println(b);
            return;
        }
        System.out.println(gcd(ans,b));
    }
    private static long demo(String a,long b){
        long remain = 0;
        for(int i=0;i<a.length();i++){
            remain = remain*10+ a.charAt(i)-'0';
            remain %=b;
        }
        return remain;
    }
    private static long gcd(long a,long b){
        if(a<b){
            long t = a;
            a = b;
            b = t;
        }
        while(b!=0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
