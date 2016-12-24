package restaurant.customer.input;


import restaurant.服務生;
import restaurant.餐廳;

/**
 * Created by zhengzhongsheng on 2016/12/5.
 */
public class OkHandler implements Handler {

    @Override
    public void handle(餐廳 restaurant) {
        服務生 waiter = restaurant.getWaiter();
        waiter.sendOrders();
    }
}

