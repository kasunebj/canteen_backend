package com.canteen.canteenbase.responseDTOs;

public class LoginSuccessResponse {
    private String userType;

    public LoginSuccessResponse(String userType) {
        this.userType = userType;
    }

    // Getters and setters
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
