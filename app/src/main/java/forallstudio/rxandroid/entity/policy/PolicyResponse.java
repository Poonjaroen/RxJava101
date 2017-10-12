package forallstudio.rxandroid.entity.policy;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import forallstudio.rxandroid.entity.ValidationResult;

public class PolicyResponse {

    @SerializedName("policy")
    private List<Policy> policy;
    @SerializedName("validationResult")
    private ValidationResult validationResult;

    public List<Policy> getPolicy() {
        return policy;
    }

    public void setPolicy(List<Policy> policy) {
        this.policy = policy;
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }

    @Override
    public String toString() {
        return "PolicyResponse{" +
                "policy=" + policy +
                ", validationResult=" + validationResult +
                '}';
    }
}