package 笔试.pdd;

import java.util.Scanner;

public class _2020_1_math {
    //https://www.nowcoder.com/question/next?pid=23354036&qid=967827&tid=33825263
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String s = sc.nextLine();
        while(T-->0){
            int N = sc.nextInt();
            int res = 0;
            while(N>=1){
                N /=2;
                res++;
            }
            System.out.println(res);
        }

    }
}
