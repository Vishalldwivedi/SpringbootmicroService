package com.uberApp.strategies;

import com.uberApp.entities.Driver;
import com.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
