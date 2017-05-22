package restaurant.customer.input;

/**
 * Created by zhengzhongsheng on 2016/12/5.
 */
public class ConcreteCreator extends HandlerCreator {

    @Override
    public Handler create(String input) {

        Handler result;

        if (input.equals("1")) {

            result = new SteakHandler();

        } else if (input.equals("2")) {

            result = new PorkHandler();

        } else if (input.compareToIgnoreCase("check") == 0) {

            result = new CheckHandler();

        } else if (input.compareToIgnoreCase("ok") == 0) {

            result = new OkHandler();

        } else if (input.compareToIgnoreCase("undo") == 0) {

            result = new UndoHandler();

        } else if (input.compareToIgnoreCase("exit") == 0) {

            result = new ExitHandler();

        } else {
            result = new OtherHandler();
        }
        return result;
    }
}
