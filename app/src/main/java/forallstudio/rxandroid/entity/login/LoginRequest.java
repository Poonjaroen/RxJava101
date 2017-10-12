package forallstudio.rxandroid.entity.login;


public class LoginRequest {

    private String userName;
    private String password;
    private String subscriptionCountry;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubscriptionCountry() {
        return subscriptionCountry;
    }

    public void setSubscriptionCountry(String subscriptionCountry) {
        this.subscriptionCountry = subscriptionCountry;
    }

}