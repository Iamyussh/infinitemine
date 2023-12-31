package com.java.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import com.mysql.cj.protocol.Resultset;

public class CustomerDAOImpl implements CustomerDAO {

	PreparedStatement pst;
	Connection connection;
	
	public static int generateOtp() {
		Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	
	public static String generateResetKey() {
		int len=10;
		  String AlphaNumericString = "0123456789"
			         + "abcdefghijklmnopqrstuvxyz";
			  StringBuilder sb = new StringBuilder(len);
			  for (int i=0;i<len;i++) {
			   int index = (int)(AlphaNumericString.length()
			      * Math.random());
			   sb.append(AlphaNumericString
			      .charAt(index));
			  }
			  return sb.toString();
	}
	
	@Override
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
			connection = ConnectionHelper.getConnection();
			
			String pwd = EncryptPassword.getCode(customer.getPassword());
			
			
			String cmd = "Insert into Customer(customer_Firstname,customer_LastName,customer_UserName,"
					+ "customer_Password,customer_Email,ustomer_Status) values(?,?,?,?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, customer.getFirstName());
			pst.setString(2, customer.getLastName());
			pst.setString(3, customer.getUserName());
			pst.setString(4, pwd);
			pst.setString(5, customer.getEmail());
			pst.setString(6, "Otp pending");
			pst.executeUpdate();
			
			
			Customer customerfound = searchByUserName(customer.getUserName());
			int id = customerfound.getCustomerId();
			
			
		
			int otp = generateOtp();
			System.out.println(otp);
			Date obj = new Date();
			java.sql.Date sqlDate = new java.sql.Date(obj.getTime());
			cmd = "Insert into otp(CUST_ID,OptCode,GeneratedOn) values(?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, id);
			pst.setInt(2, otp);
			pst.setDate(3, sqlDate);
			pst.executeUpdate();
			System.out.println("data inserted to otp table");
			String body ="Welcome to Mr/Miss  " +customer.getFirstName() + "\r\n"+
					"Your OTP Generated Successfully..." +"\r\n" + 
					"OTP is " +otp;
			MailSend.mailOtp(customer.getEmail(), "Otp Send Succesfully...", body);
			return "Otp send to mail...";
	}		
		

	
	@Override
	public Customer searchByUserName(String userName) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer where customer_UserName=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, userName);
		ResultSet rs = pst.executeQuery();
		Customer customer = null;
		if (rs.next()) {
			customer = new Customer();
			customer.setCustomerId(rs.getInt("Cust_ID"));
			customer.setFirstName(rs.getString("customer_Firstname"));
			customer.setLastName(rs.getString("customer_LastName"));
			customer.setUserName(rs.getString("customer_UserName"));
			customer.setPassword(rs.getString("customer_Password"));
			customer.setEmail(rs.getString("customer_Email"));
			
			customer.setStatus(rs.getString("ustomer_Status"));
		}
		return customer;
	}

	@Override
	public String ValidateOtpDAO(String username, int otp) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd ="Select OptCode from otp where CUST_ID = (Select CUST_ID from customer where Customer_UserName=?) order by Otp_id desc limit 1";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setString(1,username);
		ResultSet rs = pst.executeQuery();
		int otpfromdb=1;
		if(rs.next()) {
			otpfromdb = rs.getInt("OptCode");
		}
		System.out.println(otp);
		System.out.println(otpfromdb);
		
		if(otp==otpfromdb) {
			cmd="update customer set ustomer_Status=? where Customer_UserName=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, "ACTIVE");
			pst.setString(2, username);
			
			pst.executeUpdate();
			return "Account created";
			
		}
		else {
			return "Invalid otp";
		}
		
	}
	
	
	@Override
	public String loginDao(String username, String password) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String pwd = EncryptPassword.getCode(password);
		String cmd = "select count(*) as val from customer where customer_UserName=? and customer_Password=? and ustomer_Status='active'";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setString(1, username);
		pst.setString(2, pwd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		if (rs.getInt("val")==1) {
			return "Login Sucessfull";
		}else {
			return "Invalid Credential";
		}
	}
	
	@Override
	public String forgotpasswordDAO(String userName)throws ClassNotFoundException,SQLException{
		connection = ConnectionHelper.getConnection();
		Customer customerfound = searchByUserName(userName);
		if(customerfound!=null) {
			String code = generateResetKey();
			String cmd = "update customer set resetkey=? where customer_UserName=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1,code);
			pst.setString(2,userName);
			pst.executeUpdate();
			
			
			String body ="Welcome to Mr/Miss  " +customerfound.getFirstName() + "\r\n"+
					"Your Reset key Generated Successfully..." +"\r\n" + 
					"Reset key is " +code;
			MailSend.mailOtp(customerfound.getEmail(), "Reset key Send Succesfully...", body);
			return "Reset key send to mail...";
			
		}
		return "User not found";
	}
	
	

	@Override
	public String resetPasswordDAO( String resetKey,String username, String newPassword) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select count(*) as res from customer where resetKey=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, resetKey);
		ResultSet rs = pst.executeQuery();
		rs.next();
		System.out.println(rs.getInt("res"));
		if (rs.getInt("res")==1) {
			String pwd = EncryptPassword.getCode(newPassword);
			cmd = "update customer set Customer_Password=? where Customer_UserName=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, pwd);
			pst.setString(2, username);
			pst.executeUpdate();
			return "Password Changed";
			}else {
				return "Invalid Reset Key or UserName";
			}
	}
	
	
	
		
	
	
	
}
