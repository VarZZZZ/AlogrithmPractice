package typical.array_2;

/**
 * @Author: ly
 * @Date: 2020/7/15 19:51
 * @Version 1.0
 */
public class 将元素划分成三份_在每份中共享都不一样_求最大贡献 {
    /**
     * A[i]表示物理攻击；B[i]表示魔法攻击；
     * 将i派去第一个队，贡献为a[i]，第二队，贡献为b[i]，第三个队，为a[i]+b[i])/2;
     * 求贡献最大的划分
     *
     * 去一队和三队的差为a[i]-(a[i]+b[i])/2=(a[i]-b[i])/2, 同理去三队比去二队 (a[i]-b[i])/2 ；  一>三>二
     * 将每个人的A-B值排序，较大的去一队，较小的去二队，中间的去三队
     */
    private double getOffer(int[] a,int[] b){
        int n = a.length;

        return 0.0;
    }
}
