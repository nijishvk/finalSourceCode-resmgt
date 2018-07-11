package com.hexa.resmgt.springboot.repositories;

import com.hexa.resmgt.springboot.model.HexaDataPull;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HexaDataPullRepository extends JpaRepository<HexaDataPull, Long> {
	HexaDataPull findByResName(String resName);
	
	@Query("select distinct(u.projectName), count(u.resType) from HexaDataPull u where u.resType = :resType GROUP BY u.projectName")
	List<HexaDataPull> getBillable(@Param("resType") String resType);
}
