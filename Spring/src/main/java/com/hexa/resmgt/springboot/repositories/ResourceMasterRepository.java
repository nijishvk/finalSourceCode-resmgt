package com.hexa.resmgt.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexa.resmgt.springboot.model.ResourceMaster;

@Repository
public interface ResourceMasterRepository extends JpaRepository<ResourceMaster, Long> {
	
	@Query("select distinct(rm.location.name), count(rm.location.name) from ResourceMaster rm where rm.location.type = 'PRENT_LOCTN' GROUP BY rm.location.name")
	List<ResourceMaster> getLocationCount();
	
	@Query("select distinct(rm.billRole.name), count(rm.billRole.name) from ResourceMaster rm where rm.resType.type = 'RES_TYPE' and rm.resType.name = :resName and rm.billRole.type = 'BIL_ROLE' GROUP BY rm.billRole.name")
	List<ResourceMaster> getProjTypeBillCount(@Param("resName") String resName);
}
