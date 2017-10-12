package forallstudio.rxandroid.entity.claim;

import com.google.gson.annotations.SerializedName;

public class ClaimDetail {

    @SerializedName("claimNumber")
    private String claimNumber;
    @SerializedName("claimClassId")
    private String claimClassId;
    @SerializedName("claimStatus")
    private String claimStatus;
    @SerializedName("creationDate")
    private String creationDate;

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getClaimClassId() {
        return claimClassId;
    }

    public void setClaimClassId(String claimClassId) {
        this.claimClassId = claimClassId;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

}