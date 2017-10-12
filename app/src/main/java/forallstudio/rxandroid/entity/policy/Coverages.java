package forallstudio.rxandroid.entity.policy;


import com.google.gson.annotations.SerializedName;

public class Coverages {

    @SerializedName("name")
    private String name;
    @SerializedName("insuranceSum")
    private String insuranceSum;
    @SerializedName("coverageItems")
    private CoverageItems coverageItems;
    @SerializedName("description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsuranceSum() {
        return insuranceSum;
    }

    public void setInsuranceSum(String insuranceSum) {
        this.insuranceSum = insuranceSum;
    }

    public CoverageItems getCoverageItems() {
        return coverageItems;
    }

    public void setCoverageItems(CoverageItems coverageItems) {
        this.coverageItems = coverageItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}