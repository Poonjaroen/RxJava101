package forallstudio.rxandroid.entity.policy;

import com.google.gson.annotations.SerializedName;

import forallstudio.rxandroid.entity.ValidationResult;

public class PolicyDocumentEmailResponse {
    @SerializedName("validationResult")
    private ValidationResult validationResult;

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }
}
