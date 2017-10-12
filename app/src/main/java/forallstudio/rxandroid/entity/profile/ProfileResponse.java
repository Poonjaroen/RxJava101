package forallstudio.rxandroid.entity.profile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import forallstudio.rxandroid.entity.ValidationResult;

public class ProfileResponse {

    @SerializedName("webuser")
    private List<ProfileInfo> profileInfo;
    @SerializedName("validationResult")
    private ValidationResult validationResult;

    public List<ProfileInfo> getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(List<ProfileInfo> profileInfo) {
        this.profileInfo = profileInfo;
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "webuser=" + profileInfo +
                ", validationResult=" + validationResult +
                '}';
    }

}