package com.example.gestion_cinema.Dtos;

public class ChangePassword {
    private Long userId;
    private String actualPassword;
    private String newPassword;
    private String confirmNewPassword;

    public String getActualPassword() {
        return actualPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }
    public Long getUserId() {
        return userId;
    }
}
