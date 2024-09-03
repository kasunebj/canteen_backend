package com.canteen.canteenbase.responseDTOs;

public class LoginFailureResponse {
    private String message;

    public LoginFailureResponse(String message) {
        this.message = message;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

