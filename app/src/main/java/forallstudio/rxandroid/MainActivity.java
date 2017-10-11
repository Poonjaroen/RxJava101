package forallstudio.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import forallstudio.rxandroid.datastore.IPolicyDiskDataStore;
import forallstudio.rxandroid.datastore.PolicyDiskDataStore;
import forallstudio.rxandroid.entity.Policy;
import forallstudio.rxandroid.network.IMockUpService;
import forallstudio.rxandroid.network.MockUpClient;
import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    private IPolicyDiskDataStore dataStore = new PolicyDiskDataStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IMockUpService client = MockUpClient.createService();
        Observable<List<Policy>> policiesByUser = client.getPoliciesByUser("1");

    }


}