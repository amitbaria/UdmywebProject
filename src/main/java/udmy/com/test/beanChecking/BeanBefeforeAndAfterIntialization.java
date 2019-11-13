package udmy.com.test.beanChecking;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import udmy.com.test.model.Customer;
import udmy.com.test.serviceImp.CustomerServiceImp;

public class BeanBefeforeAndAfterIntialization implements BeanPostProcessor{

	
	@Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        // TODO Auto-generated method stub
        if(bean instanceof Customer) {
//          System.out.println("Tr "+(((Triangle) bean).getName().toString()));
            System.out.println("I am after intialisation");
        }
        
        if(bean instanceof CustomerServiceImp)
        {
        	System.out.println( " I am instance of CustomerServiceImp in postProcessAfterInitialization");
        }
        
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        // TODO Auto-generated method stub
        if(bean instanceof Customer) {
            System.out.println("Customer Instance "+(((Customer) bean).getFirstName().toString()));
        }
        
        if(bean instanceof CustomerServiceImp)
        {
        	System.out.println( " I am instance of CustomerServiceImp in postProcessBeforeInitialization");
        }
        
        return bean;
    }

	
}
