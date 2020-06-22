package 笔试.vivo;

public class _2020_3 {
    //https://www.nowcoder.com/question/next?pid=22390442&qid=925106&tid=33852172
    public int solution (int n) {
        // write code here
        int size=0;
        int t = n;
        while(n>0){
            if((size=sqrt(n))>0) break;
            n--;
        }
        size = (size-1)/2;
        int sum = 0;
        for(int i=1;i<=size;i++){
            sum +=i*i;
        }
        sum += (t-n)*(size+1);
        return sum;
    }

    private int sqrt(int n){
        n = n*8+1;
        for(int i=2;i<n/2;i++){
            if(i*i==n) return i;
        }
        return -1;
    }
}
