package restaurant.customer.input;


import restaurant.*;

/**
 * Created by zhengzhongsheng on 2016/12/5.
 */
public class PorkHandler implements Handler {

    @Override
    public void handle(餐廳 restaurant) {

        服務生 waiter = restaurant.getWaiter();
        廚師 cook = restaurant.getCook();

        // 準備指令 並 設置廚師
        指令 command = new 點豬排指令(cook);
        waiter.addOrder(command);
    }
}
