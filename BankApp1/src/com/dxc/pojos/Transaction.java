package com.dxc.pojos;

public class Transaction 
{
private int accountno;
private String transactiontype;
private double balance;

public Transaction() 
{}

public Transaction(int accountno, String transactiontype, double balance) {
	this.accountno = accountno;
	this.transactiontype = transactiontype;
	this.balance = balance;
}

public int getAccountno() {
	return accountno;
}
public void setAccountno(int accountno) {
	this.accountno = accountno;
}
public String getTransactiontype() {
	return transactiontype;
}
public void setTransactiontype(String transactiontype) {
	this.transactiontype = transactiontype;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}

}
