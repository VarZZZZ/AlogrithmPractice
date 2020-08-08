package typical.array_2;

/**
 * @Author: ly
 * @Date: 2020/8/7 16:34
 * @Version 1.0
 */
public class 约瑟夫环 {
    // list - 链表形式
    /**
     * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
     * 求出这个圆圈里剩下的最后一个数字。
     *
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
     * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     *
     */
    private int f(int n,int m){
        if(n==1) return 0;
        int x = f(n-1,m);
        return (m+x)%n;
    }

    public int yueshefu(int n, int m) {
        boolean[] f = new boolean[n];
        int cnt=n;
        int i=0; // 数组中的下标
        while(cnt!=1){
            int idx=0;  // 真实的计数
            while(idx!=m){
                if(!f[i]){
                    idx++;
                }
                i++;
                if(i==n) i=0;
            }
            if(i-1<0){
                f[n-1]=true;
            }else{
                f[i-1]=true;
            }
            cnt--;
        }
        for(i=0;i<n;i++){
            if(!f[i]) return i;
        }
        return -1;
    }
}
