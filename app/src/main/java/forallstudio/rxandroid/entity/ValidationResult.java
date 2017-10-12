package forallstudio.rxandroid.entity;


import com.google.gson.annotations.SerializedName;

public class ValidationResult {

    @SerializedName("code")
    private String code;
    @SerializedName("message")
    private String message;
    @SerializedName("timeStamp")
    private String timestamp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}