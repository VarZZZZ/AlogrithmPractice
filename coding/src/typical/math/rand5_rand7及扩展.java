package typical.math;

/**
 * @Author: ly
 * @Date: 2020/7/8 22:40
 * @Version 1.0
 */
public class rand5_rand7及扩展 {
    // rand1To5()等概率生成1,2,3,4,5
    //rand1to5()-1  0,4
    // rand1to5()-1)*5   0,5,10,15,20
    // rand1to5()-1)8 +rand1to5()-1 生成0，24；
    //其中0,20可以组成7的倍数，每三个映射成1个，则可以去掉>20的值


    // 概率p生成0,1-p为1；
    // 生成1-6 ； 分析，产生01和10的概率都是p(1-p),可以实现等概率生成0 和1
    public int rand01p(){
        double p = 0.83;
        return Math.random()<p?0:1;
    }
    public int rand01(){
        int num;
        do{
            num = rand01p();
        }while (num==rand01p()); // 两次生成的数必须不同，这样p(1-p)概率就相同
        return num;
    }
}
