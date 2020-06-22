package 百度之星;

import java.util.*;

public class _2019 {

}

class _2019_2{
    //https://blog.csdn.net/qq_41505957/article/details/99701167
    //1002 Game 区间
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int  n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
            }
            int l=a[0],r=b[0];
            int i=1;
            while(i<n){
                if(Math.max(l,a[i])>Math.min(r,b[i])){
                    break;
                }
                l=Math.max(l,a[i]);
                r = Math.min(r,b[i]);
                i++;
            }
            if(i==n){  // 全部相交
                System.out.println(0);
                continue;
            }
            int s=0;
            if(b[i]>r){ // 下一个任务在 相交区间的右边
                s=r;
            }else{
                s=l;
            } // 确定了初始位置;
            int ans=0,tp=0;
            for(;i<n-1;i++){
                boolean f = (b[i] - a[i]) >= 1;
                if(s>b[i]){ // 下一个任务位于 左侧
                    if(tp==-1){
                        s--;      // 继续向左走一步，因为上一个任务只走了1步，且该任务同样在左边；尽可能往左走
                    }
                    ans += (s-b[i]+1)/2 ; // 无论距离是单或双 指步数
                    if((s-b[i])%2==1&& f){ // 距离是单
                        tp=-1;
                    }else tp=0;
                    s = b[i]; // 暂且放置该位置，如果下一个任务还是在左边且，该步只走了一个单位，则tp=-1
                }else if(s<a[i]){
                    if(tp==1){
                        s++;
                    }
                    ans +=(a[i]-s+1)/2;
                    if((a[i]-s)%2==1&& f){
                        tp=1;
                    }else tp=0;
                    s=a[i];
                }else{ // s 位于任务之中;跳过该任务，执行下一个任务，并处理tp
                    if(s==a[i]&&tp==-1){ // 上一个向左移动了一个位置
                        tp=0; // 不能再往左移动了，位于当前任务的边界；
                    }else if(s==b[i]&&tp==1)
                        tp=0;
                }
            }
            //处理最后一个任务;
            if(s>b[i]){ // 可以放入到上面for循环中
                if(tp==-1){
                    s--;
                }
                ans +=(s-b[i]+1)/2;
            }else if(s<a[i]){
                if(tp==1)
                    s++;
                ans +=(a[i]-s+1)/2;
            }
            System.out.println(ans);
        }
    }
}
