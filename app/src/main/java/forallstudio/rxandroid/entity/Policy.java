package forallstudio.rxandroid.entity;


import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Policy extends RealmObject {

    @PrimaryKey
    @SerializedName("policy_number")
    private String policyNumber;
    @SerializedName("expire")
    private boolean isExpire;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public boolean isExpire() {
        return isExpire;
    }

    public void setExpire(boolean expire) {
        isExpire = expire;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", isExpire=" + isExpire +
                '}';
    }
}
