package forallstudio.rxandroid.datastore;


import java.util.List;

import forallstudio.rxandroid.entity.UserPolicy;

public interface IPolicyDiskDataStore {

    void openRealm();

    void closeRealm();

    void addPolicy(UserPolicy userPolicy);

    void addPolicy(List<UserPolicy> policies);

    void deleteAllPolicy();

    void deletePolicy(UserPolicy userPolicy);

    UserPolicy getPolicyByPolicyNumber(String policyNumber);

    List<UserPolicy> getAllPolicy();
}