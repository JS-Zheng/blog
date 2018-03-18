import javax.swing.*;
import java.awt.*;

public class RectangleGUI {

    public static void main(String[] args) {
        Rectangle defaultRec = new Rectangle();
        showJFrame(defaultRec);
    }

    static JFrame showJFrame(Rectangle r) {

        int width = r.width;
        int height = r.height;
        Color color = new Color(r.color);

        // 簡易的 Swing 圖形化介面
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(color);
        frame.setVisible(true);
        return frame;
    }
}

class Rectangle {

    int width;
    int height;
    int color;

    Rectangle() {
        this(500); // 正確 (O)
//        Rectangle(width); 錯誤 (X) -- 得使用 this 關鍵字
    }

    Rectangle(int width) {
        this(width, (int) (width / 1.618));
    }

    Rectangle(int width, int height) {
//        int area = width * height; 錯誤 (X) -- 利用「this」呼叫建構子，需為首句敘述
        this(width, height, 0x2196F3);
    }

    // 主建構函式
    Rectangle(int width, int height, int color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }
}
