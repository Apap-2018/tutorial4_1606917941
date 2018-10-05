package com.apap.tutorial4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.FlightDB;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDB flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}
	
	@Override
	public FlightModel getFlightDetailById(long id) {
		return flightDb.findById(id);
	}
	
	@Override
	public void deleteFlight(FlightModel flight) {
		flightDb.delete(flight);
	}
	
	@Override
	public void updateFlight(FlightModel newflight) {
		FlightModel old = this.getFlightDetailById(newflight.getId());
		System.out.println(old.getFlightNumber());
		old.setFlightNumber(newflight.getFlightNumber());
		old.setOrigin(newflight.getOrigin());
		old.setDestination(newflight.getDestination());
		old.setTime(newflight.getTime());
	}

}
