package typical.array;

import java.util.*;

public class 最长等差数组 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>(); // 值,差，个数
        int res=1;
        for(int i=0;i<n;i++){
            map.put(arr[i],new HashMap<>());
            map.get(arr[i]).put(0,1);
            for(int j=i-1;j>=0;j--){
                int diff = arr[i]-arr[j];
                if(map.get(arr[j]).containsKey(diff)){
                    map.get(arr[i]).put(diff,map.get(arr[j]).get(diff)+1);
                    res = Math.max(res,map.get(arr[i]).get(diff));
                }else{
                    map.get(arr[i]).put(diff,2);
                    res = Math.max(res,2);
                }
            }
        }
        String[] mp = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};



        System.out.println(res);
    }
}
