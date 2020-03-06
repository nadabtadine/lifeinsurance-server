package com.example.demo.utils;

import com.example.demo.model.simulation1;
import com.example.demo.model.simulation3;

public class calculator3 {
	public static double calculate(double startingprice, simulation3 s3) {
		double result=startingprice;
		if(s3.isAbroad()==true) {result*=2;}
		if(s3.getEl()=="b") {result*=1.1;}
		if(s3.getEl()=="m") {result*=1.2;}
		if(s3.getEl()=="d") {result*=1.3;}
		if(s3.getMajor()=="Medicine") {result*=1.4;}
		if(s3.getMajor()=="Engineering") {result*=1.2;}
		if(s3.isVolunteer() || s3.isClubm()){result*=0.8;}
		return (int)result;
	}
}
