package bean;

public class Admin {

	//管理者ID
	private String adminid;

	//管理者ログイン用パスワード
	private String password;

	//コンストラクター
	public Admin(){
		this.adminid = null;
		this.password = null;
	}


	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

