package forallstudio.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import forallstudio.rxandroid.entity.Policy;
import forallstudio.rxandroid.network.IMockUpService;
import forallstudio.rxandroid.network.MockUpClient;
import forallstudio.rxandroid.viewmodel.PolicyViewModel;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRealm();
        realm = Realm.getDefaultInstance();

        netWorkAndCached();
        //testGroupBy();
        //test1();
    }

    private void netWorkAndCached() {
        IMockUpService client = MockUpClient.createService();

        Observable<Policy> netWorkObservable = client.getPoliciesByUser("2")
                .delay(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<List<Policy>, ObservableSource<Policy>>() {
                    @Override
                    public ObservableSource<Policy> apply(@NonNull List<Policy> policies) throws Exception {
                        return Observable.fromIterable(policies);
                    }
                })
                .flatMap(new Function<Policy, ObservableSource<Policy>>() {
                    @Override
                    public ObservableSource<Policy> apply(@NonNull Policy policy) throws Exception {
                        return Observable.just(writeToRealm(policy));
                    }
                });


        List<Policy> allPolicyFromRealm = getAllPolicyFromRealm();
        Observable<Policy> cachedObservable = Observable.empty();
        if (!allPolicyFromRealm.isEmpty()) {
            cachedObservable = Observable.fromIterable(allPolicyFromRealm);
        }
        Observable.concat(cachedObservable, netWorkObservable)
                .distinct()
                .filter(new Predicate<Policy>() {
                    @Override
                    public boolean test(@NonNull Policy policy) throws Exception {
                        return !policy.isExpire();
                    }
                })
                .map(new Function<Policy, PolicyViewModel>() {
                    @Override
                    public PolicyViewModel apply(@NonNull Policy policy) throws Exception {
                        PolicyViewModel viewModel = new PolicyViewModel();
                        viewModel.setPolicyNumber("Number : " + policy.getPolicyNumber());
                        return viewModel;
                    }
                })
                .subscribe(new Consumer<PolicyViewModel>() {
                    @Override
                    public void accept(PolicyViewModel viewModel) throws Exception {
                        Log.d("----->", "" + viewModel.toString());
                    }
                });
//                .toSortedList(new Comparator<PolicyViewModel>() {
//                    @Override
//                    public int compare(PolicyViewModel viewModel, PolicyViewModel t1) {
//                        Log.d("----->", "toSortedList");
//                        return viewModel.getPolicyNumber().compareTo(t1.getPolicyNumber());
//                    }
//                })
//                .subscribe(new Consumer<List<PolicyViewModel>>() {
//                    @Override
//                    public void accept(List<PolicyViewModel> policyViewModels) throws Exception {
//                        for (PolicyViewModel viewModel : policyViewModels) {
//                            Log.d("----->", "" + viewModel.toString());
//                        }
//                    }
//                });
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration mRealmConfig = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(mRealmConfig);
    }

    private Policy writeToRealm(Policy policy) {
        getRealm().beginTransaction();
        Policy policyOnRealm = getRealm().copyToRealmOrUpdate(policy);
        getRealm().commitTransaction();
        return policyOnRealm;
    }

    private List<Policy> getAllPolicyFromRealm() {
        return getRealm().where(Policy.class).findAll();
    }

    private void removePolicy(Policy policy) {
        getRealm().beginTransaction();
        policy.deleteFromRealm();
        getRealm().commitTransaction();
    }

    public Realm getRealm() {
        return realm;
    }

    private void testGroupBy() {
        IMockUpService client = MockUpClient.createService();
        Observable<GroupedObservable<Boolean, Policy>> netWorkObservable = client.getPoliciesByUser("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<List<Policy>, ObservableSource<Policy>>() {
                    @Override
                    public ObservableSource<Policy> apply(@NonNull List<Policy> policies) throws Exception {
                        return Observable.fromIterable(policies);
                    }
                })
                .groupBy(new Function<Policy, Boolean>() {
                    @Override
                    public Boolean apply(@NonNull Policy policy) throws Exception {
                        return policy.isExpire();
                    }
                });

        netWorkObservable.subscribe(new Consumer<GroupedObservable<Boolean, Policy>>() {
            @Override
            public void accept(final GroupedObservable<Boolean, Policy> booleanPolicyGroupedObservable) throws Exception {
                booleanPolicyGroupedObservable.toList().subscribe(new BiConsumer<List<Policy>, Throwable>() {
                    @Override
                    public void accept(List<Policy> policies, Throwable throwable) throws Exception {
                        Log.d("----->", "accept : " + booleanPolicyGroupedObservable.getKey());
                        for (Policy policy : policies) {
                            Log.d("----->", "" + policy.toString());
                        }
                    }
                });
            }
        });

    }

    private void test1() {
        Policy policy = new Policy();
        policy.setPolicyNumber("Empty");
        List<Policy> allPolicyFromRealm = new ArrayList<>();
        //List<Policy> allPolicyFromRealm = getAllPolicyFromRealm();
        Observable.fromIterable(allPolicyFromRealm)
                .defaultIfEmpty(policy).subscribe(new Consumer<Policy>() {
            @Override
            public void accept(Policy policy) throws Exception {
                Log.d("----->", "" + policy.toString());
            }
        });

    }
}