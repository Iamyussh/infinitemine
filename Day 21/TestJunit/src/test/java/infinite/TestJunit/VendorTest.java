package infinite.TestJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class VendorTest {
		@Test
		public void testtoString() throws ParseException {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Vendor ven =  new Vendor(1,"Ayush","bbsr","ayushsaman12@gmail.com","232544243","pending",sdf.parse("2023-08-12"),5.0,"good");
			String res = "Vendor [vendorId=1, vendorName=Ayush, vendorCity=bbsr, vendorEmail=ayushsaman12@gmail.com, vendorMobile=232544243, vendorStatus=pending, vendorStartedDate=Thu Jan 12 00:08:00 IST 2023, vendorRating=5.0, vendorReview=good]";
			assertEquals(res, ven.toString());
		}
		
		@Test
		public void GettersandSetters() throws ParseException {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 
			Vendor vendor= new Vendor();
			vendor.setVendorId(1);
			vendor.setVendorCity("bbsr");
			vendor.setVendorEmail("ayus@gmai.com");
			vendor.setVendorMobile("423235254353");
			vendor.setVendorRating(4);
			vendor.setVendorReview("good");
				vendor.setVendorName("Ayush");
			vendor.setVendorStartedDate(sdf.parse("2023-06-06"));
			vendor.setVendorStatus("pending");
			
			assertEquals(1,vendor.getVendorId());
			assertEquals("Ayush", vendor.getVendorName());
			assertEquals("bbsr", vendor.getVendorCity());
			assertEquals("ayus@gmai.com",vendor.getVendorEmail());
			assertEquals("423235254353",vendor.getVendorMobile());
			assertEquals("good", vendor.getVendorReview());
			assertEquals(sdf.parse("2023-06-06"), vendor.getVendorStartedDate());
			assertEquals(4, vendor.getVendorRating(),0);
			assertEquals("pending",vendor.getVendorStatus());
			
			
			

		}
		@Test
	    public void testHashCode() {
	        Vendor vendor1 = new Vendor(1, "Vendor1", "City1", "email1", "mobile1", "Active", new Date(), 4.5, "Good");
	        Vendor vendor2 = new Vendor(1, "Vendor1", "City1", "email1", "mobile1", "Active", new Date(), 4.5, "Good");

	        
	        assertEquals(vendor1.hashCode(), vendor2.hashCode());
	    }
		
		
		@Test
		public void TestConstructor() throws ParseException {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				Vendor vendor = new Vendor();
				assertNotNull(vendor);
				Date std = sdf.parse("2023-08-12");
				
				Vendor ven =  new Vendor(1,"Ayush","bbsr","ayushsaman12@gmail.com","232544243","pending",sdf.parse("2023-08-12"),4.00,"good");
				assertEquals(1,ven.getVendorId());
				assertEquals("Ayush",ven.getVendorName());
				assertEquals("bbsr",ven.getVendorCity());
				assertEquals("ayushsaman12@gmail.com",ven.getVendorEmail());
				assertEquals("232544243",ven.getVendorMobile());
				assertEquals("pending",ven.getVendorStatus());
				assertEquals(std, ven.getVendorStartedDate());
				assertEquals(4.00, ven.getVendorRating(),0);
				assertEquals("good",ven.getVendorReview());
				
			}
		
		
		
		
		
}
