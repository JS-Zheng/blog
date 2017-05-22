package restaurant.customer.input;

import restaurant.餐廳;

/**
 * Created by zhengzhongsheng on 2016/12/5.
 */
public class OtherHandler implements Handler {
    @Override
    public void handle(餐廳 restaurant) {
        System.out.println("無此動作，請重新輸入\n");
    }
}
