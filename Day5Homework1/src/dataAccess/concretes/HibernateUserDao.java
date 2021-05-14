package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao{
	List<User>users = new ArrayList<User>();
	
	public  HibernateUserDao() {
		super();
		User user1= new User(1,"Zeynep","Keskin","zeyzey45@outlook.com","123456",true);
		User user2= new User(2,"Mustafa","Sarý","mustafasarýlý@outlook.com","7891011",true);
		User user3= new User(3,"Ayþe","Yýldýrým","ayseyldrm@outlook.com","654321",true);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	}

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Hibernate ile eklendi " + user.getEmail());
	}

	@Override
	public void update(User user) {
		User userToUpdate = users.stream().filter(u ->user.getId()==user.getId()).findFirst().orElse(null);
		
		
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setVerify(user.isVerify());
	
	}

	@Override
	public void delete(int userId) {
		User userToDelete = users.stream().filter(u -> u.getId() ==userId).findFirst().orElse(null);
		
		users.remove(userToDelete);
	

	
}		

	@Override
	public List<User> getAll() {
	
		return users;
	}

	@Override
	public User get(String email) {
		User user =users.stream().filter(u -> u.getEmail()==email).findFirst().orElse(null);
		
		return user;
	}
	
}
