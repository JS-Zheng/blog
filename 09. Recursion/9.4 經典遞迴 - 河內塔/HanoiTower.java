/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public interface HanoiTower {


    /**
     * 計算河內塔
     *
     * @param n 搬移的盤子數目
     * @param a 來源地 (source)
     * @param b 中繼站 (bridge)
     * @param c 目的地 (destination)
     * @return
     */
    void hanoi(int n, String a, String b, String c);
}
