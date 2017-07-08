import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by zhengzhongsheng on 2017/6/9.
 */
public class ReqResResponseHandler implements ResponseHandler<Result> {

    @Override
    public void resolve(Response<Result> res) {
        try {
            boolean successful = res.isSuccessful();
            Result result = res.body();

            if (successful && result != null) {
                printf("Token: %s", result.token);
            } else {

                ResponseBody rBody = res.errorBody();

                if (rBody != null) {
                    printf("%s %s\n%s",
                            res.code(), res.message(), rBody.string());
                } else {
                    printf("%s %s",
                            res.code(), res.message());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }


}
