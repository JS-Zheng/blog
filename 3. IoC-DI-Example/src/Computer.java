/**
 * Created by zhengzhongsheng on 2016/11/22.
 */
class Computer implements GameInjector {


    private IGame game;

    // 建構元注入 (Constructor Injection)
    public Computer() {
    }

    // 建構元注入 (Constructor Injection)
    public Computer(IGame game) {
        this.game = game; // 依賴注入
    }

    // 建構元注入 (Constructor Injection)
    public Computer(IGame game, boolean online) {
        this.game = game; // 依賴注入

        String strOnline = online ? "是" : "不是";
        System.out.println("這" + strOnline + "線上遊戲");
    }

    // 建構元注入 (Constructor Injection)
    public Computer(IGame game, Integer money) {
        this.game = game;  // 依賴注入

        System.out.println("此遊戲需要 " + money + "元");
    }


    // 設值方法注入 (Setter Injection)
    public void setGame(IGame game) {
        this.game = game;
    }

    // 介面注入 (Interface Injection)
    @Override
    public void injectGame(IGame game) {
        this.game = game;
    }

    public void playGame() {
        if (game != null) {
            game.play();
        } else {
            System.out.println("此電腦尚未安裝遊戲");
        }
    }

}
