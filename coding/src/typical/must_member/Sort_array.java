package typical.must_member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort_array {
    //https://blog.csdn.net/weixin_41190227/article/details/86600821

    //冒泡排序
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }


    // 希尔排序
    private int[] shellSort(int[] array) {
        int len = array.length;
        int gap = len / 2;
        int tmp = 0;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                tmp = array[i];
                int pre_idx = i - gap;
                while (pre_idx >= 0 && array[pre_idx] > tmp) { // 同样是插入排序
                    array[pre_idx + gap] = array[pre_idx];
                    pre_idx -= gap;
                }
                array[pre_idx + gap] = tmp;
            }
            gap /= 2;
        }
        return array;
    }

    // 归并排序
    private int[] mergeSort(int[] array){
        if (array.length<2) return array;
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,array.length);
        return merge(mergeSort(left),mergeSort(right)); // merge()方法需要参数数组有序，所以，需要再次meregSort
    }
    private int[] merge(int[] left,int[] right){
        int[] result =  new int[left.length+right.length];
        for(int idx = 0,i=0,j=0;idx<result.length;idx++){
            if(i>=left.length){
                result[idx]=right[j++];
            }else if(j>=right.length){
                result[idx]=left[i++];
            }else if(left[i]>right[j]){
                result[idx]=right[j++];
            }else
                result[idx]=left[i++];
        }
        return result;
    }

    //两路归并算法，一个排好序的子序列合并为一个子序列
    public void merge(int []a,int left,int mid,int right){
        int []tmp=new int[a.length];//辅助数组
        int p1=left,p2=mid+1,k=left;//p1、p2是检测指针，k是存放指针
        while(p1<=mid && p2<=right){
            if(a[p1]<=a[p2])
                tmp[k++]=a[p1++];
            else
                tmp[k++]=a[p2++];
        }
        while(p1<=mid) tmp[k++]=a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2<=right) tmp[k++]=a[p2++];//同上

        //复制回原素组
        for (int i = left; i <=right; i++)
            a[i]=tmp[i];
    }
    public void mergeSort(int [] a,int start,int end){
        if(start<end){//当子序列中只有一个元素时结束递归
            int mid=(start+end)/2;//划分子序列
            mergeSort(a, start, mid);  //对左侧子序列进行递归排序，得到排好序的左边
            mergeSort(a, mid+1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并 两个排好序列的
        }
    }


    //快速排序
    private int[] quickSort(int[] array,int start,int end){
        if(start < 0 || end >= array.length || start > end) return null;
        int idx = partition(array,start,end);
        if(start<idx){
            quickSort(array,start,idx); // 返回start-idx排好序的数组
        }
        if(idx<end){
            quickSort(array,idx+1,end); // 返回idx+1-end排好序的数组
        }
        return array;
    }
    private int partition(int[] array,int lo,int hi){
        int pivot = (int)(lo+Math.random()*(hi-lo));
        int tt = array[pivot];
        array[pivot] = array[lo];
        array[lo]=tt;
        int i = lo,j = hi;
        while(i<j){
            while(i<j&&array[j]>=tt) j--;
            while(i<j&&array[i]<=tt) i++; // i是第二个
            if(i>=j) break;
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
        array[lo] = array[i];
        array[i] = tt;
        return i;
    }
    private void swap(int[] array,int a,int b){
        int tp = array[a];
        array[a]=array[b];
        array[b] = tp;
    }

    // 堆排序  o(nlogn)
    private int[] heapSort(int[] array){ // 建立大根堆 从而从小到大排序数组
        int len = array.length;
        if(len<1) return array;
        buildMaxHeap(array);
        while(len>0){
            swap(array,0,len-1);
            len--;
            adjustHeap(array,0);
        }
        return array;
    }

    private void buildMaxHeap(int[] array){
        for(int i=(array.length-1)/2;i>=0;i--){
            adjustHeap(array,i);
        }
    }
    private void adjustHeap(int[] array,int idx){ // 应该再传一个参数len,表示数组的长度
        int maxIdx = idx;
        if(idx*2+1<array.length&&array[idx*2+1]>array[maxIdx])
            maxIdx=idx*2+1;
        if(idx*2+2<array.length&&array[idx*2+2]>array[maxIdx])
            maxIdx=idx*2+2;
        if(maxIdx!=idx){
            int tp = array[maxIdx];
            array[maxIdx]=array[idx];
            array[idx]=tp;
            adjustHeap(array,maxIdx);
        }
    }

    // 计数排序-》分桶 类似于bit map;适合于整型;没有用到比较，属于非比较排序;一个桶就是一个数字value
    private int[] countingSort(int[] array){
        int bias,min = array[0],max=array[0];
        for(int a:array){
            if(min>a)
                min = a;
            if(max<a)
                max=a;
        }
        bias = 0-min;
        int[] bucket = new int[max-min+1]; // 桶： 最大最小值的差值
        for(int a:array){
            bucket[a+bias]++;  // 桶计数
        }
        int idx=0;
        int i=0;
        while(idx<array.length){
            if(bucket[i]>0){
                array[idx]=i-bias;
                bucket[i]--;
                idx++;
            }else
                i++;
        }
        return array;
    }

    //桶排序 - 计数排序的升级版-》桶的个数减少了
    private List<Integer> bucketSort(List<Integer> array,int bucketSize){
        if(array==null||array.size()<2) return array;
        int max = array.get(0),min = array.get(0);
        for(int a:array){
            if(min>a)
                min = a;
            if(max<a)
                max=a;
        }
        int bucketCnt = (max-min)/bucketSize +1;
        List<List<Integer>> bucketArr = new ArrayList<>(bucketCnt);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<bucketCnt;i++){
            bucketArr.add(new ArrayList<>());
        }
        for(int a:array){
            bucketArr.get((a-min)/bucketSize).add(a);
        }
        for(int i=0;i<bucketCnt;i++){
            if(bucketSize==1){//计数排序，桶中的数组是重复的，不用再桶内排序
                res.addAll(bucketArr.get(i));
            }else{
                if(bucketCnt==1) // 全在一个桶内；
                    bucketSize--; // 减少size,增大桶数
                List<Integer> tp = bucketSort(bucketArr.get(i),bucketSize);
                res.addAll(tp);
            }
        }
        return res;
    }

    // 基数排序  非比较 ：10个桶，重复使用
    private int[] radixSort(int[] array){
        int max =0;
        for(int a :array){
            if(a>max) max = a;
        }
        int maxDigit = 0;
        while(max>0){
            max/=10;
            maxDigit++;
        }
        List<List<Integer>> bucket = new ArrayList<>(10);//10个桶
        for(int i=0;i<10;i++){
            bucket.add(new ArrayList<>());
        }
        int mod=10,div=1;
        for(int i=0;i<maxDigit;i++,mod*=10,div*=10){ // 循环-最大位数次
            for(int j=0;j<array.length;j++){
                int n = (array[j]%mod) /div;
                bucket.get(n).add(array[j]);
            }
            int idx=0;
            for(List<Integer> b:bucket){
                if(b.size()>0){
                    for(int bb:b){
                        array[idx]=bb;
                        idx++;
                    }
                }
                b.clear();
            }
        }
        return array;
    }


}
