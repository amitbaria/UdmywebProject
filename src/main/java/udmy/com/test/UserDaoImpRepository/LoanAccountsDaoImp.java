package udmy.com.test.UserDaoImpRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import udmy.com.test.UserDaoRepository.LoanAccountsDao;
import udmy.com.test.model.LoanAccounts;

public class LoanAccountsDaoImp implements LoanAccountsDao {

	
	@Autowired
	private SessionFactory accountSessionFactory;
	
	

	@Override
	public Integer addLoanInformation(LoanAccounts loan) {
		Session session	=accountSessionFactory.getCurrentSession();
        return 		(Integer)session.save(loan); 
		
	}

}
