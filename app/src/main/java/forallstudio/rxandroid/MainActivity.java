package forallstudio.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import forallstudio.rxandroid.datastore.IPolicyDiskDataStore;
import forallstudio.rxandroid.datastore.PolicyDiskDataStore;
import forallstudio.rxandroid.entity.UserPolicy;
import forallstudio.rxandroid.network.IMockUpService;
import forallstudio.rxandroid.network.MockUpClient;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private IPolicyDiskDataStore dataStore = new PolicyDiskDataStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IMockUpService client = MockUpClient.createService();
        Observable<List<UserPolicy>> policiesByUser = client.getPoliciesByUser("1");

        policiesByUser.subscribe(new Consumer<List<UserPolicy>>() {
            @Override
            public void accept(List<UserPolicy> userPolicies) throws Exception {
                for (UserPolicy userPolicy : userPolicies) {
                    Log.d("----->", "" + userPolicy.toString());
                }
            }
        });
    }


}