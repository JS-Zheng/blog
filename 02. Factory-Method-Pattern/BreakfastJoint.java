/**
 * 為工廠方法模式中的 工廠 (參數化工廠)
 * 定義一個做早餐的 int 參數 工廠方法，交給子類別實作
 * 且提供一個預設的 Class 參數 工廠方法
 */
public abstract class BreakfastJoint {

    // 做早餐 並回傳
    // param: int
    public abstract Breakfast makeBreakfast(int type);


    // 做早餐 並回傳
    // param: Class
    public <T extends Breakfast> T makeBreakfast(Class<T> c) {

        Breakfast breakfast = null;
        try {
//            透過 Java 反射 (Reflection) 機制，用類別名稱實例物件
            breakfast = (Breakfast) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            // 例外處理
        }
        return (T) breakfast;
    }
}
