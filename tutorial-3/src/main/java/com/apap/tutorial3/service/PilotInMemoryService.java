package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;
import com.apap.tutorial3.model.PilotModel;
import org.springframework.stereotype.Service;

@Service
public class PilotInMemoryService implements PilotService{
	private List<PilotModel> archivePilot;
	
	public PilotInMemoryService() {
		archivePilot = new ArrayList<>();
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		archivePilot.add(pilot);
	}

	@Override
	public List<PilotModel> getPilotList() {
		return archivePilot;
	}

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		for(int i=0; i< archivePilot.size();i++) {
			PilotModel pilot = archivePilot.get(i);
			if(pilot.getLicenseNumber().equalsIgnoreCase(licenseNumber)) {
				return pilot;
			}
		}
		return null;
	}

	@Override
	public PilotModel updatePilot(String licenseNumber, Integer flyHour) {
		for(int i=0; i< archivePilot.size();i++) {
			PilotModel pilotUpd = archivePilot.get(i);
			if(pilotUpd.getLicenseNumber().equals(licenseNumber)) {
				pilotUpd.setFlyHour(flyHour);
				return pilotUpd;
			}
		}
		return null;
		
	}	
	
	@Override
	public boolean deletePilot(String licenseNumber) {
		for(int i=0; i< archivePilot.size();i++) {
			PilotModel pilotDel = archivePilot.get(i);
			if(pilotDel.getLicenseNumber().equals(licenseNumber)) {
				archivePilot.remove(i);
				return true;
			}
		}
		return false;	
	}
	
}
