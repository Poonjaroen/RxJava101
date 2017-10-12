package forallstudio.rxandroid.entity.claim;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import forallstudio.rxandroid.entity.ValidationResult;

public class ClaimResponse {

    @SerializedName("claimDetail")
    private List<ClaimDetail> claimDetail;
    @SerializedName("validationResult")
    private ValidationResult validationResult;

    public List<ClaimDetail> getClaimDetail() {
        return claimDetail;
    }

    public void setClaimDetail(List<ClaimDetail> claimDetail) {
        this.claimDetail = claimDetail;
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }

}