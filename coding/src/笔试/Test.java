package 笔试;

/**
 * @Author: ly
 * @Date: 2020/7/7 21:12
 * @Version 1.0
 */
public class Test {
    public static String binSearch (int[] arr, int key) {
        // write code here


        return dfs(arr,0,arr.length-1,key,1);
    }
    private static String dfs(int[] arr,int l,int r,int key,int cnt){
        if(l==r&&arr[l]==key){
            return l+","+cnt;
        }
        int m = (l+r)/2;
        cnt++;
        if(arr[m]>key){
            return dfs(arr,l,m-1,key,cnt);
        }else if(arr[m]<key){
            return dfs(arr,m+1,r,key,cnt);
        }else{
            return l+","+cnt;
        }

    }

    public static void main(String[] args) {
        int[] arr =new int[]{3,4,5,6,7,9};
        String a = binSearch(arr,6);
        System.out.println(a);
    }
}
