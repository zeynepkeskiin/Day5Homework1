package core;

import googleEmail.GoogleMailManager;

public class GoogleMailManagerAdapter implements EmailService{
private GoogleMailManager googleMailManager;

public  GoogleMailManagerAdapter() {
	googleMailManager = new GoogleMailManager();
	
}

	@Override
	public void send(String email, String password) {
      googleMailManager.send(email, password);
		
	}
	

}
