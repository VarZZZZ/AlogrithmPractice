package 笔试;

import java.util.*;

//为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，
//        对于一类文章，每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，
//        有多少用户对这类文章喜好值为k。因为一些特殊的原因，
//        不会出现一个查询的用户区间完全覆盖另一个查询的用户区间(不存在L1<=L2<=R2<=R1)。
public class ByteDance_2018_2_1 {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] like = new int[n];
        for(int i=0;i<n;i++){
            like[i] = sc.nextInt();
            if(!mp.containsKey(like[i])){
                List<Integer> ls = new ArrayList<>();
                ls.add(i+1);
                ls.add(1);
                mp.put(like[i],ls);
            }else{
                int tp = mp.get(like[i]).size()/2;
                mp.get(like[i]).add(i+1);
                mp.get(like[i]).add(tp+1);
            }
        }
        int q = sc.nextInt();
        for(int i=0;i<q;i++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> re = mp.get(k);
            int lsize=0;
            int rsize=0;
            for(int j=0;j<re.size()-1;j+=2){
                if(re.get(j)>=l){
                    lsize=re.get(j+1);
                    break;
                }
            }
            if(lsize==0)
            {
                System.out.println(0);
                continue;
            }
            for(int j=re.size()-2;j>=0;j-=2){
                if(re.get(j)<=r){
                    rsize=re.get(j+1);
                    break;
                }
            }
            if(rsize==0) {
                System.out.println(0);
                continue;
            }
            System.out.println(rsize-lsize+1);
        }
    }
}
