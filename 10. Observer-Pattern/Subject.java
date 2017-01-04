interface Subject {

    /**
     * 新增 觀察者
     *
     * @param observer 抽象的觀察者，不需知道其具體類別為何、實作的細節...
     */
    void attach(Observer observer);

    /**
     * 移除 觀察者
     *
     * @param observer 抽象的觀察者，不需知道其具體類別為何、實作的細節...
     */
    void detach(Observer observer);

    /**
     * 當 主題狀態 發生變化
     * 通知所有已訂閱的觀察者
     */
    void notifyObservers();

}
