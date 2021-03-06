package com.apap.tutorial4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial4.model.FlightModel;

@Repository
public interface FlightDB extends JpaRepository<FlightModel, Long>{
	List<FlightModel> findByPilotLicenseNumber(String licenseNumber);
	FlightModel findByFlightNumber(String flightNumber);
	FlightModel findById(long id);
}
