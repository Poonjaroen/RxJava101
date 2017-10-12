package forallstudio.rxandroid.network;

import java.util.List;

import forallstudio.rxandroid.entity.UserPolicy;
import forallstudio.rxandroid.entity.claim.ClaimResponse;
import forallstudio.rxandroid.entity.login.LoginRequest;
import forallstudio.rxandroid.entity.login.LoginResponse;
import forallstudio.rxandroid.entity.policy.PolicyResponse;
import forallstudio.rxandroid.entity.profile.ProfileResponse;
import forallstudio.rxandroid.entity.token.AccessTokenResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IMockUpService {

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST(ApiUrl.URL_GET_ACCESS_TOKEN)
    Observable<AccessTokenResponse> getAccessToken(@Field("client_id") String clientId,
                                                   @Field("client_secret") String clientSecret,
                                                   @Field("grant_type") String grantType);

    @POST(ApiUrl.URL_GET_USER_LOGIN)
    Observable<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET(ApiUrl.URL_GET_USER_PROFILE)
    Observable<ProfileResponse> getUserProfile(@Query("userId") String userId,
                                               @Query("subscriptionCountry") String subscriptionCountry);

    @GET(ApiUrl.URL_GET_POLICY)
    Observable<PolicyResponse> getPolicy(@Query("userId") String userId,
                                         @Query("subscriptionCountry") String subscriptionCountry);

    @GET(ApiUrl.URL_GET_CLAIM)
    Observable<ClaimResponse> getClaim(@Query("userId") String userId,
                                       @Query("subscriptionCountry") String subscriptionCountry);

    @GET(ApiUrl.ENDPOINT)
    Observable<List<UserPolicy>> getPoliciesByUser(@Query("user") final String user);

}