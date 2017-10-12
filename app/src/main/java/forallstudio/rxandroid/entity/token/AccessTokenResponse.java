package forallstudio.rxandroid.entity.token;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AccessTokenResponse extends RealmObject {

    @PrimaryKey
    private int accessTokenGroup; // 0 = USER , 1 = TRAVEL
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("expires_in")
    private long expires;

    public int getAccessTokenGroup() {
        return accessTokenGroup;
    }

    public void setAccessTokenGroup(int accessTokenGroup) {
        this.accessTokenGroup = accessTokenGroup;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public long getExpired() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public boolean isExpired(long currentTime) {
        return currentTime > getExpired();
    }

    @Override
    public String toString() {
        return "AccessTokenResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", expires=" + expires +
                ", accessTokenGroup='" + accessTokenGroup + '\'' +
                '}';
    }
}