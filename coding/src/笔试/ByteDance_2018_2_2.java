package 笔试;

import java.util.*;

//作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串——每个串珠要么无色，
//        要么涂了若干种颜色。为了使手串的色彩看起来不那么单调，
//        金主要求，手串上的任意一种颜色（不包含无色），
//        在任意连续的m个串珠里至多出现一次（注意这里手串是一个环形）。
//        手串上的颜色一共有c种。现在按顺时针序告诉你n个串珠的手串上，
//        每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种颜色不符合要求。
//        即询问有多少种颜色在任意连续m个串珠中出现了至少两次。
public class ByteDance_2018_2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            int num_i = sc.nextInt();
            for(int j=0;j<num_i;j++){
                int cj = sc.nextInt();
                if(!mp.containsKey(cj)){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    mp.put(cj,ls);
                }else{
                    mp.get(cj).add(i);
                }
            }
        }
        int res = 0;
        for(List<Integer> r:mp.values()){
            Collections.sort(r);
            for(int i=0;i<r.size()-1;i++){
                if(r.get(i+1)-r.get(i)<m){
                    res++;
                    break;
                }
            }
            if(n-r.get(r.size()-1)+r.get(0)<m) res++;
        }
        System.out.println(res);


    }
}
