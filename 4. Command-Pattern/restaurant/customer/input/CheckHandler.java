package restaurant.customer.input;


import restaurant.服務生;
import restaurant.餐廳;

/**
 * Created by zhengzhongsheng on 2016/12/5.
 */
public class CheckHandler implements Handler {

    @Override
    public void handle(餐廳 restaurant) {
        服務生 waiter = restaurant.getWaiter();
        waiter.checkOrders();
    }
}

