package com.bank.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bank.driver.App;
import com.bank.duo.Login;
import com.bank.modal.User;

public class loginimpl implements Login{
	Scanner sc = new Scanner(System.in);
	User u= new User();

	 public void login()
	{
		 
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
				System.out.println("enter account number");
				u.setAccNo(sc.nextLong());
				System.out.println("enter password");
				u.setPswd(sc.next());
				PreparedStatement ps = con.prepareStatement("select * from user where accno=? and pswd=?");
				ps.setLong(1, u.getAccNo());
				ps.setString(2, u.getPswd());
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					System.out.println("login successful"+rs.getString(2));
					App a =new App();
					a.display(rs.getLong(3),rs.getLong(6));
					
				} else {
					System.out.println("invalid details");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
