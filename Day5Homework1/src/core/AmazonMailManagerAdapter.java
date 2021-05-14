package core;

import amazonEmail.AmazonMailManager;

public class AmazonMailManagerAdapter implements EmailService{

	 private AmazonMailManager amazonMailManager ;
	 
	public AmazonMailManagerAdapter() {
		
	amazonMailManager = new AmazonMailManager();
	}

	@Override
	public void send(String email, String password) {
		amazonMailManager.send(email, password);
	}

}
