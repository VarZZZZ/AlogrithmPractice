package typical.math;

public class BaseNum_以某数为基 {
    // 将某10进制值 按基 转换成字符串
    private String convertToBase7(int num){
        if(num<0) return "-"+convertToBase7(-num);
        if(num<7) return String.valueOf(num);
        return convertToBase7(num/7)+ num % 7;
    }
}
