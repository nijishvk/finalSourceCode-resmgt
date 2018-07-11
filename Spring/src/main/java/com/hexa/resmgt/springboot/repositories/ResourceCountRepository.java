package com.hexa.resmgt.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexa.resmgt.springboot.model.ResourceMonthlyCount;

@Repository
public interface ResourceCountRepository extends JpaRepository<ResourceMonthlyCount, Long> {
	
	@Query("select rmc from ResourceMonthlyCount rmc where rmc.monthName = :monthName and dataTypeCd = :dataTypeCd")
	List<ResourceMonthlyCount> getResourceCount(@Param("monthName") String monthName, @Param("dataTypeCd") String dataTypeCd);
	
	@Query("select rmc from ResourceMonthlyCount rmc where dataTypeCd = :dataTypeCd and updatedDate <= (select updatedDate from ResourceMonthlyCount where monthName = :monthName AND dataTypeCd = :dataTypeCd) order by updatedDate desc ")
	List<ResourceMonthlyCount> getAttrChartData(@Param("monthName") String monthName, @Param("dataTypeCd") String dataTypeCd);

}