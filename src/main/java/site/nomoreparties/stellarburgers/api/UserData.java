package site.nomoreparties.stellarburgers.api;

import lombok.Data;

@Data
public class UserData {
    private boolean success;
    private Object user;
    private String accessToken;
    private String refreshToken;
    private String message;
}
