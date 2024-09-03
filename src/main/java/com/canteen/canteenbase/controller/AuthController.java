package com.canteen.canteenbase.controller;

import com.canteen.canteenbase.responseDTOs.LoginFailureResponse;
import com.canteen.canteenbase.responseDTOs.LoginRequest;
import com.canteen.canteenbase.responseDTOs.LoginSuccessResponse;
import com.canteen.canteenbase.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest loginRequest) {
        Object response=authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (response instanceof LoginSuccessResponse) {
            return ResponseEntity.ok(response); // Status 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginFailureResponse("Login failed")); // Status 401 Unauthorized
        }
    }
}
