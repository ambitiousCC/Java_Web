package loginBean;

public class emp {
	//关于账户对象和判断对象的方法
	private String account;
	private String password;
	private String email;
	private String name;
	public emp(String account, String password, String email, String name) {
		super();
		this.account = account;
		this.password = password;
		this.email = email;
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
