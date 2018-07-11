package com.hexa.resmgt.springboot.service;

import java.util.List;

import com.hexa.resmgt.springboot.model.HexaDataPull;
import com.hexa.resmgt.springboot.model.ResourceMonthlyCount;

public interface HexaDataPullService {

	HexaDataPull findById(Long id);

	HexaDataPull findByName(String name);

	void saveUser(HexaDataPull user);

	void updateUser(HexaDataPull user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<HexaDataPull> findAllUsers();

	boolean isUserExist(HexaDataPull user);
	
	/*List<HexaDataPull> getBillableConsultants(String resType);
	
	List<ResourceMaster> getLocationWiseUsers();
	
	List<ResourceMaster> getProjTypeBillUsers(String resType);*/
	
	List<ResourceMonthlyCount> getResourceCount(String month, String dataTypeCd);
	
}
