package udmy.com.test.UserDaoRepository;

import java.util.List;

import udmy.com.test.model.User;

public interface UserDao {
	
	public Integer  addUserInformation(User u);
	public User  getUserInformationById(int id);
	public List<User>  getAllUserInformatation();
}
