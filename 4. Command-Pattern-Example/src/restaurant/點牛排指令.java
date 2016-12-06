package restaurant;

/**
 * Created by zhengzhongsheng on 2016/12/4.
 */
public class 點牛排指令 extends 指令 {


    public 點牛排指令(廚師 cook) {
        super(cook);
    }

    @Override
    public void execute() {
        cook.cookSteak();
    }

    @Override
    public void unExecute() {
        cook.cancelSteak();
    }
}
