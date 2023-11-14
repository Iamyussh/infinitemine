import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {
	public static void main(String[] args) {
		
		
		try {
			Calc calc = new CalcImpl();
			Naming.rebind("localhost", calc);
			System.out.println("Calculation server is waiting for clients...");
			
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