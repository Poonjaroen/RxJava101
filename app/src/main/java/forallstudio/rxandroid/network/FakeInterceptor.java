package forallstudio.rxandroid.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static forallstudio.rxandroid.network.FakeResponse.RESPONSE_USER_1;
import static forallstudio.rxandroid.network.FakeResponse.RESPONSE_USER_2;

public class FakeInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        final String query = chain.request().url().query();
        // Parse the Query String.

        String responseString;

        final String[] parsedQuery = query.split("=");
        if (parsedQuery[0].equalsIgnoreCase("user") && parsedQuery[1].equalsIgnoreCase("1")) {
            responseString = RESPONSE_USER_1;
        } else if (parsedQuery[0].equalsIgnoreCase("user") && parsedQuery[1].equalsIgnoreCase("2")) {
            responseString = RESPONSE_USER_2;
        } else {
            responseString = "";
        }

        Response response = new Response.Builder()
                .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                .addHeader("content-type", "application/json")
                .build();
        return response;
    }
}