package restaurant;

/**
 * Created by zhengzhongsheng on 2016/12/4.
 */
public class 點豬排指令 extends 指令 {


    public 點豬排指令(廚師 cook) {
        super(cook);
    }

    @Override
    public void execute() {
        cook.cookPork();
    }

    @Override
    public void unExecute() {
        cook.cancelPork();
    }
}
