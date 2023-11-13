package infinite.Agent.dashboard;

public class Agent {
	private int agentId;
	private String Name;
	private String city;
	private double premium;
	private int maritalstatus;
	private Gender gender;
	
	public Agent(int agentId, String name, String city, double premium, int maritalstatus, Gender gender) {
		super();
		this.agentId = agentId;
		Name = name;
		this.city = city;
		this.premium = premium;
		this.maritalstatus = maritalstatus;
		this.gender = gender;
	}
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", Name=" + Name + ", city=" + city + ", premium=" + premium
				+ ", maritalstatus=" + maritalstatus + ", gender=" + gender + "]";
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public int getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(int maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	
	
}