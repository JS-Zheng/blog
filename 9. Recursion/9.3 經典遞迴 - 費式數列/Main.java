/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class Main {

    public static void main(String[] args) {


        int n = 5; // 欲計算之值

        Fib recursiveFunctionA = new RecursiveFunction();
        Fib nonRecursiveFunctionA = new NonRecursiveFunction();

        int recursiveResult = recursiveFunctionA.fib(n);
        System.out.println("法a: 線性 非尾端 遞迴");
        System.out.println(recursiveResult);
        System.out.println();


        int nonRecursiveResult = nonRecursiveFunctionA.fib(n);
        System.out.println("法a: 迭代式");
        System.out.println(nonRecursiveResult);
        System.out.println();

    }

}


