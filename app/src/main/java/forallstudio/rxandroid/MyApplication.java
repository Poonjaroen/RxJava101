package forallstudio.rxandroid;

import android.app.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.realm.Realm;

public class MyApplication extends Application {

    public static String RESPONSE_POLICY_1 = "";
    public static String RESPONSE_POLICY_2 = "";

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RESPONSE_POLICY_1 = getContentFromAssert("response_policy_user1");
        RESPONSE_POLICY_2 = getContentFromAssert("response_policy_user2");
    }

    private String getContentFromAssert(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream stream = getAssets().open(fileName);
            BufferedReader r = new BufferedReader(new InputStreamReader(stream));

            String line;
            while ((line = r.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
