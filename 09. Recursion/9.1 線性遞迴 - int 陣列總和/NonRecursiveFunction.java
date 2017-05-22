/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class NonRecursiveFunction implements IntArraySum {

    @Override
    public int sum(int[] a, int n) {

        int result = 0; // 欲傳回之結果

        if (n < 1) {
            throw new IllegalArgumentException("n should be >= 1");
        } else {

            for (int i = 0; i < n; i++) { // 用 for 迴圈 尋訪陣列
                result = result + a[i]; // 將陣列值一一加總
            }
        }

        return result; // 回傳結果
    }
}
