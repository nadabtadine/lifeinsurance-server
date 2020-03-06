package com.example.demo.utils;

import com.example.demo.model.simulation3;
import com.example.demo.model.simulation4;

public class calculator4 {
	public static double calculate(double startingprice, simulation4 s4) {
		double result=startingprice;
		if(s4.getHouse()==2) {result*=1.2;}
		if(s4.getHouse()==3) {result*=1.3;}
		if(s4.getHouse()==4) {result*=1.4;}
		if(s4.getHouse()>4) {result*=1.5;}
		if(s4.getCar()==2) {result*=1.1;}
		if(s4.getCar()==3) {result*=1.2;}
		if(s4.getCar()==4) {result*=1.3;}
		if(s4.getCar()>4) {result*=1.4;}
		return (int)result;
	}
}
