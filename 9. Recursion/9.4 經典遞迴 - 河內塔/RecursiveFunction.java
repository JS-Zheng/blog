/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class RecursiveFunction implements HanoiTower {


    @Override
    public void hanoi(int n, String a, String b, String c) {
        if (n == 1) { // 只有一個盤子
            System.out.println("將盤子從" + a + " 搬到" + c);
        } else {
            hanoi(n - 1, a, c, b);
            hanoi(1, a, b, c);
            hanoi(n - 1, b, a, c);

        }
    }
}
