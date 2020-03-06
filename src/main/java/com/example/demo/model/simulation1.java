package com.example.demo.model;

public class simulation1 {

	private boolean cancer;
	private String ctype;
	private int cstage;
	private boolean chemo;
	private boolean medication;
	private boolean disease;
	private boolean smoker;
	private boolean operation;
	private boolean fclass;
	
	public simulation1(boolean cancer, String ctype, int cstage, boolean chemo, boolean medication, boolean disease,
			boolean smoker, boolean operation, boolean fclass) {
		super();
		this.cancer = cancer;
		this.ctype = ctype;
		this.cstage = cstage;
		this.chemo = chemo;
		this.medication = medication;
		this.disease = disease;
		this.smoker = smoker;
		this.operation = operation;
		this.fclass = fclass;
	}
	public boolean isCancer() {
		return cancer;
	}
	public void setCancer(boolean cancer) {
		this.cancer = cancer;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public int getCstage() {
		return cstage;
	}
	public void setCstage(int cstage) {
		this.cstage = cstage;
	}
	public boolean isChemo() {
		return chemo;
	}
	public void setChemo(boolean chemo) {
		this.chemo = chemo;
	}
	public boolean isMedication() {
		return medication;
	}
	public void setMedication(boolean medication) {
		this.medication = medication;
	}
	public boolean isDisease() {
		return disease;
	}
	public void setDisease(boolean disease) {
		this.disease = disease;
	}
	public boolean isSmoker() {
		return smoker;
	}
	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}
	public boolean isOperation() {
		return operation;
	}
	public void setOperation(boolean operation) {
		this.operation = operation;
	}
	public boolean isFclass() {
		return fclass;
	}
	public void setFclass(boolean fclass) {
		this.fclass = fclass;
	}
	
}
