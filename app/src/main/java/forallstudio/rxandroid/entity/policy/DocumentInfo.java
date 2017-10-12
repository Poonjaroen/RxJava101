package forallstudio.rxandroid.entity.policy;

import com.google.gson.annotations.SerializedName;

public class DocumentInfo {

    @SerializedName("addressData")
    private AddressData addressData;

    public AddressData getAddressData() {
        return addressData;
    }

    public void setAddressData(AddressData addressData) {
        this.addressData = addressData;
    }
}
