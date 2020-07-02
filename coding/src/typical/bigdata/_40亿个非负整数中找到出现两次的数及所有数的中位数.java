package typical.bigdata;

/**
 * @Author: ly
 * @Date: 2020/7/2 22:55
 * @Version 1.0
 */
public class _40亿个非负整数中找到出现两次的数及所有数的中位数 {
    //出现两次，用bit map 表示，用2个位置表示一个数出现的词频， 初次遇到num,就把bit[num*2+1]和bit[num*2+2]设为01；
    //中位数:分区间处理， 取2148个区间，arr[2148]表示 每个区间内的数量。
}
