package forallstudio.rxandroid.entity.policy;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Policy {

    @SerializedName("policyNumber")
    private String policyNumber;
    @SerializedName("contractInterval")
    private ContractInterval contractInterval;
    @SerializedName("coverages")
    private List<Coverages> coverages;
    @SerializedName("productOfferingName")
    private String productOfferingName;
    @SerializedName("productOfferingDescription")
    private String productOfferingDescription;
    @SerializedName("purchaseDate")
    private String purchaseDate;
    @SerializedName("modificationAllowed")
    private String modificationAllowed;
    @SerializedName("claimsAllowed")
    private String claimsAllowed;
    @SerializedName("cancellationAllowed")
    private String cancellationAllowed;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public ContractInterval getContractInterval() {
        return contractInterval;
    }

    public void setContractInterval(ContractInterval contractInterval) {
        this.contractInterval = contractInterval;
    }

    public List<Coverages> getCoverages() {
        return coverages;
    }

    public void setCoverages(List<Coverages> coverages) {
        this.coverages = coverages;
    }

    public String getProductOfferingName() {
        return productOfferingName;
    }

    public void setProductOfferingName(String productOfferingName) {
        this.productOfferingName = productOfferingName;
    }

    public String getProductOfferingDescription() {
        return productOfferingDescription;
    }

    public void setProductOfferingDescription(String productOfferingDescription) {
        this.productOfferingDescription = productOfferingDescription;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getModificationAllowed() {
        return modificationAllowed;
    }

    public void setModificationAllowed(String modificationAllowed) {
        this.modificationAllowed = modificationAllowed;
    }

    public String getClaimsAllowed() {
        return claimsAllowed;
    }

    public void setClaimsAllowed(String claimsAllowed) {
        this.claimsAllowed = claimsAllowed;
    }

    public String getCancellationAllowed() {
        return cancellationAllowed;
    }

    public void setCancellationAllowed(String cancellationAllowed) {
        this.cancellationAllowed = cancellationAllowed;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", contractInterval=" + contractInterval +
                ", coverages=" + coverages +
                ", productOfferingName='" + productOfferingName + '\'' +
                ", productOfferingDescription='" + productOfferingDescription + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", modificationAllowed='" + modificationAllowed + '\'' +
                ", claimsAllowed='" + claimsAllowed + '\'' +
                ", cancellationAllowed='" + cancellationAllowed + '\'' +
                '}';
    }
}