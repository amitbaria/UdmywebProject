package udmy.com.test.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Customer implements InitializingBean,DisposableBean{
	
	
	// Life cycle of Bean
	
	// 1. Bean object Instantiated
	// 2. Properties method called...
	// 3. After All properties method called...(Initializing Bean....)
	// 4. Customized init Method called
	// 5.  Destroy method called   --     (DisposableBean....bean)
	
	

	private Integer customerid;
	private String firstName;
	private String lastName;
	private String phno;
	private String email;
	
	
	
	
	
public	Customer()
	{
	System.out.println("Customer Cunstructor called, Object Initialized....");
		
		
	}

public  void customized()
{
     System.out.println("Customized method Initialized........");	
}
	
	
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
		System.out.println("Name setter method -->"+this.customerid);
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		System.out.println("Name setter method -->"+firstName);
		
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		System.out.println("Name setter method "+lastName);
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
		System.out.println("Name setter method --> "+phno);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		System.out.println("Name setter method -->  "+email);
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Logic for Bean is Destroyed.... For Customer Class");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(" Call After all properties set of Customer Class");
		
	}
	public void destroyed()
	{
		System.out.println("Destroyed logic implemented here....");
		
	}
	

}
