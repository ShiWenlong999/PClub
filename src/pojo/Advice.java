package pojo;

public class Advice {
	private String username;
	private String adv;
	private String contant;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAdv() {
		return adv;
	}
	public void setAdv(String adv) {
		this.adv = adv;
	}
	public String getContant() {
		return contant;
	}
	public void setContant(String contant) {
		this.contant = contant;
	}
	@Override
	public String toString() {
		return "Advice [username=" + username + ", adv=" + adv + ", contant=" + contant + "]";
	}
	
	
}
