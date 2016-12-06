package restaurant;

import logger.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhengzhongsheng on 2016/12/4.
 */
public class 服務生 {

    private String ordersFileName = "菜單";

    private Queue<指令> orders; // 巨集佇列指令

    private Stack<指令> history; // 堆疊歷史記錄

    private Logger logger; // 日誌記錄者

    public 服務生(Logger logger) {

        this.logger = logger;

        Object obj = logger.readFile(ordersFileName);

        try {
            if (obj != null) {
                this.orders = (Queue<指令>) obj;
                checkOrders();

            }
        } catch (ClassCastException e) {
            System.out.println("[菜單日誌] - 內容錯誤");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (this.orders == null) {
                this.orders = new LinkedList<>();
            }
        }

        this.history = new Stack<>();
    }


    public void addOrder(指令 command) {
        orders.offer(command);
        logger.writeFile(ordersFileName, orders); // 新增指令後 記錄到日誌
    }

    public void undo() {
        if (!history.isEmpty()) {
            指令 cmd = history.pop();
            cmd.unExecute();
            logger.writeFile(ordersFileName, orders); // 指令還原後 記錄到日誌
        } else {
            System.out.println("[復原失敗] --- 查無點餐記錄");
        }
    }

    public void sendOrders() {

        while (!orders.isEmpty()) {
            指令 cmd = orders.poll();
            cmd.execute();
            logger.writeFile(ordersFileName, orders); // 指令執行後 記錄到日誌
            addHistoryByClone(cmd); // 執行過後，用「Clone」的方式儲存 Command
        }


    }

    private void addHistoryByClone(指令 cmd) {
        指令 cmdClone = null;
        try {
            cmdClone = (指令) cmd.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        history.push(cmdClone);

    }

    public void checkOrders() {

        if (orders.isEmpty()) {
            System.out.println("菜單尚無內容");
        } else {
            System.out.println("此為過去的指令記錄");
            for (指令 order : orders) {
                System.out.println(order.getClass().getSimpleName());
            }
        }
        System.out.println();
    }

    public void destroyLastCustomerRecord() {
        orders.clear();
        history.clear();
    }

}
