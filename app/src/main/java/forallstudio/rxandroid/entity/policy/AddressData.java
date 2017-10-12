package forallstudio.rxandroid.entity.policy;

import com.google.gson.annotations.SerializedName;

public class AddressData {

    @SerializedName("email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
