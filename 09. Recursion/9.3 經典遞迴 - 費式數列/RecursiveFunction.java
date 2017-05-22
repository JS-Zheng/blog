/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class RecursiveFunction implements Fib {


    @Override
    public int fib(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }

    }

}
