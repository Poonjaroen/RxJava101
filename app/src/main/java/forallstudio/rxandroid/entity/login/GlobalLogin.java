package forallstudio.rxandroid.entity.login;


import forallstudio.rxandroid.entity.claim.ClaimResponse;
import forallstudio.rxandroid.entity.policy.PolicyResponse;
import forallstudio.rxandroid.entity.profile.ProfileResponse;

public class GlobalLogin {

    private LoginResponse loginResponse;
    private ProfileResponse profileResponse;
    private PolicyResponse policyResponse;
    private ClaimResponse claimResponse;

    public LoginResponse getLoginResponse() {
        return loginResponse;
    }

    public void setLoginResponse(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }

    public ProfileResponse getProfileResponse() {
        return profileResponse;
    }

    public void setProfileResponse(ProfileResponse profileResponse) {
        this.profileResponse = profileResponse;
    }

    public PolicyResponse getPolicyResponse() {
        return policyResponse;
    }

    public void setPolicyResponse(PolicyResponse policyResponse) {
        this.policyResponse = policyResponse;
    }

    public ClaimResponse getClaimResponse() {
        return claimResponse;
    }

    public void setClaimResponse(ClaimResponse claimResponse) {
        this.claimResponse = claimResponse;
    }
}
