package fr.dawan.eventhub.form;

public class LoginForm {
	
	private String email;
	private String password;
	
	public LoginForm(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public LoginForm() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
