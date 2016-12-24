/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class Main {

    public static void main(String[] args) {

        String a = "塔A";
        String b = "塔B";
        String c = "塔C";

        int n = 3; // 欲計算之值

        HanoiTower recursiveFunction = new RecursiveFunction();

        recursiveFunction.hanoi(n, a, b, c);


    }

}


