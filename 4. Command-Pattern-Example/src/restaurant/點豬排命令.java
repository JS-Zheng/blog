package restaurant;

/**
 * Created by zhengzhongsheng on 2016/12/4.
 */
public class 點豬排命令 extends 命令 {


    public 點豬排命令(廚師 cook) {
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
