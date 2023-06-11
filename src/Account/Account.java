package Account;

public class Account {
	private String username;
	private String passwords;
	private String ChucVu; 
	public Account() {}
	public Account(String username, String passwords, String ChucVu) {
		this.username = username;
		this.passwords = passwords;
		this.ChucVu = ChucVu;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String ChucVu) {
		this.ChucVu = ChucVu;
	}
	
}
