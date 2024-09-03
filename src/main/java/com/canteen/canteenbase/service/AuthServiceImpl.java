package com.canteen.canteenbase.service;

import com.canteen.canteenbase.entity.User;
import com.canteen.canteenbase.repositories.UserRepository;
import com.canteen.canteenbase.responseDTOs.LoginFailureResponse;
import com.canteen.canteenbase.responseDTOs.LoginSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Object authenticate(String username, String password) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username));

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) { // Passwords should be hashed in real applications
                return new LoginSuccessResponse(user.getUsertype()); // Return user type on successful login
            }
        }
        return new LoginFailureResponse("Login failed"); // Return failure message
    }
}
