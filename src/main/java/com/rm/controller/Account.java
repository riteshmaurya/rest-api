package com.rm.controller;

import java.io.Serializable;
import java.math.BigDecimal;


public class Account  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 294922045994989284L;


	
	private int accountId;
	
	private String accountType;
	
	private BigDecimal accountBalance;
	
	
	public Account(){}

	public Account(int accountId, String accountType, BigDecimal accountBalance) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
}
