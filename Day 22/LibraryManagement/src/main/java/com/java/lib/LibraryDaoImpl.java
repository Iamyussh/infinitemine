package com.java.lib;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDaoImpl implements LibraryDAO {

	Connection connection;
	PreparedStatement pst;
	
	public boolean checkPassword(String pwd,String retype) {
		if(pwd.equals(retype)) {
			return true;
		}
		return false;
	}
	
	@Override
	public String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String encPwd = EncryptPassword.getCode(libUsers.getPassWord());
		String cmd = "Insert into LibUsers(UserName,Password) "
				+ " values(?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, libUsers.getUserName());
		pst.setString(2, encPwd);
		pst.executeUpdate();
		return "User Account Created...";

	}

	@Override
	public int authenticate(LibUsers libUsers) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String encr=EncryptPassword.getCode(libUsers.getPassWord());
		String cmd = "select count(*) cnt from LibUsers where userName=? AND Password=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, libUsers.getUserName());
		pst.setString(2, encr.trim());
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;

	}

	@Override
	public List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException {
		String sql;
		boolean isValid=true;
		if(searchType.equals("id")) {
			sql = " SELECT * FROM Books WHERE Id = ? " ;
		} else if(searchType.equals("bookname")) {
			sql = " SELECT * FROM Books WHERE Name = ? " ;
		} else if(searchType.equals("authorname")) {
			sql = " SELECT * FROM Books WHERE Author = ? " ;
		} else if(searchType.equals("dept")) {
			sql = " SELECT * FROM Books WHERE Dept = ? " ;
		}
		else {
			isValid=false;
			sql = " SELECT * FROM Books" ;
		}
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(sql);
		if (isValid==true) {
			pst.setString(1, searchValue);
		} 
		ResultSet rs = pst.executeQuery();
		Books books = null;
		List<Books> booksList = new ArrayList<Books>();
		while(rs.next()) {
			books = new Books();
			books.setId(rs.getInt("id"));
			books.setName(rs.getString("name"));
			books.setAuthor(rs.getString("author"));
			books.setEdition(rs.getString("edition"));
			books.setDept(rs.getString("dept"));
			books.setNoOfBooks(rs.getInt("TotalBooks"));
			booksList.add(books);
		}
		return booksList;

	}

	@Override
	public String issueBook( String username,String bookid) throws SQLException, ClassNotFoundException {
	
	        connection = ConnectionHelper.getConnection();
          
                
                String updateQuery = "INSERT INTO TranBook (Username,BookId)values(?,?)";
                pst = connection.prepareStatement(updateQuery);
                pst.setString(1, username);
                pst.setString(2, bookid);
                pst.executeUpdate();
                
                
              String  cmd="update books set TotalBooks=TotalBooks-1 where id =?";

        		pst = connection.prepareStatement(cmd);

        		pst.setString(1, bookid);

        		pst.executeUpdate();
            
		return "Book was issued";
	}

	@Override
	public List<Tranbook> userhistory(String Username) throws SQLException, ClassNotFoundException {
		connection= ConnectionHelper.getConnection();
		
		String cmd = "Select * from tranbook where Username=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, Username);
		ResultSet rs = pst.executeQuery();
		
		List<Tranbook> tran = new ArrayList<>();
		Tranbook tranbook =null;
		while(rs.next()) {
			tranbook = new Tranbook();
			
			tranbook.setUsername(rs.getString("Username"));
			tranbook.setBookId(rs.getInt("BookId"));
			tranbook.setFromdate(rs.getDate("Fromdate"));
			
			tran.add(tranbook);
		}
		return tran;
	}
	
	public Tranbook searchTranbook(String username, int BookId) throws ClassNotFoundException, SQLException {

		connection = ConnectionHelper.getConnection();

		String cmd = "SELECT * FROM tranbook where username =? and BookId=?";

		pst = connection.prepareStatement(cmd);
		pst.setString(1, username);
		pst.setInt(2, BookId);

		ResultSet rs = pst.executeQuery();

		Tranbook history = null;

		while(rs.next()) {

			history = new Tranbook();
			history.setUsername(rs.getString("Username"));
			history.setBookId(rs.getInt("BookId"));
			history.setFromdate(rs.getDate("Fromdate"));

		}

		

		return history;

	}
	
	

	@Override
	public String returnbook(String bookid, String username) throws ClassNotFoundException, SQLException {
		int id = Integer.parseInt(bookid);
		Tranbook  tran = searchTranbook(username, id);
		
		connection = ConnectionHelper.getConnection();
		
		String sql = "insert into transreturn (Username,BookId)values(?,?)";
		
		pst = connection.prepareStatement(sql);
        pst.setString(1, username);
        pst.setString(2, bookid);
      ;
        pst.executeUpdate();
		
		String cmd = "update books set TotalBooks = TotalBooks +1 where id =?";
		pst = connection.prepareStatement(cmd);
		
		pst = connection.prepareStatement(cmd);

		pst.setString(1, bookid);

		pst.executeUpdate();
		
		
		
		return "The book is returned";
	}

	
	
	
	


}
	

