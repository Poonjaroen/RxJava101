package forallstudio.rxandroid.entity.profile;

import com.google.gson.annotations.SerializedName;

public class ProfileInfo {

    @SerializedName("firstName")
    private String firstName;
    @SerializedName("name")
    private String name;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Webuser{" +
                "firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}