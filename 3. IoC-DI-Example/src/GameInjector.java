/**
 * Created by zhengzhongsheng on 2016/11/22.
 */ // 遊戲注入者
// 可以規範： 任何需要 "遊戲" 的模組 都必須實做此介面
interface GameInjector {
    void injectGame(IGame game);
}
