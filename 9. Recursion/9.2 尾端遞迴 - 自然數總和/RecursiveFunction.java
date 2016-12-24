/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class RecursiveFunction implements PartialSumsA, PartialSumsB {


    @Override
    public int sum(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n should be >= 0");
        } else if (n == 0) {
            return 0;
        } else {
            return sum(n - 1) + n;
        }

    }

    @Override
    public int sum(int n, int total) {

        if (n == 0) {
            // 用來做遞迴追蹤 (recursion trace)
//            System.out.println("return " + total + ";");
            return total;
        } else {
            // 用來做遞迴追蹤 (recursion trace)
//            System.out.println("sum(" + (n - 1) + ", " + (total + n) + ");");
            return sum(n - 1, total + n);
        }

    }
}
