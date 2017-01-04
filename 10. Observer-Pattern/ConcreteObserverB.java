public class ConcreteObserverB implements Observer {

    private String observerState;

    private ConcreteSubject concreteSubject; // 持有指向 ConcreteSubject 物件的 reference

    public ConcreteObserverB(ConcreteSubject concreteSubject) {
        this.concreteSubject = concreteSubject;
    }

    @Override
    public void update() {
        this.observerState = concreteSubject.getState();
        System.out.println(getClass().getSimpleName() + " 收到通知");
        System.out.println(observerState);
        System.out.println();
    }
}
