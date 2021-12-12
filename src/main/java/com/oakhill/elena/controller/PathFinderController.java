package com.oakhill.elena.controller;

import java.util.Optional;

import com.oakhill.elena.configuration.OpenStreetServiceConfig;
import com.oakhill.elena.model.Path;
import com.oakhill.elena.model.RequestData;
import com.oakhill.elena.service.intf.PathFinderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathFinderController {

	@Autowired
	PathFinderService pathFinderService;
	@Autowired
	OpenStreetServiceConfig openStreetServiceConfig;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

		System.out.println(openStreetServiceConfig.getApi_key());
		return String.format("Hello %s!", name);
	}

	@GetMapping("/optionalTesting")
	@ResponseBody
	public Path optionalTesting(@RequestBody Optional<RequestData> reqData) {
		RequestData data = reqData.get();
		double[][] routes = new double[][]{data.getStart(), data.getEnd()};
		System.out.println(data.getWeight());
		return new Path(routes);
	}

	@GetMapping("/get2dShortestPath")
	@ResponseBody
	public Path get2dShortestPath(@RequestBody Optional<RequestData> reqData) {
		
		return pathFinderService.get2dShortestPathSerive();
	}

}
