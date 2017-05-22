package logger;

/**
 * Created by zhengzhongsheng on 2016/12/5.
 */
public interface Logger {

    void writeFile(String pathName, Object object);

    Object readFile(String pathName);
}
