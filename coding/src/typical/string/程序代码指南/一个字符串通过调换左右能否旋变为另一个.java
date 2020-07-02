package typical.string.程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/1 23:02
 * @Version 1.0
 */
public class 一个字符串通过调换左右能否旋变为另一个 {
    // p303;
    // 将字符串用二叉树表示，如果可以通过互换兄弟节点 形成另一个字符串，则返回true
    private boolean process(char[] str1,char[] str2,int L1,int L2,int size){
        //str1[L1...L1+SIZE]
        if(size==1){
            return str1[L1]==str2[L2];
        }
        for(int leftPart = 1;leftPart<size;leftPart++){
            // ||左边 表示 不旋转 ，  右边表示，第一个，str1[L1..L1+leftPart] 与str2的最后进行比较
            if((process(str1,str2,L1,L2,leftPart) && process(str1,str2,L1+leftPart,L2+leftPart,size-leftPart))
            ||(process(str1,str2,L1,L2+size-leftPart,leftPart) && process(str1,str2,L1+leftPart,L2,size-leftPart))){
                return true;
            }
        }
        return false;

    }
}
