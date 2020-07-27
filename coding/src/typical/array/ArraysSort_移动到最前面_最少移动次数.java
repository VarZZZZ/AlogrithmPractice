package typical.array;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort_移动到最前面_最少移动次数 {

    /** 排序
     * （1）每次只能交换两个元素；
     * （2）每次只能把元素移到第一个位置；
     * 最小排序次数
     */

    /**
     * 原数组逐个与有序序列比对，如果不在自己本该的在的位置上，就交换一次；
     */
    private int num1(int[] a){
        int sum=0,ans=0;
        int n = a.length;// 此处假定arr数字为1-n
        for(int i=1;i<=n;i++)
        {
            if(i!=a[i])
            {
                int temp=i;
                ans=0;
                while(i!=a[temp])//逐步交换
                {
                    int t=temp;
                    temp=a[temp];
                    a[t]=t;
                    ans++;
                }
                a[temp]=temp;
                sum+=ans;
            }
        }
        return sum;
    }

    /**
     * 2）每次只能把元素移到第一个位置；
     */
    private int sortNum(int[] arr){
        int[] b = Arrays.copyOf(arr,arr.length);
        Arrays.sort(b);
        int pa=0,pb=0,ans=0;
        int n  =arr.length;
        for(pa=n-1,pb=n-1;pa>=0;){
            if(arr[pa]==b[pb]){
                pa--;
                pb--;
            }else{
                ans++;
                pa--; // 原数组左移
            }
            if(pa<0) break;
        }
        return ans;
    }




}
