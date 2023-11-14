import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {
	
	public static void main(String[] args) {
		
	
				Hello obj;
	
		
				
				try {
					obj = new HelloImpl();
					Naming.rebind("localhost", obj);
					System.out.println("Server is Ready...");
					System.out.println("Waiting for clients");
				}
				catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
			
		
}
}