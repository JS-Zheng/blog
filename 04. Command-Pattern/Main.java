import restaurant.餐廳;

public class Main {

    public static void main(String[] args) {

        // 原始碼範例
//        Runnable runnable = () -> System.out.println("具體命令"); // Command cmd = ConcreteCommand
//        Thread thread1 = new Thread(runnable); // 將 cmd 交給 Thread (Invoker)
//        thread1.start(); // Invoker 調用 cmd 的 執行方法

        // 餐廳範例
        餐廳 restaurant = new 餐廳("Good Good Eat Restaurant"); // 創建餐廳
        Thread thread2 = new Thread(restaurant, restaurant.getName());
        thread2.start(); // 餐廳開始營業

    }
}

