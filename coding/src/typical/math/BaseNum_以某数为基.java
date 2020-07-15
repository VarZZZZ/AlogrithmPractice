package typical.math;

public class BaseNum_以某数为基 {
    // 进制转换，可以先将某进制转换为10进制，在转化为指定进制
    // 将某10进制值 按基 转换成字符串
    private String convertToBase7(int num){
        if(num<0) return "-"+convertToBase7(-num);
        if(num<7) return String.valueOf(num);
        return convertToBase7(num/7)+ num % 7;
    }
}
