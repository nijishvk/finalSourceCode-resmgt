package com.hexa.resmgt.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexa.resmgt.springboot.model.HexaDataPull;
import com.hexa.resmgt.springboot.model.ResourceMonthlyCount;
import com.hexa.resmgt.springboot.repositories.HexaDataPullRepository;
import com.hexa.resmgt.springboot.repositories.ResourceCountRepository;
import com.hexa.resmgt.springboot.repositories.ResourceMasterRepository;

@Service("hexaDataPullService")
@Transactional
public class HexaDataPullServiceImpl implements HexaDataPullService{
	
	@Autowired
	private HexaDataPullRepository hexaDataPullRepository;
	
	@Autowired
	private ResourceMasterRepository resourceMasterRepository;
	
	@Autowired
	private ResourceCountRepository resourceCountRepository;

	@Override
	public HexaDataPull findById(Long id) {
		return hexaDataPullRepository.findOne(id);
	}

	@Override
	public HexaDataPull findByName(String name) {
		return hexaDataPullRepository.findByResName(name);
	}

	@Override
	public void saveUser(HexaDataPull user) {
		hexaDataPullRepository.save(user);
	}

	@Override
	public void updateUser(HexaDataPull user) {
		saveUser(user);
	}

	@Override
	public void deleteUserById(Long id) {
		hexaDataPullRepository.delete(id);
	}

	@Override
	public void deleteAllUsers() {
		hexaDataPullRepository.deleteAll();
	}

	@Override
	public List<HexaDataPull> findAllUsers() {
		return hexaDataPullRepository.findAll();
	}

	@Override
	public boolean isUserExist(HexaDataPull user) {
		return findByName(user.getResName()) != null;
	}
	
	/*public List<HexaDataPull> getBillableConsultants(String resType) {
		return hexaDataPullRepository.getBillable(resType);
	}
	
	public List<ResourceMaster> getLocationWiseUsers() {
		return resourceMasterRepository.getLocationCount();
	}
	
	public List<ResourceMaster> getProjTypeBillUsers(String resType) {
		return resourceMasterRepository.getProjTypeBillCount(resType);
	}*/
	
	public List<ResourceMonthlyCount> getResourceCount(String month, String dataTypeCd) {
		if(dataTypeCd.equalsIgnoreCase("ATTR")) {
			return resourceCountRepository.getAttrChartData(month, dataTypeCd);
		}
		return resourceCountRepository.getResourceCount(month, dataTypeCd);
	}
}