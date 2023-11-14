package infinite.Singleton;

public class SingletonEx2 {
	private static ConnectionString cs;
	
	static {
		cs = ConnectionString.getInstance();
	}
	
	
	public static void main(String[] args) {
		System.out.println(cs.getCredentials("MySql"));
		System.out.println(cs.getCredentials("Oracle"));
		System.out.println(cs.getCredentials("SqlServer"));
	}

}
