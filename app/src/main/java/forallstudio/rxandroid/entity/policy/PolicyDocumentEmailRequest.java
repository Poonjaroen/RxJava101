package forallstudio.rxandroid.entity.policy;

import com.google.gson.annotations.SerializedName;

public class PolicyDocumentEmailRequest {

    @SerializedName("subscriptionCountry")
    private String subscriptionCountry;

    @SerializedName("documentInfo")
    private DocumentInfo documentInfo;

    public String getSubscriptionCountry() {
        return subscriptionCountry;
    }

    public void setSubscriptionCountry(String subscriptionCountry) {
        this.subscriptionCountry = subscriptionCountry;
    }

    public DocumentInfo getDocumentInfo() {
        return documentInfo;
    }

    public void setDocumentInfo(DocumentInfo documentInfo) {
        this.documentInfo = documentInfo;
    }
}
