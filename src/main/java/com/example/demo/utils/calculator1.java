package com.example.demo.utils;

import com.example.demo.model.simulation1;

public class calculator1 {

	public static double calculate(double startingprice, simulation1 s1) {
		double result=startingprice;
		if(s1.isCancer()==true) {
			result*=1.5;
		}
		if(s1.getCstage()==3 | s1.getCstage()==4) {
			 result*=1.2;
		 }
		 if(s1.isDisease()==true) {
			 result*=1.1;
		 }
		 if(s1.isMedication()==true) {
			 result*=1.2;
		 }
		 if(s1.isOperation()==true) {
			 result*=1.3;
		 }
		 if(s1.isFclass()==true) {
			 result*=1.4;
		 }
		return (int)result;
	}
	
}
