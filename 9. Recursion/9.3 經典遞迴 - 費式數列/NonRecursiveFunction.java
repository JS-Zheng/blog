/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class NonRecursiveFunction implements Fib {

    @Override
    public int fib(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0, b = 1, result = 0;

//            System.out.println();
            for (int i = 2; i <= n; i++) {

//                System.out.println("i = " + i);
                result = a + b;
//                System.out.println("result = a + b; (" + result + " = " + a + " + " + b + ");");
                a = b;
//                System.out.println("a = b; (a = " + a + ");");
                b = result;
//                System.out.println("b = result; (b = " + b + ");");
//                System.out.println();
            }
            return result;

        }
    }

}
