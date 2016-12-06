package logger;

import java.io.*;

/**
 * Created by zhengzhongsheng on 2016/12/5.
 */
public class FileLogger implements Logger {

    public void writeFile(String pathName, Object object) {
        File file = new File(pathName);

        try (FileOutputStream fs = new FileOutputStream(file);
             BufferedOutputStream bs = new BufferedOutputStream(fs);
             ObjectOutputStream os = new ObjectOutputStream(bs)
        ) {

            // if file doesn't exists, then create it

            if (!file.exists()) {
                file.createNewFile();
            }

            os.writeObject(object);

            System.out.println("-----寫入菜單日誌 (Log)-----");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readFile(String pathName) {

        Object result = null;

        File file = new File(pathName);

        if (!file.exists()) {
            return null;
        }

        try (FileInputStream fs = new FileInputStream(file);
             BufferedInputStream bs = new BufferedInputStream(fs);
             ObjectInputStream os = new ObjectInputStream(bs)) {

            result = os.readObject();

            System.out.println("-----讀取菜單日誌 (Log)-----");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
