package forallstudio.rxandroid.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class FakeInterceptor implements Interceptor {

    // FAKE RESPONSES.
    private final static String RESPONSE = "[\n" +
            "  {\n" +
            "    \"policy_number\": \"1\",\n" +
            "    \"expire\": true\n" +
            "  },\n" +
            "  {\n" +
            "    \"policy_number\": \"7\",\n" +
            "    \"expire\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"policy_number\": \"4\",\n" +
            "    \"expire\": true\n" +
            "  },\n" +
            "  {\n" +
            "    \"policy_number\": \"2\",\n" +
            "    \"expire\": true\n" +
            "  },\n" +
            "  {\n" +
            "    \"policy_number\": \"5\",\n" +
            "    \"expire\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"policy_number\": \"6\",\n" +
            "    \"expire\": true\n" +
            "  },\n" +
            "  {\n" +
            "    \"policy_number\": \"3\",\n" +
            "    \"expire\": false\n" +
            "  }\n" +
            "]";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = new Response.Builder()
                .code(200)
                .message(RESPONSE)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), RESPONSE.getBytes()))
                .addHeader("content-type", "application/json")
                .build();
        return response;
    }
}