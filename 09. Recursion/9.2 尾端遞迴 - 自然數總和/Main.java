/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class Main {

    public static void main(String[] args) {


        int n = 10;

        // ----------------------------------------------------
        PartialSumsA recursiveFunctionA = new RecursiveFunction();
        PartialSumsA nonRecursiveFunctionA = new NonRecursiveFunction();

        int recursiveResult = recursiveFunctionA.sum(n);
        System.out.println("法a: 線性 非尾端 遞迴");
        System.out.println(recursiveResult);
        System.out.println();


        int nonRecursiveResult = nonRecursiveFunctionA.sum(n);
        System.out.println("法a: 迭代式");
        System.out.println(nonRecursiveResult);
        System.out.println();

        // ----------------------------------------------------

        PartialSumsB recursiveFunctionB = new RecursiveFunction();
        PartialSumsB nonRecursiveFunctionB = new NonRecursiveFunction();

        int recursiveResultB = recursiveFunctionB.sum(n, 0);
        System.out.println("法b: 尾端遞迴:");
        System.out.println(recursiveResultB);
        System.out.println();

        int nonRecursiveResultB = nonRecursiveFunctionB.sum(n, 0);
        System.out.println("法b: 迭代式");
        System.out.println(nonRecursiveResultB);
        System.out.println();

        // ----------------------------------------------------
    }

}


