package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import core.EmailService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private EmailService emailService;
	public UserManager(UserDao userDao,EmailService emailService) {
		super();
		this.userDao = userDao;
	    this.emailService=emailService;
	}

	@Override
	public void add(User user) {
		//if(userValidate(user)) {
			userDao.add(user);
			emailService.send(user.getEmail(),"Kayýt oldunuz.");
			System.out.println("Kullanýcý oluþturuldu.");
	//	}
			
		
	}

	@Override
	public void update(User user) {
		if(userValidate(user)) {
			userDao.update(user);	
		}
		
		
	}

	@Override
	public void delete(int userId) {	
		userDao.delete (userId);	
	}
	

	@Override
	public List<User> getAll() {
	for (User user : userDao.getAll()) {
		System.out.println(user.getId() + " " + user.getEmail() + " "+ user.getFullName());
		
		
	}
	return userDao.getAll();
		
		
	}
	
	public boolean userValidate(User user) {
		if(user.getFirstName().length() >= 2&&user.getLastName().length() >=2 ) {
			return true;
		 
		}
		System.out.println("Adýnýz ve soyadýnýz minimum 2 karakter olmalý. ");
		return false;
	}

	@Override
	public User get(String email) {
		return userDao.get(email);
		
	}

	@Override
	public void add(String email) {
		User user = new User();
		user.setEmail(email);
		userDao.add(user);
		System.out.println("Log2 : " + user.getEmail());
		emailService.send(email, "Kayýt oldunuz.");
		
	}

}
