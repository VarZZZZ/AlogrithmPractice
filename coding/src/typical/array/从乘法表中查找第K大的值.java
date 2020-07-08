package typical.array;

import java.util.Scanner;

public class 从乘法表中查找第K大的值 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        k = n*m-k+1;
        int low = 1;
        int high = n*m; // low  high 是值
        while(low<high){
            int mid = (low+high)/2;
            int cnt = count(n,m,mid);
            if(cnt>=k){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        System.out.println(low);
    }
    public static int count(int n,int m,int mid){
        int cnt = 0;
        for(int i=1;i<=n;i++){
            cnt += Math.min(m,mid/i);
        }
        return cnt;
    }
}
