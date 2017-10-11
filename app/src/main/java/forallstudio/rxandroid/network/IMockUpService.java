package forallstudio.rxandroid.network;

import java.util.List;

import forallstudio.rxandroid.entity.Policy;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IMockUpService {

    String ENDPOINT = "http://www.policy.abc";

    @GET(ENDPOINT)
    Observable<List<Policy>> getPoliciesByUser(@Query("user") final String user);

}