import retrofit2.Response;

/**
 * Created by zhengzhongsheng on 2017/6/9.
 */
public interface ResponseHandler<T> {
    void resolve(Response<T> res);
}
