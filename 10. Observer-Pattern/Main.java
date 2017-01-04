public class Main {

    public static void main(String[] args) {

        // 實例 具體主題
        ConcreteSubject concreteSubject = new ConcreteSubject();

        // 模擬 設置初始訊息 (此時尚無 觀察/訂閱者)
        concreteSubject.setState("消息 1: 年輕人終究還是年輕人");


        /*
         * 下方的 concreteSubject.attach(XXX);
         * 需要的參數為 Observer
         * 因此，實例 抽象 或 具體觀察者皆可 (多型 polymorphism)
         */
        ConcreteObserverA observerA = new ConcreteObserverA(concreteSubject); // 實例 具體觀察者 A
        Observer observerB = new ConcreteObserverB(concreteSubject); // 實例 抽象觀察者 B
        Observer observerC = new ConcreteObserverC(concreteSubject); // 實例 抽象觀察者 C

        concreteSubject.attach(observerA); // 觀察者A 訂閱 主題
        concreteSubject.attach(observerB); // 觀察者B 訂閱 主題
        concreteSubject.attach(observerC); // 觀察者C 訂閱 主題

        concreteSubject.setState("消息 2: 太衝動了"); // 變更主題狀態
        concreteSubject.notifyObservers(); // 通知所有 觀察者

    }
}


/*
 *
 * Result:
 *
 * ConcreteSubject 變更狀態
 * 消息 1: 年輕人終究還是年輕人
 *
 * ConcreteSubject 變更狀態
 * 消息 2: 太衝動了
 *
 * -------------------------------------
 * | ConcreteSubject 通知給所有觀察者更新 |
 * -------------------------------------
 *                  ▼
 *
 * ConcreteObserverA 收到通知
 * 消息 2: 太衝動了
 *
 * ConcreteObserverB 收到通知
 * 消息 2: 太衝動了
 *
 * ConcreteObserverC 收到通知
 * 消息 2: 太衝動了
 *
 */