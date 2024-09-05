package com.canteen.canteenbase.responseDTOs;

public class LoginSuccessResponse {
    private String userType;
    private Long userId;

    public LoginSuccessResponse(String userType, Long userId) {
        this.userType = userType;
        setUserId(userId);

    }

    // Getters and setters
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
