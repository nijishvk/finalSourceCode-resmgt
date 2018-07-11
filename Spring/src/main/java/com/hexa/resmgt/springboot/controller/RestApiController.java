package com.hexa.resmgt.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.resmgt.springboot.model.ChartData;
import com.hexa.resmgt.springboot.model.HexaDataPull;
import com.hexa.resmgt.springboot.model.ResourceMaster;
import com.hexa.resmgt.springboot.model.ResourceMonthlyCount;
import com.hexa.resmgt.springboot.service.ChartDataService;
import com.hexa.resmgt.springboot.service.HexaDataPullService;
import com.hexa.resmgt.springboot.util.CustomErrorType;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RestApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
    @Autowired
    HexaDataPullService userService; //Service which will do all data retrieval/manipulation work
    
    @Autowired
    ChartDataService chartDataService;
    
    // -------------------Retrieve All Users---------------------------------------------
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<HexaDataPull>> listAllUsers() {
    	System.out.print("user rest controller .......");
    	logger.info("user rest controller .......");
        List<HexaDataPull> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<HexaDataPull>>(users, HttpStatus.OK);
    }
    
    
    // -------------------Retrieve Single User------------------------------------------
 
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        logger.info("Fetching User with id {}", id);
        HexaDataPull user = userService.findById(id);
        if (user == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("User with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<HexaDataPull>(user, HttpStatus.OK);
    }
    
    // ----------------------Retrieve ChartData by Chart Type
    /*@RequestMapping(value ="/attrition",method = RequestMethod.GET)
    public ResponseEntity<List<ChartData>> getAttritionCharData(){
    	List<ChartData> data = chartDataService.getChartDataByType("ATTR");
    	return new ResponseEntity<List<ChartData>>(data,HttpStatus.OK);
    }*/
    
  //  ------------------------Retrieve Billable Consultants----------------------------------------
    /*@RequestMapping(value = "/billableuser/", method = RequestMethod.GET)
    public ResponseEntity<List<HexaDataPull>> listBillableUsers() {
    	System.out.print("billable rest controller .......");
    	logger.info("billable rest controller .......");
        List<HexaDataPull> users = userService.getBillableConsultants("Billable");
        return new ResponseEntity<List<HexaDataPull>>(users, HttpStatus.OK);
    }
    
 // ---------------------------Retrieve Location-wise User count------------------------------------
    @RequestMapping(value = "/locationwiseuser/", method = RequestMethod.GET)
    public ResponseEntity<List<ResourceMaster>> listLocationWiseUsers() {
    	System.out.print("locationwiseuser rest controller .......");
    	logger.info("locationwiseuser rest controller .......");
        List<ResourceMaster> users = userService.getLocationWiseUsers();
        return new ResponseEntity<List<ResourceMaster>>(users, HttpStatus.OK);
    }
    
    // --------------Retrieve Project Type Billable Count ------------------------------------------
    @RequestMapping(value = "/projbillcount/", method = RequestMethod.GET)
    public ResponseEntity<List<ResourceMaster>> listProjTypeBillUsers() {
    	System.out.print("Project Type billable rest controller .......");
    	logger.info("Project Type billable rest controller .......");
        List<ResourceMaster> users = userService.getProjTypeBillUsers("Billable");
        return new ResponseEntity<List<ResourceMaster>>(users, HttpStatus.OK);
    }*/
    
    @RequestMapping(value = "/resourceCount/{month}/{dataTypeCd}", method = RequestMethod.GET)
    public ResponseEntity<List<ResourceMonthlyCount>> getResourceCount(@PathVariable("month") String month, @PathVariable("dataTypeCd") String dataTypeCd) {
    	System.out.print("getResourceCount rest controller ......." + month + dataTypeCd);
    	logger.info("getResourceCount rest controller .......");
        List<ResourceMonthlyCount> users = userService.getResourceCount(month, dataTypeCd);
        return new ResponseEntity<List<ResourceMonthlyCount>>(users, HttpStatus.OK);
    }
}
