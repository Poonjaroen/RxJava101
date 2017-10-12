package forallstudio.rxandroid.entity.policy;

import com.google.gson.annotations.SerializedName;

import forallstudio.rxandroid.entity.ValidationResult;

public class PolicyDocumentResponse {

    @SerializedName("document")
    private Document document;
    @SerializedName("validationResult")
    private ValidationResult validationResult;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }
}
