package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDAccount extends BankAccount {
	//variable
    public CDOffering offering = new CDOffering(1, 0.01);
    
    //constructor
    public CDAccount(CDOffering offering, double openingBalance){
        super(openingBalance, offering.getInterestRate());
        this.offering = offering;
    }
    
    public CDAccount(int accountNum, double balance, double interest
    		, java.util.Date accountOpenedOn, int term) {
    	super(accountNum, balance, interest, accountOpenedOn);
    	this.offering.setTerm(term);
    	this.offering.setInterestRate(interest);
    }
    //getter
    public int getTerm(){
        return this.offering.getTerm();
    }
    //read from file
    static CDAccount readFromString(String accountData) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    	try {
    	String array1[] = accountData.split(",");
    	int fAccount = Integer.parseInt(array1[0]);
    	double fBalance = Double.parseDouble(array1[1]);
    	double fInterest = Double.parseDouble(array1[2]);
    	Date fDate = dateFormatter.parse(array1[3]);
    	int fTerm = Integer.parseInt(array1[4]);
    	
    	CDAccount cda = new CDAccount(fAccount, fBalance
    			, fInterest, fDate, fTerm);
    	return cda;
    	} catch (ParseException e) {
    		return null;
    	}
    }
    
    // override from BankAccount withdraw , deposit can't add and remove from cd account
    public boolean withdraw(double amount){
        return false;
    }
	
	public boolean deposit(double amount) {
        return false;
    }
	
	public double futureValue() {
		double pv = this.getBalance();
        double fv = pv * (Math.pow((1 + this.getInterestRate()), this.offering.getTerm()));
        return fv;
	}
	@Override
	public String writeToString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
    	return this.getAccountNumber() + "," + this.getBalance() + "," + this.getInterestRate()
    			+ "," + dateFormatter.format(this.getOpenedOn()) + "," + this.getTerm();
    }
}
