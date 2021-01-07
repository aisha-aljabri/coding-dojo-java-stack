package com.codingdojo.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount B = new BankAccount();
		B.deposit(100.0, "checkingBalance");
		B.deposit(250.0, "savingsBalance");
		B.withdraw(90, "savingsBalance");
		System.out.println(B.getmoneytotal());

	}

}
