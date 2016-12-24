/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class NonRecursiveFunction implements PartialSumsA, PartialSumsB {

    @Override
    public int sum(int n) {

        int result = 0;

        for (int i = 1; i <= n; i++) {
            result = result + i;
        }

        return result;
    }

    @Override
    public int sum(int n, int total) {

        /*
          對照 尾端遞迴
          if (n == 0) {
              return total;
          } else {
              return sum(n - 1, total + n);
          }

        */

        while (n > 0) {
            total = total + n;
            n = n - 1;
        }
        return total;
    }
}
