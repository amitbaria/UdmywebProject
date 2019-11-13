package udmy.com.test.serviceImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udmy.com.test.UserDaoImpRepository.UserDaoImp;
import udmy.com.test.UserDaoRepository.UserDao;
import udmy.com.test.model.User;
import udmy.com.test.service.UserService;


@Service
public class UserServiceImp implements UserService {

	   @Autowired
	   private UserDao userDao;
	
	/*@Override
	public List<User> getAllUserDetails() {
		
		
		Query cri= sessionFactory.getCurrentSession().createQuery("from User");  
		
		List<User> user =cri.getResultList();
		    return user;
	}
	*/
	@Override
	@Transactional
	public Integer loadDetails(User user) {
		
		
	    Integer userid	= userDao.addUserInformation(user);
		return userid;
		  
	}
	@Transactional
	@Override
	public List<User> getAllUserDetails() {
		
		return	userDao.getAllUserInformatation();
		
		
	}

	@Transactional
	@Override
	public User getUserById(int id) {
		
		
		return userDao.getUserInformationById(id);
	}
	
	
	

}
