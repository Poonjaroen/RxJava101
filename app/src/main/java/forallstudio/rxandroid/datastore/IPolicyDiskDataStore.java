package forallstudio.rxandroid.datastore;


import java.util.List;

import forallstudio.rxandroid.entity.Policy;

public interface IPolicyDiskDataStore {

    void openRealm();

    void closeRealm();

    void addPolicy(Policy policy);

    void addPolicy(List<Policy> policies);

    void deleteAllPolicy();

    void deletePolicy(Policy policy);

    Policy getPolicyByPolicyNumber(String policyNumber);

    List<Policy> getAllPolicy();
}