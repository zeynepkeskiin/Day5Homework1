package business.concretes;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import core.utils.Utils;
import entities.concretes.LoginDto;
import entities.concretes.User;

public class AuthManager implements AuthService{
	UserService userService;

	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
		
	}



	@Override
	public void register(User user) {
		if(userValidate(user) && passwordValidate(user.getPassword()) && userExists(user.getEmail()) ==false && Utils.emailValidate(user.getEmail())) {
			userService.add(user);
		}
		else {
		System.out.println("Kay�t ba�ar�s�z!");
	}
		
		}
	
	@Override
	public void verify(User user,String token) {
		if(user!= null&& token.length() > 15) {
			User existUser = userService.get(user.getEmail());
			existUser.setVerify(true);
			
			userService.update(existUser);
			System.out.println("Email do�ruland�.");
		}
		else {
			System.out.println("Email do�rulanmad�.");
		}
			
	}

	@Override
	public boolean userExists(String email) {
		if(userService.get( email) !=null) {
			return true;
			
		}
		System.out.println("Email zaten mevcut.");
		return false;
	}

	@Override
	public void login(LoginDto dto) {
		User user = userService.get(dto.getEmail());
		if(user!= null && user.getPassword().equals(dto.getPassword())) {
			System.out.println("Ba�ar�yla giri� yapt�n�z.");
		}
		else{
			System.out.println("Kullan�c� ad� veya �ifren yanl��.");
		}
	}
	public boolean userValidate(User user) {
	
		if (user!=null && user.getFirstName().isEmpty() && !user.getLastName().isEmpty()&& !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
			return true;
		}
		System.out.println("Bo� alan b�rakmay�n�z.");
		return false;
		
	}
	public boolean passwordValidate(String password) {
		if(password.length()>=6){
			return true;
			
		}
		
		System.out.println("�ifreniz 6 karakterden daha uzun olmal�d�r. ");
		return false;
		
		

	}





}
