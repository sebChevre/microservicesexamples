package ch.sebooom.users.api;

public class ApiIError {

    private String message;

    private ApiIError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    };

    public static ApiIError message(String message){
        return new ApiIError(message);
    }
}
