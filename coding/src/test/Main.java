package test;

import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2020/9/12 15:08
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] cs = str.toCharArray();
        boolean[] odds = new boolean[6]; // p[0] a;p[1] b;p[2] c;3 x;4 y;5 z;

    }
    public enum Operation{
        PLUS("+") {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            @Override
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            @Override
            public double apply(double x, double y) {
                return x / y;
            }
        };

        private final String symbol;
        Operation(String symbol) {this.symbol = symbol;}




        public abstract double apply(double x, double y);

        @Override
        public String toString() {
            return symbol;
        }
    }

    // 策略枚举
    public enum PayrollDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

        private final PayType payType;

        PayrollDay(PayType payType) {this.payType = payType;}
        PayrollDay() {this.payType = PayType.WEEKDAY;}

        int pay(int mins, int payRate){
            return payType.overtimePay(mins, payRate);
        }

        private enum PayType {
            WEEKDAY{
                @Override
                int overtimePay(int mins, int payRate) {
                    return mins <= MINS_PER_SHIFT ? 0 : (mins - MINS_PER_SHIFT) * payRate / 2;
                }
            },
            WEEKEND{
                @Override
                int overtimePay(int mins, int payRate) {
                    return mins * payRate / 2;
                }
            };
            private static final int MINS_PER_SHIFT = 8 * 60;
            abstract int overtimePay(int mins, int payRate);
        }
    }
}
