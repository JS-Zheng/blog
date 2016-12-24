/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class RecursiveFunction implements HanoiTower {


    @Override
    public void hanoi(int n, String a, String b, String c) {
        if (n == 1) { // 只有一個盤子
            System.out.println("將盤子從" + a + " 搬到" + c);
        } else {
            hanoi(n - 1, a, c, b); // 先搬 n-1 個盤子 到 b (將 c 當中繼)
            hanoi(1, a, b, c); // 將剩下的一個盤子 由 a 搬到 c
            hanoi(n - 1, b, a, c); // 將剛剛 塔b 的 n-1 個盤子 再由 b 搬到 c (a 當中繼)

        }
    }
}
