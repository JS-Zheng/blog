import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by zhengzhongsheng on 2017/6/9.
 */
interface ReqResService {

    @FormUrlEncoded
    @POST("/api/register")
    Call<Result> registerUser(@Field("email") String email, @Field("password") String password);


    @Headers({
            "Content-Type: application/x-www-form-urlencoded; charset=UTF-8",
            "Content-Encoding: gzip",
    })
    @POST("/api/register")
    Call<Result> registerUserByGzipRequest(@Body RequestBody body);

}
