/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class RecursiveFunction implements IntArraySum {

    @Override
    public int sum(int[] a, int n) {
        if (n < 1) { // 陣列索引數不得小於 1
            throw new IllegalArgumentException("n should be >= 1");
        } else if (n == 1) { // 陣列索引數等於 1，返回陣列的 第 "1" 個元素
            return a[0];
        } else {
            return sum(a, n - 1) + a[n - 1]; // 否則，將問題拆解成 sum(a, n - 1) + a[n - 1]
        }
    }
}
