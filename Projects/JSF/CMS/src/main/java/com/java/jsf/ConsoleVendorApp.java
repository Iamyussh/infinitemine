package com.java.jsf;

import java.util.List;

public class ConsoleVendorApp {
    public static void main(String[] args) {
        // Create an instance of VendorDAOImpl
        VendorDAO vendorDAO = new VendorDAOImpl();

        // Call the showVendorNames method to retrieve the list of vendor names
        List<String> vendorNames = vendorDAO.showVendorNames();

        // Print the vendor names
        System.out.println("Vendor Names:");
        for (String name : vendorNames) {
            System.out.println(name);
        }
    }
}
