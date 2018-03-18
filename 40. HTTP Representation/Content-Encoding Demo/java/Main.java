import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.UnsupportedEncodingException;

/**
 * Created by zhengzhongsheng on 2017/6/9.
 *
 * dependencies:
 * compile 'com.squareup.retrofit2:retrofit:2.3.0'
 * compile 'com.squareup.retrofit2:converter-gson:2.3.0'
 */
public class Main {

    public static void main(String[] args) {

        Retrofit retrofit = RetrofitFactory.create();
        ReqResService service = retrofit.create(ReqResService.class);

        String data = ("email=jason%40gg&password=9487");

        try {

            RequestBody body = GzipBodyFactory.create(data);

            // By Gzip Request
            Call<Result> call = service.registerUserByGzipRequest(body);

            // By Normal Request
//        Call<Result> call = service.registerUser("jason", "9487");

            asyncRequest(call);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    static void asyncRequest(Call<Result> call) {
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                ResponseHandler<Result> handler = new ReqResResponseHandler();
                handler.resolve(response);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                System.out.println("Response Failed: " + t.getMessage());
            }
        });
    }


}







