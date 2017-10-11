package forallstudio.rxandroid.network;

import java.util.List;

import forallstudio.rxandroid.entity.Policy;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IMockUpService {

    String ENDPOINT = "http://www.policy.abc";

    @GET(ENDPOINT)
    Observable<List<Policy>> getAllPolicy();

}