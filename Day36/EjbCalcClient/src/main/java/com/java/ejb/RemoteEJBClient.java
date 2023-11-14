package com.java.ejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RemoteEJBClient {
	
	public static void main(String[] args) {
	
	}
	
	
	private static Context createInitialContext() throws NamingException{
		
		Properties jndiproperties = new Properties();
		jndiproperties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		
		jndiproperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		jndiproperties.put(Context.PROVIDER_URL, 
				"http-remoting://localhost:8080");
		
		
		jndiproperties.put("jboss.naming.client.ejb.properties", true);
		return new InitialContext(jndiproperties);
		
		
	}
	
	
		private static CalculationRemote lookupRemoteStatelessCalculator() throws NamingException {
			Context ctx = createInitialContext();
			final String distinctName="";
			  final String beanName = "Calculation";
		        System.out.println(beanName);
		        
		        final String viewClassName = CalculationRemote.class.getName();
		        String appName = "";
	            String moduleName = "EjbCalcPractice";
	            
	            return (CalculationRemote) ctx.lookup("ejb:" 
	                    + appName + "/" + moduleName 
	                    + "/" + distinctName + "/" + beanName + "!" + viewClassName);
			
			
			
		}
		
		 private static void invokeStatelessBean() throws NamingException {
			 
			 final CalculationRemote statelessRemoteCalculator = lookupRemoteStatelessCalculator();
		        System.out.println("Obtained a remote stateless calculator for invocation");
		        
		        int a = 204;
		        int b = 340;
		        System.out.println("Adding " + a + " and " + b + " via the remote stateless calculator deployed on the server");
		        int sum = statelessRemoteCalculator.sum(a, b);
		        System.out.println("Remote calculator returned sum = " + sum);
		        if (sum != a + b) {
		        	 throw new RuntimeException("Remote stateless calculator returned an incorrect sum " + sum + " ,expected sum was " + (a + b));
		        }
		        
		        int num1 = 3434;
		        int num2 = 2332;
		        System.out.println("Subtracting " + num2 + " from " + num1 + " via the remote stateless calculator deployed on the server");
		        int difference = statelessRemoteCalculator.sub(num1, num2);
		        System.out.println("Remote calculator returned difference = " + difference);
		        if (difference != num1 - num2) {
		            throw new RuntimeException("Remote stateless calculator returned an incorrect difference " + difference + " ,expected difference was " + (num1 - num2));
		        }
		        
		 }

}
