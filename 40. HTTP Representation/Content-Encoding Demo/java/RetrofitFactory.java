import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhengzhongsheng on 2017/6/9.
 */
class RetrofitFactory {
    static Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
