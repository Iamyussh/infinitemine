package com.java.jsp;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class ResolveComplaintConsole {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Resolve Complaint");

        System.out.print("Complaint ID: ");
        String complaintID = scanner.nextLine();

        System.out.print("Resolve Date (yyyy-MM-dd HH:mm:ss): ");
        String resolveDateStr = scanner.nextLine();
        Timestamp resolveDate = Timestamp.valueOf(resolveDateStr);

        System.out.print("Resolved By: ");
        String resolvedBy = scanner.nextLine();

        System.out.print("Comments: ");
        String comments = scanner.nextLine();

        Resolve resolve = new Resolve();
        resolve.setComplaintID(complaintID);
        resolve.setResolveDate(resolveDate);
        resolve.setResolvedBy(resolvedBy);
        resolve.setComments(comments);

        // Instantiate your ComplaintDAO implementation and call resolveComplaintDao
        ComplaintDAO complaintDAO = new ComplaintDAOImpl();
        
        String result = complaintDAO.resolveComplaintDao(complaintID, resolve);
        System.out.println(result);

        scanner.close();
    }
}
