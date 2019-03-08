package com.bank.driver;

import java.util.Scanner;

import com.bank.daoimpl.Registerimpl;
import com.bank.daoimpl.Transimpl;
import com.bank.daoimpl.loginimpl;
import com.bank.modal.User;

public class App {
	static Scanner sc = new Scanner(System.in);
	Transimpl t=new Transimpl();
	public void display(long aadhar,long balance)
	{
		long adar=aadhar;
		long bal=balance;
		System.out.println("1.withdraw 2.deposit 3.balance");
		int i=sc.nextInt();
		switch(i)
		{
		case 1:
		t.withdraw(adar,bal);
			break;
		case 2:
		t.deposit(adar,bal);
			break;
		case 3:
			t.balance(adar,bal);
			break;
		}
	}
	public static void main(String[] args) {
		
		Registerimpl rg = new Registerimpl();
		loginimpl li = new loginimpl();
		System.out.println("1.login 2.register");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:li.login();
		
		
		break;
		case 2: rg.Register();
		break;
		}
		
	}
}
