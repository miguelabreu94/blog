package com.abreu.blog.controller;
import com.abreu.blog.payload.ReqRes;
import com.abreu.blog.service.AuthServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@NoArgsConstructor
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<ReqRes> register(@RequestBody ReqRes reg){
        return ResponseEntity.ok(authService.register(reg));
    }

    @PostMapping("/login")
    public ResponseEntity<ReqRes> login(@RequestBody ReqRes req){
        return ResponseEntity.ok(authService.login(req));
    }

    @PostMapping("/refresh")
    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes req){
        return ResponseEntity.ok(authService.refreshToken(req));
    }

}
