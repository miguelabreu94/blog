package com.abreu.blog.payload;
import com.abreu.blog.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String role; // user
    private String username; // user
    private String password; // user
    private String fullName; // pessoa
    private String bio; // pessoa
    private User user;
    private List<User> usersList;


}
