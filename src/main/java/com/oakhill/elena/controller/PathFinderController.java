package com.oakhill.elena.controller;

import java.util.Optional;

import com.oakhill.elena.configuration.OpenStreetServiceConfig;
import com.oakhill.elena.model.Path;
import com.oakhill.elena.model.RequestData;
import com.oakhill.elena.model.ReturnData;
import com.oakhill.elena.service.intf.PathFinderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PathFinderController
 */
@CrossOrigin
@RestController
public class PathFinderController {

	@Autowired
	PathFinderService pathFinderService;
	@Autowired
	OpenStreetServiceConfig openStreetServiceConfig;

	/**
	 * Returns ReturnData with min/max elevation path
	 * @param reqData Object of arguments passed from the frontend
	 */
	@PostMapping("/getElenaRoutes")
	@ResponseBody
	public ReturnData<Path> getElenaRoutes(@RequestBody Optional<RequestData> reqData) {
		RequestData data = reqData.get();
		if (data == null || data.getEnd() == null || data.getStart() == null) {
			return ReturnData.fail(HttpStatus.BAD_REQUEST);
		}
		return ReturnData.success(pathFinderService.getElenaPathWithWeight(data));
	}

}
