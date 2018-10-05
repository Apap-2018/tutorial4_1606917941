package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;

public interface PilotService {
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	List<FlightModel> getListFlightByLicenseNumber(String licenseNumber);
	void addPilot(PilotModel pilot);
	void updatePilot(PilotModel pilot);
	void deletePilot(PilotModel pilot);
}
