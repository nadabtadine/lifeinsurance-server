package com.example.demo.utils;

import com.example.demo.model.simulation1;
import com.example.demo.model.simulation2;

public class calculator2 {
	public static double calculate(double startingprice, simulation2 s2) {
		double result=startingprice;
		if(s2.getNchildren()>=2) {result*=1.1;}
		if(s2.getIncome()>=2000) {result*=1.2;}
		return (int)result;
	}
}
