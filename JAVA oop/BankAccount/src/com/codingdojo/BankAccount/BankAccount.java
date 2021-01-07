package com.codingdojo.BankAccount;
import java.util.*;

public class BankAccount {
	
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	static int accountsCount = 0;
	static double moneytotal = 0;
	
	public BankAccount() {
		accountsCount++;
		this.accountNumber = RandomaccNum();
		this.checkingBalance = 0.0;
		this.savingsBalance = 0.0;
		
	}
	
	private String RandomaccNum(){
		Random random = new Random();
		String accountNumber = "";
	
		for (int a = 0; a < 10; a++) {
			accountNumber += random.nextInt(9);
		}
		return accountNumber;
		
		
	}
	
	public double getsavingsBalance() {
		return savingsBalance;
	}
	
	public double getscheckingBalance() {
		return checkingBalance;
	}
	
	public void deposit(double val, String account){
		
		if(account == "savingsBalance") {
			savingsBalance+=val;
			moneytotal+=val;
		}
		else if (account == "checkingBalance") {
			checkingBalance+=val;
			moneytotal+=val;
		}
		
	}
	
	public void withdraw(double val, String account) {
            if(account == "savingsBalance" && savingsBalance>val) {
				savingsBalance-=val;
				moneytotal-=val;
			}
		    else if (account == "checkingBalance" && checkingBalance>val) {
				checkingBalance-=val;
				moneytotal-=val;
			
			
		}
	}
	
	public double getmoneytotal() {
		return moneytotal;
	}

}
