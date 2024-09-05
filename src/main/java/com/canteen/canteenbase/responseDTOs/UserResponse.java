package com.canteen.canteenbase.responseDTOs;

public class UserResponse {

    public UserResponse(String userId, String userType) {
        this.userType = userType;
        this.userId = userId;
    }

    private String userType ;
    private String userId;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
