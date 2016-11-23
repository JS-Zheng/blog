/**
 * Created by zhengzhongsheng on 2016/11/22.
 */
public class Main {
    public static void main(String[] args) {

        ServiceContainer container = new ServiceContainer(); // 實例 容器

        container.bind(IGame.class, 爆爆王.class); // 註冊依賴關係： 當遇到 『IGame』，給容器給我 『爆爆王』
        container.bind(Computer.class, IGame.class,100); // 註冊依賴關係： 當遇到 『Computer』，給容器給我 『IGame』

        Computer computer = (Computer) container.make(Computer.class); // 讓容器製作 Computer
        computer.playGame(); // 使用已被注入依賴的 Computer 物件




    }
}


