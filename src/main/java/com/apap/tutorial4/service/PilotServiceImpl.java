package com.apap.tutorial4.service;
import com.apap.tutorial4.repository.FlightDB;
import com.apap.tutorial4.repository.PilotDB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.model.FlightModel;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDB pilotDb;
	
	@Autowired
	private FlightDB flightDb;

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}

	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
	}
	
	@Override
	public List<FlightModel> getListFlightByLicenseNumber(String licenseNumber){
		return flightDb.findByPilotLicenseNumber(licenseNumber);
	}
	
	@Override
	public void updatePilot(PilotModel newpilot) {
		PilotModel old = this.getPilotDetailByLicenseNumber(newpilot.getLicenseNumber());
		old.setName(newpilot.getName());
		old.setFlyHour(newpilot.getFlyHour());
	}
	
	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);
	}

}
