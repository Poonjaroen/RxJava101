package forallstudio.rxandroid.viewmodel;


public class PolicyViewModel {

    private String policyNumber;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    @Override
    public String toString() {
        return "PolicyViewModel{" +
                "policyNumber='" + policyNumber + '\'' +
                '}';
    }
}