package udmy.com.test.service;

import java.util.List;

import udmy.com.test.model.User;

public interface UserService {
	
	public  List<User> getAllUserDetails();
	public Integer loadDetails(User user);
	public User getUserById(int id);
	
	

}
