import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {


    private String subjectState;

    private List<Observer> observers;


    public ConcreteSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        System.out.println("-------------------------------------");
        System.out.println("| " + getClass().getSimpleName() + " 通知給所有觀察者更新 |");
        System.out.println("-------------------------------------");
        System.out.println("                 ▼");
        System.out.println();

        observers.forEach(Observer::update); // 尋訪並通知所有 觀察者 進行更新
    }

    public String getState() {
        return subjectState;
    }

    public void setState(String state) {
        this.subjectState = state;
        System.out.println("-------------------------------------");
        System.out.println(getClass().getSimpleName() + " 變更狀態");
        System.out.println(subjectState);
        System.out.println();

//        notifyObservers(); // 不一定由此做更新

    }

}
