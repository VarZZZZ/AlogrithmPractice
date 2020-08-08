package typical.array_2;

/**
 * @Author: ly
 * @Date: 2020/8/4 11:06
 * @Version 1.0
 */
public class 数组奇数放在前面偶数放在后面_保证相对位置 {
    // 插入排序
    public void reOrderArray(int [] array) {
        int i = 0;
        int j=0;
        while(j<array.length){
            if(array[j]%2==1){
                int t = array[j];
                for(int c=j-1;c>=i;c--){
                    array[c+1]=array[c];
                }
                array[i]=t;
                i++;
            }
            j++;
        }

    }
}
