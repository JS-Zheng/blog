package restaurant;

import java.io.Serializable;

/**
 * Created by zhengzhongsheng on 2016/12/4.
 */
public abstract class 命令 implements Cloneable, Serializable {

    protected 廚師 cook;

    public 命令(廚師 cook) {
        this.cook = cook;
    }

    public abstract void execute();

    public abstract void unExecute();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
