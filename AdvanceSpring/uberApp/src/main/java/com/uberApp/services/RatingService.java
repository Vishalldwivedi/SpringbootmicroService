package com.uberApp.services;

import com.uberApp.dto.DriverDto;
import com.uberApp.dto.RiderDto;
import com.uberApp.entities.Ride;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);
}
