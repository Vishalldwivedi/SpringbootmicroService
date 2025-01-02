package com.uberApp.services;

import com.uberApp.dto.DriverDto;
import com.uberApp.dto.SignupDto;
import com.uberApp.dto.UserDto;

public interface AuthService {

    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId, String vehicleId);

    String refreshToken(String refreshToken);
}
