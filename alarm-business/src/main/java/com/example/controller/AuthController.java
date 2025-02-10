//package com.example.controller;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class AuthController {
//
//    @Autowired
//    @Lazy
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping("/api/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//        Map<String, String> map = new HashMap<>();
//
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            request.getUsername(),
//                            request.getPassword()
//                    )
//            );
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            map.put("code", "200");
//            map.put("message", "登录成功");
//            map.put("user", authentication.getName());
//            return ResponseEntity.ok().body(map);
//        } catch (BadCredentialsException e) {
//            map.put("code", "401");
//            return ResponseEntity.status(401).body(map);
//        }
//    }
//}
//
//@Data
//class LoginRequest {
//    private String username;
//    private String password;
//}