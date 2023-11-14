package com.java.jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class ComplaintDAOImpl implements ComplaintDAO{
	Connection con;
	PreparedStatement pst;

	@Override
	public List<Complaint>showComplaintDAO() throws ClassNotFoundException, SQLException {
		
		con = ConnectionHelper.getConnection();
		String cmd = "Select * from complaint";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		
		
		List<Complaint> comp = new ArrayList<Complaint>();
		Complaint complaint = null;
		
		while(rs.next()) {
			complaint = new Complaint();
			complaint.setComplaintid(rs.getString("complaintid"));
			complaint.setComplaintType(rs.getString("ComplaintType"));
			complaint.setCDescription(rs.getString("CDescription"));
			complaint.setSeverity(rs.getString("severity"));
			complaint.setStatus(rs.getString("Status"));
			complaint.setComplaintDate(rs.getTimestamp("complaintDate"));
			
			comp.add(complaint);
			
			
		}
		return comp;

		
	}

	

	@Override
	public Complaint searchComplaintDAO(String complaintid) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Select * from complaint where complaintID =?";
		pst = con.prepareStatement(cmd);
		pst.setString(1, complaintid);
		ResultSet rs = pst.executeQuery();
		Complaint complaint = null;
		while(rs.next()) {
			
			complaint = new Complaint();
			complaint.setComplaintid(rs.getString("complaintid"));
			complaint.setComplaintType(rs.getString("ComplaintType"));
			complaint.setCDescription(rs.getString("CDescription"));
			complaint.setSeverity(rs.getString("severity"));
			complaint.setStatus(rs.getString("Status"));
			complaint.setComplaintDate(rs.getTimestamp("complaintDate"));
			
		}
		return complaint;
		
	}
	
	public String generateComplaintId() throws ClassNotFoundException, SQLException  {

		con=ConnectionHelper.getConnection();

		String ComplaintId = "C000";

		String cmd = "Select  max(ComplaintId) cid from Complaint";

        pst= con.prepareStatement(cmd);

		ResultSet rs = pst.executeQuery();

		rs.next();

		String complainid = rs.getString("cid");

		int num = Integer.parseInt(complainid.substring(1));

		num++;

		String incrementComplaintId = String.format("C%03d", num);

		return incrementComplaintId;	

	}

	@Override
	public String addComplaintDAO(Complaint complaint) throws ClassNotFoundException, SQLException {
		String id  = generateComplaintId();
		con = ConnectionHelper.getConnection();
		String cmd = "Insert into complaint(complaintid,ComplaintType,CDescription,Severity,Status)"
				+ "values(?,?,?,?,?)";
		pst= con.prepareStatement(cmd);
		pst.setString(1, id);
		pst.setString(2, complaint.getComplaintType());
		pst.setString(3, complaint.getCDescription());
		pst.setString(4, complaint.getSeverity());
		pst.setString(5,"PENDING");
	
		pst.executeUpdate();
		
		return "complaint was added...";
	}
	
	public int generateResolveID() throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		String cmd ="select case when max(ResolveID) IS NULL THEN 1 else "
				+ " max(ResolveID)+1 end accno from Resolve";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accno = rs.getInt("accno");
		
		return accno;
	}
	
	@Override
	public String resolveComplaintDao(String complaintID, Resolve resolve) throws ClassNotFoundException, SQLException {
		con = ConnectionHelper.getConnection();
		Complaint complaintFound = searchComplaintDAO(resolve.getComplaintID());
		if (complaintFound.getStatus().equals("PENDING")) {
			String cmd = "UPDATE Complaint SET Status='RESOLVED' where ComplaintID=?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, resolve.getComplaintID());
			pst.executeUpdate();
			
			int ResolveID = generateResolveID();
			cmd = "INSERT INTO Resolve (ResolveID, ComplaintID, ResolveDate,ResolvedBy,Comments) VALUES (?,?,?,?,?);";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, ResolveID);
			pst.setString(2, complaintFound.getComplaintid());
			
			pst.setTimestamp(3, resolve.getResolveDate());
			pst.setString(4, resolve.getResolvedBy());
			pst.setString(5, resolve.getComments());
			pst.executeUpdate();
			return "Complain Resolved";
		}else 
		{
			return "Complaint Not Found";
		}
	}



	@Override
	public List<Resolve> showResolveDAO() throws ClassNotFoundException, SQLException {
			con  = ConnectionHelper.getConnection();
			String cmd = "Select * from resolve";
			pst = con.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			
			
			List<Resolve> res = new ArrayList<Resolve>();
			Resolve resolve = null;
			
			while(rs.next()) {
				resolve  = new Resolve();
				
				resolve.setResolveID(rs.getString("ResolveID"));
				resolve.setComplaintID(rs.getString("complaintid"));
				resolve.setComplaintDate(rs.getTimestamp("complaintDate"));
				resolve.setResolveDate(rs.getTimestamp("ResolveDate"));
				resolve.setResolvedBy(rs.getString("ResolvedBy"));
				resolve.setComments(rs.getString("Comments"));
				
				
				res.add(resolve);
			}
			
			return res;
			
			
	}
	
	
	
	
	
	

}
