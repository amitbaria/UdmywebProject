package udmy.com.test.UserDaoImpRepository;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import udmy.com.test.UserDaoRepository.UserDao;
import udmy.com.test.model.User;



@Repository
public class UserDaoImp  implements UserDao {

	@Autowired
	private SessionFactory  sessionFactory;
	
	@Override
	public Integer addUserInformation(User user) {
		 
		  Session currentSession = sessionFactory.getCurrentSession();
		  System.out.println("HashCode......."+ currentSession.hashCode());
		  
		  
		
		  Integer userid=  (Integer) currentSession.save(user);
	
	   
		return userid;
	}

	@Override
	public User getUserInformationById(int id) {
		  Session currentSession = sessionFactory.getCurrentSession();
		  return   currentSession.get(User.class,id);
		
		
		
	}

	@Override
	public List<User> getAllUserInformatation() {
		 Session currentSession = sessionFactory.getCurrentSession();
		 List<User> users= currentSession.createQuery("from User").list();
		 return users;
	}

	
	
	
	
}
