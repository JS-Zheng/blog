package restaurant;

import logger.FileLogger;
import logger.Logger;
import restaurant.customer.input.ConcreteCreator;
import restaurant.customer.input.Handler;
import restaurant.customer.input.HandlerCreator;

import java.util.Scanner;

/**
 * Created by zhengzhongsheng on 2016/12/5.
 */
public class 餐廳 implements Runnable {

    private String name; // 店名
    private 服務生 waiter;
    private 廚師 cook;

    private boolean opening; // 是否營業
    private boolean hasCustomer; // 是否有客人

    public 餐廳(String name) {
        this.name = name; // 設置店名
        preparePersonnel(); // 準備工作人員
        opening = true;
    }


    @Override
    public void run() {

        // 客人來了
        hasCustomer = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("歡迎來到 " + name);

        while (opening && hasCustomer) {

            System.out.println();
            System.out.println("請輸入命令: ");
            System.out.println("[1]牛排  [2]豬排");
            System.out.println("[ok]點餐完畢 [check]確認菜單內容 [undo]退貨上一個'收到的'餐點  [exit]離開");
            String input = scanner.next();

            handleInput(input); // 處理顧客輸入的命令
        }


    }

    private void preparePersonnel() {
        Logger logger = new FileLogger();
        waiter = new 服務生(logger);

        cook = new 廚師("Jason");
    }

    private void handleInput(String input) {

        HandlerCreator creator = new ConcreteCreator(); // 取得 Handler 工廠
        Handler handler = creator.create(input); // 藉由工廠 取得 Handler

        handler.handle(this); // 將 顧客輸入 委託給 Handler 進行處理


    }

    public void setHasCustomer(boolean hasCustomer) {
        this.hasCustomer = hasCustomer;
    }

    public String getName() {
        return name;
    }

    public 服務生 getWaiter() {
        return waiter;
    }

    public 廚師 getCook() {
        return cook;
    }
}
