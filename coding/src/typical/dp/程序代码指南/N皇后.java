package typical.dp.程序代码指南;

public class N皇后 {

    private int num1(int n ){
        if(n<1) return 0;
        int[] record = new int[n];
        return process1(record,0,n);
    }

    private int process1(int[] record,int i,int n){
        if(i==n) return 1;
        int res = 0;
        for(int j=0;j<n;j++){     // 表示判断arr[i][j]加入后是否合法
            if(isValid(record,i,j)){
                record[i]=j;
                res+=process1(record,i+1,n);
            }
        }
        return res;
    }
    private boolean isValid(int[] record,int i,int j){
        for(int k=0;k<i;k++){
            if(record[k]==j||Math.abs(record[k]-j)==Math.abs(i-k)){
                return false;
            }
        }
        return true;
    }

}
