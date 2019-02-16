package com.rm.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class AccountServices {
	
	private List<Account> accounts;
	
	public AccountServices(){
		this.accounts = createAccount();
	}
	
	//TODO Use optional instead of void in return
	public Account getByAccountById(int id){
		System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
		System.out.println("in side getByAccountById "+id);
		System.out.println("in side getByAccountById "+id);
		return this.accounts.stream().filter( t-> t.getAccountId() == id).findAny().orElse(null);
	}
	
	public void delete(Account account){
		this.accounts.removeIf(t -> t.getAccountId() == account.getAccountId());
	}
	
	public int addAccount(Account account){
		this.accounts.add(account);
		return account.getAccountId();
	}
	
	public void update(Account account){
		List<Account> newList = this.accounts.stream()
				.map(t -> t.getAccountId() == account.getAccountId() ? account : t)
				.collect(Collectors.toList());
			this.accounts = newList;
//		Account _account =  this.accounts.stream().filter(
//					t -> t.getAccountId() == account.getAccountId()
//				).findFirst().get();
		
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public List<Account> createAccount(){
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account(1001, "SAVING", BigDecimal.valueOf(2343244)));
		accounts.add(new Account(1002, "CURRENT", BigDecimal.valueOf(9763244)));
		accounts.add(new Account(1003, "FOREX", BigDecimal.valueOf(325644)));
		accounts.add(new Account(1004, "SAVING", BigDecimal.valueOf(324544)));
		accounts.add(new Account(1005, "SAVING", BigDecimal.valueOf(34545)));
		accounts.add(new Account(1006, "CURRENT", BigDecimal.valueOf(967679)));
		accounts.add(new Account(1007, "FOREX", BigDecimal.valueOf(96779)));
		accounts.add(new Account(1008, "SAVING", BigDecimal.valueOf(35867244)));
		accounts.add(new Account(1009, "CURRENT", BigDecimal.valueOf(463346)));
		accounts.add(new Account(1010, "FOREX", BigDecimal.valueOf(68545)));
		accounts.add(new Account(1011, "FOREX", BigDecimal.valueOf(57567)));
		
		return accounts;
		
	}	

}
