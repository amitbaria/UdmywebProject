package udmy.com.test.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import udmy.com.test.UserDaoRepository.LoanAccountsDao;
import udmy.com.test.model.LoanAccounts;
import udmy.com.test.model.User;
import udmy.com.test.service.LoanAccountsService;

public class LaonAccountsServiceImp  implements LoanAccountsService{
	
	
	@Autowired
    private LoanAccountsDao loanAccountDao;

	@Override
	public List<User> getAllLoanDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Integer loadDetails(LoanAccounts loan) {
		return loanAccountDao.addLoanInformation(loan);
		
	}

}
