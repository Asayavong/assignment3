package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CDOffering {
	//variable
	private int term;
    private double interestRate;
    
    //constructor

    public CDOffering(int term, double interestRate){
        this.term = term;
        this.interestRate = interestRate;
    }
    
    //getters

    public int getTerm(){
        return this.term;
    }

    public double getInterestRate(){
        return this.interestRate;
    }
    //setters
    
    public void setTerm(int term) {
    	this.term = term;
    }
    
    public void setInterestRate(double interest) {
    	this.interestRate = interest;
    }

    public String toString(){
        return "Term: " + this.getTerm() + " Interest Rate: " + this.getInterestRate();
    }
    //read and write logic
    static CDOffering readFromString(String accountData) {
    	
    	String array1[] = accountData.split(",");
    	int fTerm = Integer.parseInt(array1[0]);
    	double fInterest = Double.parseDouble(array1[1]);
    	
    	CDOffering offeringX = new CDOffering(fTerm, fInterest);
    	return offeringX;
    	
    }
	
	public String writeToString() {
    	return this.term + "," + this.interestRate;
    }
}
