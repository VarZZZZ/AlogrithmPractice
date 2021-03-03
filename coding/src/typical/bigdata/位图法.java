package typical.bigdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ly
 * @Date: 2020/8/11 22:37
 * @Version 1.0
 *
 * https://www.jianshu.com/p/e530baada558
 */
public class 位图法 {
    static class javaUniqueSort {
        public static int[] temp = new int[100001]; // 利用int[]来当作位图
        public static List<Integer> tempList = new ArrayList<Integer>();
        public static int count ;
        public static long start ;
        public static long end ;

        // 主要就是这一个函数 // 利用int[]数组来实现
        public static List<Integer> uniqueSort(final List<Integer> uniqueList) {
            javaUniqueSort.tempList.clear();
            for (int i = 0; i < javaUniqueSort.temp.length; i++) {
                javaUniqueSort.temp[i] = 0;
            }
            for (int i = 0; i < uniqueList.size(); i++) {
                javaUniqueSort.temp[uniqueList.get(i)] = 1;
            }
            for (int i = 0; i < javaUniqueSort.temp.length; i++) {
                if (javaUniqueSort.temp[i] == 1) {
                    javaUniqueSort.tempList.add(i);
                }
            }

            return javaUniqueSort.tempList;
        }


        public static void getStartTime() {
            javaUniqueSort.start = System.nanoTime();
        }

        public static void getEndTime(final String s) {
            javaUniqueSort.end = System.nanoTime();
            System.out.println(s + ": " + (javaUniqueSort.end - javaUniqueSort.start) + "ns");
        }

        public static void main(final String[] args) {

            List<Integer> firstNum = new ArrayList<Integer>();
            List<Integer> secondNum = new ArrayList<Integer>();

            for (int i = 1; i <= 100000; i++) {
                firstNum.add(i);
                secondNum.add(i);
            }

            Collections.shuffle(firstNum);
            Collections.shuffle(secondNum);

            getStartTime();
            Collections.sort(firstNum);
            getEndTime("java sort run time  ");

            getStartTime();
            secondNum = uniqueSort(secondNum);
            getEndTime("uniqueSort run time ");


        }
    }

    // bitmap,利用bit 而不是int实现 ; 此处1000000是num的个数，计算需要byte多少个
    byte[] bits = new byte[getIndex(1000000)+1];

    //2. 计算数字num在byte[]中的位置，一个byte表示8个数字，所以num/8得到byte下标
    public int getIndex(int num){
        return num>>3; //num/8;
    }

    //3. 计算数字num在byte[idx]中的位置，具体是byte[idx]的第几位。一个byte[idx]包括8位
    public int getPositions(int num){
        return num % 8;
    }

    //4.将所在位置从0变成1，其他位置不变
    public void add(byte[] bits,int num){
        bits[getIndex(num)] |= 1 << getPositions(num);
    }
    // 5. 判断指定num是否存在
    public boolean contains(byte[] bits,int num){
        return (bits[getIndex(num)] & 1<<getPositions(num)) != 0;
    }

    // 6.重置某一数字对应在bitmap中的值

    /**
     * 重置某一数字对应在bitmap中的值<br/>
     * 对1进行左移，然后取反，最后与byte[index]作与操作。
     * @param bits
     * @param num
     */
    public void clear(byte[] bits,int num){
        bits[getIndex(num)] &= ~(1 << getPositions(num));
    }




}
