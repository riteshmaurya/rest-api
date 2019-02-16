package com.rm.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/v1")
class AccountsController {
	
	@Autowired
	private AccountServices accountServices;
	
	@RequestMapping(value="/getaccount/{id}", method=RequestMethod.GET)
	public Account getAccountById(@PathVariable("id") int id){
		System.out.println("%%%%%%%%%%%%%%%");
		System.out.println(id);
		return this.accountServices.getByAccountById(id);
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public int create(@RequestBody Account account){
		Objects.requireNonNull(account);
		return this.accountServices.addAccount(account);
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(Account account){
		this.accountServices.delete(account);
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Account> getAllAccounts(){
		return this.accountServices.getAccounts();
	}
	
	@RequestMapping(value="/update")
	public void update(@RequestBody Account account){
		this.accountServices.update(account);
	}
	
}
