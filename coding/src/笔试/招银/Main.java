package 笔试.招银;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int k =sc.nextInt();
        int[] arr =new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int leftLen;
        leftLen=n/2;
        if(n%2==1){
            leftLen++;
        }
        int[] result = new int[n];
        for(int i=1;i<=k;i++){
            int l = leftLen-1;
            int r = n-1;
            int kk = n-1;
            if(i%2==1){
                while(l>=0&&r>=leftLen){
                    result[kk--]=arr[r];
                    result[kk--]=arr[l];
                    l--;
                    r--;
                }
            }else{
                while(l>=0&&r>=leftLen){
                    result[kk--]=arr[l];
                    result[kk--]=arr[r];
                    l--;
                    r--;
                }
            }
            if(l>=0){
                result[0]=arr[0];
            }
            if(r>=leftLen){
                result[0]=arr[0];
            }
            for(int j=0;j<n;j++){
                arr[j]=result[j];
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(result[i]+" ");
        }
    }
}
