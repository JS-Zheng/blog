import okhttp3.RequestBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhengzhongsheng on 2017/6/9.
 */
public class GzipBodyFactory {

    public static RequestBody create(String data) throws UnsupportedEncodingException {

        byte[] payload = compress(data);

        return RequestBody.create(null, payload);

    }


    private static byte[] compress(String str) throws UnsupportedEncodingException {

        byte[] data = str.getBytes("UTF-8");
        byte[] result = new byte[0];

        try (ByteArrayOutputStream bs = new ByteArrayOutputStream()) {

            try (GZIPOutputStream gs = new GZIPOutputStream(bs)) {
                gs.write(data);
            }

            result = bs.toByteArray();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
