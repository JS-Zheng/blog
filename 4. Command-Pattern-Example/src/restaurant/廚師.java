package restaurant;

import java.io.Serializable;

/**
 * Created by zhengzhongsheng on 2016/12/4.
 */
public class 廚師 implements Serializable {

    private String name;

    public 廚師(String name) {
        this.name = name;
    }

    public void cookSteak() {
        System.out.println("廚師: " + name + "牛排來嚕~");
    }

    public void cookPork() {
        System.out.println("廚師: " + name + "豬排來嚕~");
    }

    // 反向邏輯範例: 復原牛排
    public void cancelSteak() {
        System.out.println("[復原] 顧客: 牛排難吃退貨~");
    }

    // 反向邏輯範例: 復原豬排
    public void cancelPork() {
        System.out.println("[復原] 顧客: 豬排難吃退貨~");
    }

}
