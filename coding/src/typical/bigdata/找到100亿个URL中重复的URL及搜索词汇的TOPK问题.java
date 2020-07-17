package typical.bigdata;

/**
 * @Author: ly
 * @Date: 2020/7/2 22:44
 * @Version 1.0
 */
public class 找到100亿个URL中重复的URL及搜索词汇的TOPK问题 {
    //大根堆用于升序排序（所以求最小的前k个数用大根堆），
    // 小根堆用于降序排序
    // （所以求最大的前k个数（常见的topk问题，基本都是求最大的前k个数）用小根堆）。
    // 一般的方法是通过hash，拆成小文件，。
    // topk问题同样用hash分流，处理每一个小文件时，利用哈希表统计每个词及其词频。哈希表记录建立后
    // 在遍历哈希表，过程中使用大小为100的小根堆来选出每个小文件的top100;
    //首先读入前10000个数来创建大小为10000的最小堆，建堆的时间复杂度为O（mlogm）（m为数组的大小即为10000），
    // 然后遍历后续的数字，并于堆顶（最小）数字进行比较。如果比最小的数小，则继续读取后续数字；
    // 如果比堆顶数字大，则替换堆顶元素并重新调整堆为最小堆。整个过程直至1亿个数全部遍历完为止。
    // 然后按照中序遍历的方式输出当前堆中的所有10000个数字。
    // 该算法的时间复杂度为O（nmlogm），空间复杂度是10000（常数）。

    //https://zhuanlan.zhihu.com/p/75397875  海量数据求中位数

    // 利用位来判断最快

}
