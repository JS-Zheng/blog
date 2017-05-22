/**
 * Created by zhengzhongsheng on 2016/12/24.
 */
public class Main {

    public static void main(String[] args) {

        int a[] = {94, 87, 94, 0};
        int n = a.length;

        IntArraySum recursiveFunction = new RecursiveFunction();
        IntArraySum nonRecursiveFunction = new NonRecursiveFunction();

        // 代入 a 與 n
        // n=4

        // 過程:
        // --------------------------------
        // sum(a,4) return sum(a,3) + a[3]
        // sum(a,3) return sum(a,2) + a[2]
        // sum(a,2) return sum(a,1) + a[1]
        // sum(a,1) return a[0]
        // --------------------------------
        // 結果:
        // sum(a,4) return
        // a[0]+ a[1] + a[2]+ a[3]
        // --------------------------------
        int recursiveResult = recursiveFunction.sum(a, n);
        System.out.println("線性遞迴:");
        System.out.println(recursiveResult);
        System.out.println();


        int nonRecursiveResult = nonRecursiveFunction.sum(a, n);
        System.out.println("迭代式:");
        System.out.println(nonRecursiveResult);
        System.out.println();


    }

}


