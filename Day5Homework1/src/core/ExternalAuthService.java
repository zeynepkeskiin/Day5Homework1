package core;

import entities.concretes.LoginDto;

public interface ExternalAuthService {
	void registar(String email);
	boolean userExists(String email);
	void login(LoginDto dto);

}
