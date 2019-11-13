package udmy.com.test.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import udmy.com.test.model.Customer;
import udmy.com.test.service.CustomerService;


@Service
public class CustomerServiceImp  implements CustomerService,InitializingBean,DisposableBean {

	
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerServiceImp()
	{
		System.out.println("CustomerServiceImp Object is created.......");
		
	}
	
	public  void customized()
	{
	     System.out.println(" CustomerServiceImp Customized method Initialized........");	
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Object CustomerServiceImp Bean is Destroyed.... For Customer Class");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("CustomerServiceImp Call After all properties set of Customer Class");
		
	}
	
	
	@Override
	public Customer findCustomerNameById(String customerid) {
		
		
		 
		
		
	    //  List<Customer>  cust=null;
	     
	     boolean flag=false;
		 if(Integer.parseInt(customerid)==0)
		 {
			   flag=false;
			  
		 }
		
			 if(Integer.parseInt(customerid)==customer.getCustomerid())
			 {
				flag=true;
			 }
			 
			  if(flag==true)
			  {
				  
				  
				 
				  return customer;
				  
			  }
			  else
			  {
				  return null;
			  }
			 
			
			 
	}

	
	
	// init method
    // call properties method 
	
}
