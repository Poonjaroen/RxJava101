package forallstudio.rxandroid.datastore;


import java.util.List;

import forallstudio.rxandroid.entity.Policy;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class PolicyDiskDataStore implements IPolicyDiskDataStore {

    private Realm realm;

    public PolicyDiskDataStore() {
        RealmConfiguration mRealmConfig = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(mRealmConfig);
        openRealm();
    }

    @Override
    public void openRealm() {
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void closeRealm() {
        if (realm != null && !realm.isClosed()) {
            realm.close();
        }
    }

    @Override
    public void addPolicy(Policy policy) {
        getRealm().beginTransaction();
        getRealm().copyToRealmOrUpdate(policy);
        getRealm().commitTransaction();
    }

    @Override
    public void addPolicy(List<Policy> policies) {
        getRealm().beginTransaction();
        getRealm().copyToRealmOrUpdate(policies);
        getRealm().commitTransaction();
    }

    @Override
    public void deleteAllPolicy() {
        getRealm().beginTransaction();
        getRealm().delete(Policy.class);
        getRealm().commitTransaction();

    }

    @Override
    public void deletePolicy(Policy policy) {
        getRealm().beginTransaction();
        policy.deleteFromRealm();
        getRealm().commitTransaction();
    }

    @Override
    public Policy getPolicyByPolicyNumber(String policyNumber) {
        return getRealm().where(Policy.class).equalTo("policyNumber", policyNumber).findFirst();
    }

    @Override
    public List<Policy> getAllPolicy() {
        return getRealm().where(Policy.class).findAll();
    }

    public Realm getRealm() {
        if (realm == null) {
            openRealm();
        }
        return realm;
    }
}
