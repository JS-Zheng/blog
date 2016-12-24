import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 此為一超腦殘 IoC 容器 範例
 * 實務上 完全派不上用場
 * <br/>
 * 要做好一個容器 需要兼顧很多細節
 * 大部分 Framework 都寫的很好
 * 我就不重造輪子了
 * <br/>
 * 但這可以讓你感受 IoC 容器
 * 綁定 (註冊) 依賴關係後
 * 全自動生產的快感
 */
public class ServiceContainer {

    private Map bindings; // 被註冊的 依賴關係

    public ServiceContainer() {
        bindings = new HashMap(); // init
    }

    /**
     * 綁定 (註冊) 類別，
     * 告訴容器，以後遇到 conditionClz，
     * 就 給他一個 bindingClz 的實例，
     * 兩者為抽象 或 具體 都可
     *
     * @param conditionClz 當遇到此 『條件』
     * @param bindings     給我這個 『綁定』
     */
    public void bind(Class conditionClz, Object... bindings) {
        List paramList = new ArrayList<>();
        for (Object obj : bindings) {
            paramList.add(obj);
        }

        this.bindings.put(conditionClz, paramList);

    }


    /**
     * 製作 (解析) 類別
     * 需事先 bind
     *
     * @param conditionClz 欲建構類別
     * @return conditionClz 實例
     */
    public Object make(Class conditionClz) {

        Object obj = null; // 欲建構的產品 (conditionClz)

        // 取得 欲建構類別 名稱
        String conditionClzName = conditionClz.getName();
        // 取得 欲建構類別 簡易名稱
        String conditionClzSimpleName = conditionClz.getSimpleName();
        // 取得綁定的 bindingParamList 實例
        List bindingParamList = (List) bindings.get(conditionClz);

        // 如果此條件類別，尚未綁定，bindingParamList 則為空值
        if (bindingParamList != null) {
            System.out.println("開始實例物件: " + conditionClzName);

            try {
                // 得到建構元陣列
                Constructor<?>[] constructors = conditionClz.getDeclaredConstructors();

                // 得到建構元陣列長度
                int constLength = constructors.length;
                System.out.println("建構元數量為" + constLength + "\n");

                // 無建構元，使用預設空建構元
                if (constLength == 0) {

                    Object param = bindingParamList.get(0);

                    // 若有指定欲實例之類別型態
                    if (param instanceof Class) {

                        Class bindingClz = (Class) param;

                        // 綁定之類別 是否為 條件的 子類
                        boolean child = conditionClz.isAssignableFrom(bindingClz);

                        if (child && conditionClz != bindingClz) {
                            System.out.println(bindingClz.getSimpleName() + " 為 " + conditionClzSimpleName + " 的子類！");
                            obj = newInstanceByClzName(bindingClz);
                        } else if (!child) {
                            System.out.println(bindingClz.getSimpleName() + " 非 " + conditionClzSimpleName + " 的子類！");
                        }
                    }

                    if (obj == null) {

                        // 欲建構類別 是否為抽象
                        if (Modifier.isAbstract(conditionClz.getModifiers())) {
                            throw new IllegalArgumentException("無法實例 抽象 " + conditionClzSimpleName);
                        }

                        // 建構產品
                        obj = newInstanceByClzName(conditionClz);
                    }


                } else {

                    // 尋訪 建構元陣列
                    for (int i = constLength - 1; i >= 0; i--) {

                        Constructor constructor = constructors[i];

                        // 取得此建構元的 參數類別型態 陣列
                        Class[] params = constructor.getParameterTypes();
                        int paramsLength = params.length; // 此建構元的 參數數量

                        System.out.println("尋訪 " + paramsLength + " 參數 建構元");

                        // 如果此建構元的參數數量 等同 綁定的參數數量
                        if (paramsLength == bindingParamList.size()) {

                            System.out.println("尋訪 被綁定參數 list\n");

                            // 新的綁定參數 list，防止原先的 list 參數中 有抽象存在
                            List newBindingParamList = new ArrayList<>();

                            // 型態錯誤 flag
                            boolean typeError = false;

                            // 尋訪 綁定的參數 list
                            for (int j = 0; j < bindingParamList.size(); j++) {

                                Object objBindingParam = bindingParamList.get(j);

                                Class param = params[j]; // 取得此建構元的 參數類別

                                // 被綁定的參數物件 為 建構元參數的子類
                                if (param.isAssignableFrom(objBindingParam.getClass())) {

                                    // 是的話 直接新增至 newBindingParamList (新的綁定參數 list)
                                    newBindingParamList.add(objBindingParam);

                                } else {  // 被綁定的參數物件 非 建構元參數的子類

                                    // 如果綁定的參數 為 Class 型態
                                    if (objBindingParam instanceof Class) {

                                        Class paramClz = (Class) objBindingParam;


                                        // 嘗試 由 bindings 取得 是否有此綁定
                                        // 有的話 就進入遞迴
                                        //
                                        // Ex: 綁定 container.bind(Computer.class, IGame.class);

                                        /*
                                           嘗試 由 bindings 取得 是否有此綁定
                                           有的話 就進入遞迴

                                           Ex: 綁定 container.bind(Computer.class, IGame.class);
                                           但是 建構元中 需要的是 IGame 而非 IGame.class
                                           去檢查 bindings 中 是否有綁定 (IGame.class, XXX.class);
                                           取得具體產品之實例
                                         */
                                        List mParamList = (List) bindings.get(paramClz);

                                        if (mParamList != null) {

                                            System.out.println("參數型態: " + paramClz.getName());
                                            System.out.println("進入 make 遞迴 實例參數");

                                            // 終極懶惰遞迴: 實例 被綁定類別 之 實例
                                            Object objParam = make(paramClz);

                                            // 新增遞迴取得的實例
                                            // 至 newBindingParamList (新的綁定參數 list)
                                            newBindingParamList.add(objParam);

                                        } else {
                                            throw new NullPointerException("類別:" + paramClz.getName() + " 尚未註冊 ");
                                        }
                                    } else {

                                        // 先新增再說
                                        newBindingParamList.add(objBindingParam);


                                        // 腦殘比較法:
                                        // int 與 Integer
                                        // bool 與 Boolean
                                        if (
                                                ((param.getSimpleName().equals("int") || param.getSimpleName().equals("Integer"))
                                                        &&
                                                        (objBindingParam.getClass().getSimpleName().equals("int") || objBindingParam.getClass().getSimpleName().equals("Integer")))
                                                        ||
                                                        ((param.getSimpleName().equals("boolean") || param.getSimpleName().equals("Boolean"))
                                                                &&
                                                                (objBindingParam.getClass().getSimpleName().equals("boolean") || objBindingParam.getClass().getSimpleName().equals("Boolean")))
                                                ) {

                                        } else {
                                            // 型態錯誤
                                            // 改變 flag 為 true
                                            System.out.println(param.getSimpleName());
                                            System.out.println(objBindingParam.getClass().getSimpleName());
                                            typeError = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (typeError) {
                                System.out.println("===============");
                                System.out.println("建構參數 與 綁定 list 數量相同，但型態不同 (多載)");
                                System.out.println("略過此次迴圈尋訪");
                                System.out.println("===============\n");
                                continue;
                            }

                            // 將 newBindingParamList 轉為陣列
                            Object[] param = newBindingParamList.toArray();
                            // 將 上方的參數陣列 丟到建構元中實例
                            obj = constructor.newInstance(param);

                            break;
                        } else {
                            System.out.println("未綁定" + paramsLength + " 參數\n");
                        }
                    }

                    if (obj == null) {
                        // 如果物件還是空的，嘗試直接實例
                        obj = newInstanceByClzName(conditionClz);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else {
            throw new NullPointerException("類別:" + conditionClzName + " 尚未註冊 ");
        }

        String result = obj == null ? "實例 " + conditionClzName + " 失敗" : "實例 " + conditionClzName + " 成功\n";
        System.out.println(result);

        return obj;

    }


    private Object newInstanceByClzName(Class clz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Object instance;

        System.out.println("====實例物件====");
        String clzName = clz.getName();
        System.out.println(clzName);
        instance = Class.forName(clzName).newInstance(); // 實例 clzName 物件
        System.out.println("===============\n");

        return instance;
    }


}



