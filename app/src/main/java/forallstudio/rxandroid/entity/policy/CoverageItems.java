package forallstudio.rxandroid.entity.policy;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoverageItems {

    @SerializedName("insuredObjects")
    private List<InsuredObjects> insuredObjects;

    public List<InsuredObjects> getInsuredObjects() {
        return insuredObjects;
    }

    public void setInsuredObjects(List<InsuredObjects> insuredObjects) {
        this.insuredObjects = insuredObjects;
    }

}