import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncoderDemo {

    @Test
    public void encodeTest() throws UnsupportedEncodingException {

        // user 大頭照網址
        String imgUrl = "https://d3ojx0qwvsjea2.cloudfront.net" +
                "/wp-content/uploads/2017/05/23110017/its-you.jpg";

        // 編碼結果
        String result;

        try {
            result = URLEncoder.encode(imgUrl, "utf-8");

        } catch (UnsupportedEncodingException e) {
            result = e.toString();
        }

        println(result);
    }

    void println(String x) {
        System.out.println(x);
    }
}



















