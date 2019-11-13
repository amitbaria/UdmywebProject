package MVCControllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.is;


import org.springframework.web.context.WebApplicationContext;

import udmy.com.test.UserDaoImpRepository.UserDaoImp;
import udmy.com.test.UserDaoRepository.UserDao;
import udmy.com.test.model.User;
import udmy.com.test.service.UserService;
import udmy.com.test.serviceImp.UserServiceImp;

import static org.hamcrest.Matchers.*;


// step 1
@RunWith(SpringJUnit4ClassRunner.class)

//@ContextConfiguration(classes={})

// step 2
            
@ContextConfiguration({"classpath:userdispatcher-servlet-user.xml","classpath:applicationContext.xml"})

// step 3    it enables the components of the web applications.....
@WebAppConfiguration 
public class UserControllerMVCTest {
	
	@Autowired
	private WebApplicationContext context;
	
	
	private MockMvc  mockMvc;
	
	 //  for Service Class  methods 
	@Mock
	private UserServiceImp UserServiceImpoService;
	
	
//	@InjectMocks
//	private UserDao UserDaoService;
	
	
	@Before
	public void setup()
	{
		
		    //  For Controller 
		    DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.context);
	        this.mockMvc = builder.build();
	        
	        //  for Service Class  methods 
	        MockitoAnnotations.initMocks(this);	
		
	}
	
	@Test

	public  void URITest()throws Exception	
	{
		String expected="user Testing URL";
		//String acutal=mockMvc.perform(MockMvcRequestBuilders.get("/user/test/")).andReturn().getResponse().getContentAsString();
				                                                      

		 
		//Step 1.
		//  Directly call the Controller.....
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/test");
        
        // Get Status of 200
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        
        String actualData = this.mockMvc.perform(builder)
                    .andExpect(ok)
                    .andReturn().getResponse().getContentAsString();
        
        
      System.out.println( "Result is :"+ actualData);
        
        
       assertEquals(expected, actualData);
        
        
       //Check the View Name in module of Controller....  
      // ResultMatcher viewMatcher = MockMvcResultMatchers.view().name("PatchMapping-view");
	}
	
	
	
	      @Test
	     
	      public void  getCustomerURI()throws Exception
	      {
	    	  MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/customerinfo/1");
		        
		        // Get Status of 200
		                 ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		      
		                 System.out.println("Order 2........................");
		        
		                 ResultActions actualData = this.mockMvc.perform(builder)
	                    .andExpect(ok)  
	                    .andExpect(MockMvcResultMatchers.model().attribute("Data", hasProperty("customerid",is(new Integer(1)))))
	                    .andExpect(MockMvcResultMatchers.model().attribute("Data", hasProperty("firstName",is("Karan"))))		                                 
                        .andExpect(MockMvcResultMatchers.model().attribute("Data", hasProperty("lastName",is("Kumar"))))	
                        .andExpect(MockMvcResultMatchers.model().attribute("Data", hasProperty("phno",is("9047556566"))))	 
	                    .andExpect(MockMvcResultMatchers.model().attribute("Data", hasProperty("email",is("baria@yahoo.com"))))
		                .andExpect(MockMvcResultMatchers.view().name("userhome"))
		                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/userviews/userhome.jsp"));
	      }
	      
	      
	    @Test
	  
	  	public void      getUserByIdTest()throws Exception
	  	{
	  		
	  		        User u=new User();
	  		      u.setUserid(1);
	  		      u.setUserName("Rajan111111");
	  		      u.setUserEmail("baria..amit");
	  		      
	  		 
	  		
	  		//User  user=UserDaoService.getUserInformationById(1);
	  		
	  		//when(UserServiceImpoService.getUserById(33333)).thenReturn(u);
	  		
	  		
//  		User user1	=UserServiceImpoService.getUserById(6);
//  		
//  		System.out.println("Name is ............................................"+user1.getUserName());
//  		
////	  	    assertEquals(u.getUserid(),user1.getUserid());
////	  	    assertEquals(u.getUserName(),user1.getUserName());
//	  	    
//	  	    
//	  	     MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/userinfo/5222");
//	        
//	        // Get Status of 200
//	        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
//	       // ResultMatcher viewMatcher = MockMvcResultMatchers.view().name("userhome");
//	  	    
//	        ResultActions actualData = this.mockMvc.perform(builder)
//                    .andExpect(ok);
//                    //.andExpect(MockMvcResultMatchers.view().name("userhome"));
//	      //  verify(UserServiceImpoService,times(1)).getUserById(1);
//	        verifyNoMoreInteractions(UserServiceImpoService);
	  	}

		
	      
	    @Test
		public void      getAllUsersTest()throws Exception
	  	 {
	    	
	    	
	    	
	    	
	  	 }
	 
	    

		
	
}
