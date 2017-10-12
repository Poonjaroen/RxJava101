package forallstudio.rxandroid.datastore;


import java.util.List;

import forallstudio.rxandroid.entity.UserPolicy;
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
    public void addPolicy(UserPolicy userPolicy) {
        getRealm().beginTransaction();
        getRealm().copyToRealmOrUpdate(userPolicy);
        getRealm().commitTransaction();
    }

    @Override
    public void addPolicy(List<UserPolicy> policies) {
        getRealm().beginTransaction();
        getRealm().copyToRealmOrUpdate(policies);
        getRealm().commitTransaction();
    }

    @Override
    public void deleteAllPolicy() {
        getRealm().beginTransaction();
        getRealm().delete(UserPolicy.class);
        getRealm().commitTransaction();

    }

    @Override
    public void deletePolicy(UserPolicy userPolicy) {
        getRealm().beginTransaction();
        userPolicy.deleteFromRealm();
        getRealm().commitTransaction();
    }

    @Override
    public UserPolicy getPolicyByPolicyNumber(String policyNumber) {
        return getRealm().where(UserPolicy.class).equalTo("policyNumber", policyNumber).findFirst();
    }

    @Override
    public List<UserPolicy> getAllPolicy() {
        return getRealm().where(UserPolicy.class).findAll();
    }

    public Realm getRealm() {
        if (realm == null) {
            openRealm();
        }
        return realm;
    }
}
