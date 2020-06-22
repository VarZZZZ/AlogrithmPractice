package 笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        Point[] ps = new Point[cnt];
        for(int i=0;i<cnt;i++){
            String[] line = sc.nextLine().trim().split(" ");
            ps[i] = new Point(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
        }
        Arrays.sort(ps,(a, b)->(a.x-b.x));
        List<Point> res = new ArrayList<>();
        int maxY = ps[cnt-1].y;

        res.add(ps[cnt-1]);
        for(int i=cnt-2;i>=0;i--){
            if(ps[i].y>maxY){
                maxY = ps[i].y;
                res.add(ps[i]);
            }
        }
        for(int i=res.size()-1;i>=0;i--){
            System.out.println(res.get(i).x+" "+res.get(i).y);
        }
    }
}
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

}
