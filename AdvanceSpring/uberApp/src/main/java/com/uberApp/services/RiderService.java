package com.uberApp.services;

import com.uberApp.dto.DriverDto;
import com.uberApp.dto.RideDto;
import com.uberApp.dto.RideRequestDto;
import com.uberApp.dto.RiderDto;
import com.uberApp.entities.Rider;
import com.uberApp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
