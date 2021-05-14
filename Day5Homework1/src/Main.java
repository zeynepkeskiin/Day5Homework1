import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.AmazonMailManagerAdapter;
import core.GoogleMailManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
			User eylul =new User(4, "Eylül","Yýlmaz","eylülylmz@hotmail.com", "2468101",true);
			User demir =new User(2, "Demir","Özhan","demiriniz@hotmail.com", "135791",false);

			
			
			HibernateUserDao hiberateUserDao= new HibernateUserDao();
			GoogleMailManagerAdapter googleMailManagerAdapter =new GoogleMailManagerAdapter();
			AmazonMailManagerAdapter amazonMailManagerAdapter = new AmazonMailManagerAdapter();
			
			
			
			AuthManager authManager = new AuthManager(new UserManager(hiberateUserDao,googleMailManagerAdapter));
			authManager.register(eylul);
			UserManager userManager = new UserManager(hiberateUserDao, amazonMailManagerAdapter);
			
			userManager.getAll();
	}

}
