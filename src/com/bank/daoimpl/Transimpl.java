package com.bank.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bank.duo.Transcation;
import com.bank.modal.User;

public class Transimpl implements Transcation{
	Scanner sc = new Scanner(System.in);
	User u = new User();

	

	@Override
	public void deposit(long aadhar, long balance) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			System.out.println("enter amount");
			long amt=sc.nextLong();
			
			balance=amt+balance;
			u.setBalance(balance);
			PreparedStatement ps = con.prepareStatement("update user set salary=? where aadhar=?");
			ps.setLong(1, u.getBalance());
			ps.setLong(2, aadhar);
			int i=ps.executeUpdate();
			System.out.println(u.getBalance());
			if(i==1)
			{
				System.out.println("done");
			}else {
				System.out.println("error");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public void withdraw(long aadhar, long balance) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			System.out.println("enter amount");
			long amt=sc.nextLong();
			if(amt<balance) {
				balance=balance-amt;
				u.setBalance(balance);
			}else
			{
				System.out.println("insufficient amount to withdraw");
			}
			
			PreparedStatement ps = con.prepareStatement("update user set salary=? where aadhar=?");
			ps.setLong(1, u.getBalance());
			ps.setLong(2, aadhar);
			int i=ps.executeUpdate();
			System.out.println();
			if(i==1)
			{
				System.out.println("done");
			}else {
				System.out.println("error");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public void balance(long aadhar,long balance)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			PreparedStatement ps = con.prepareStatement("select salary from user where aadhar=?");
			ps.setLong(1, aadhar);
		System.out.println("balance is "+balance);
		ps.executeQuery();
	
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
