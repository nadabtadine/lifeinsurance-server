package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.simulation1;
import com.example.demo.model.simulation2;
import com.example.demo.model.simulation3;
import com.example.demo.model.simulation4;
import com.example.demo.service.SimulatorService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api3")
public class SimulationController {

	@Autowired
	SimulatorService simulatorService;
	
	@PostMapping(value = "/simulation1")
	public double post1(@RequestBody simulation1 s1) {
		return simulatorService.getResult1(s1);
	}
	@PostMapping(value = "/simulation2")
	public double post2(@RequestBody simulation2 s2) {
		return simulatorService.getResult2(s2);
	}
	@PostMapping(value = "/simulation3")
	public double post3(@RequestBody simulation3 s3) {
		return simulatorService.getResult3(s3);
	}
	@PostMapping(value = "/simulation4")
	public double post4(@RequestBody simulation4 s4) {
		return simulatorService.getResult4(s4);
	}
}
