package udmy.com.test.service;

import java.util.List;

import udmy.com.test.model.LoanAccounts;
import udmy.com.test.model.User;

public interface LoanAccountsService {
	public  List<User> getAllLoanDetails();
	public Integer loadDetails(LoanAccounts loan);
}
