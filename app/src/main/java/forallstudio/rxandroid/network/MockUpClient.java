package forallstudio.rxandroid.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class MockUpClient {

    private static IMockUpService mRestService = null;

    public static IMockUpService createService() {
        if (mRestService == null) {
            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(IMockUpService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(getClient())
                    .build();

            mRestService = retrofit.create(IMockUpService.class);
        }
        return mRestService;
    }

    public static OkHttpClient getClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(new FakeInterceptor());
        return client.build();
    }
}