package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.simulation1;
import com.example.demo.model.simulation2;
import com.example.demo.model.simulation3;
import com.example.demo.model.simulation4;
import com.example.demo.utils.calculator1;
import com.example.demo.utils.calculator2;
import com.example.demo.utils.calculator3;
import com.example.demo.utils.calculator4;

@Service
public class SimulatorService {

	public double getResult1(simulation1 s1) {
		double initialprice=420,result = 0;
		result=calculator1.calculate(initialprice, s1);
		return result;
	}
	public double getResult2(simulation2 s2) {
		double initialprice=700,result = 0;
		result=calculator2.calculate(initialprice, s2);
		return result;
	}
	public double getResult3(simulation3 s3) {
		double initialprice=340,result = 0;
		result=calculator3.calculate(initialprice, s3);
		return result;
	}
	public double getResult4(simulation4 s4) {
		double initialprice=250,result = 0;
		result=calculator4.calculate(initialprice, s4);
		return result;
	}
}
