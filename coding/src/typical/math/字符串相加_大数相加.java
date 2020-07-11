package typical.math;

/**
 * @Author: ly
 * @Date: 2020/7/10 23:24
 * @Version 1.0
 */
public class 字符串相加_大数相加 {
    //首先根据字符串 num1 和 num2的长度进行补位,
    // 在长度较短的字符串前插字符’0’直至长度相等,
    // 这一步操作可以方便我们利用for循环从字符串末尾逐位向前相加

    private String addString(String s1,String s2){

        StringBuilder sb = new StringBuilder();
        int len1 = s1.length();
        int len2 = s2.length();
        int i1=len1-1,i2=len2-1;
        int step = 0;
        while(i1>=0||i2>=0){
            if(i1>=0&&i2>=0){
                int sm = s1.charAt(i1)+s2.charAt(i2) + step;
                step = sm/10;
                sm %=10;


            }
        }


        return "";
    }

}
