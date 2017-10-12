package forallstudio.rxandroid.network;


public class ApiUrl {

    public static final String ENDPOINT = "https://ep-uat.allianz-assistance.com/";
    public static final String URL_GET_ACCESS_TOKEN = ENDPOINT + "rest/pub.mediator.oauth2.getOAuth2AccessToken";
    public static final String URL_GET_USER_LOGIN = ENDPOINT + "ws/1.0/UtilityGateway/1.0/userManagement/userAcounts/login";
    public static final String URL_GET_USER_PROFILE = ENDPOINT + "ws/1.0/UtilityGateway/1.0/userManagement/search/webuser";

    public static final String URL_GET_POLICY = ENDPOINT + "ws/Travel-Assistance/1.0/TRAVEL/search/policies/V2";
    public static final String URL_GET_CLAIM = ENDPOINT + "ws/Travel-Assistance/1.0/TRAVEL/search/claims";

}