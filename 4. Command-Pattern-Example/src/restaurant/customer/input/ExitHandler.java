package restaurant.customer.input;

import restaurant.服務生;
import restaurant.餐廳;

/**
 * Created by zhengzhongsheng on 2016/12/5.
 */
public class ExitHandler implements Handler {
    @Override
    public void handle(餐廳 restaurant) {
        服務生 waiter = restaurant.getWaiter();
        System.out.println("掰啦 下次再來唄\n");
        waiter.destroyLastCustomerRecord(); // 銷毀顧客記錄
        restaurant.setHasCustomer(false);
    }
}
