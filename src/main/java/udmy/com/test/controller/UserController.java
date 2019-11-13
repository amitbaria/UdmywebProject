package udmy.com.test.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import udmy.com.test.model.LoanAccounts;
import udmy.com.test.model.User;
import udmy.com.test.service.LoanAccountsService;
import udmy.com.test.service.UserService;
import udmy.com.test.serviceImp.CustomerServiceImp;




@Controller
public class UserController {
	
	@Autowired
	private CustomerServiceImp customerService;
	
	@Autowired
	private UserService  user;
	
	@Autowired
	private LoanAccountsService  loanAccountService;
	     @RequestMapping(value="/customerinfo/{userid}")
		 // Parameters in query String is not required..........
        //  http://localhost:8080/UdmywebProject/user/1
	    public String   user2(@PathVariable(value="userid") String userid ,ModelMap map)// It is an implementation of LinkedHasMap Interface
	   
	    {
	    	   
		        System.out.println(userid+ "....................................");
	    	    map.addAttribute("Data", customerService.findCustomerNameById(userid));
	    	   return "userhome";
	    	 //	  we can also use ModelAndView to return view name and Model Object in Single Value
	    	 //return new ModelAndView("welcome","message",map);
		}  
	 
	 @RequestMapping(value="/userinfo")
	   // Parameters in query String is not required..........
      //  http://localhost:8080/UdmywebProject/user/1
    public String   user2(@RequestParam(value="userid") Integer userid ,   
    		@RequestParam(value="userName") String userName,
    		@RequestParam(value="userEmail") String userEmail,
    		@RequestParam(value="userAddress") String userAddress,
    		ModelMap map)// It is an implementation of LinkedHasMap Interface
   
          {
      
    	  // map.addAttribute("Data", customerService.findCustomerNameById(userid));
		  System.out.println("....................."+ userid + " " +userName +" "+userEmail+ " "+ userAddress);
		 
		   User u=new User();
		   u.setUserid(12);
		   u.setUserName("Rajan");
		   u.setUserEmail("baria..com");
		   u.setUserAddress("Jammu");
		   u.setIgnoreColumnCreation("Random Data");
		   u.setUserDOB(new Date());
		   u.setModifiedBy(new Date());
		   u.setCeatedBy(new Date());
		   
		  
		  
		     int savedUserid = user.loadDetails(u);
		    
		      map.addAttribute("Data",savedUserid);
		 
    	       return "userhome";
     	 //	  we can also use ModelAndView to return view name and Model Object in Single Value
    	 //return new ModelAndView("welcome","message",map);
	} 
	
	 
	 @RequestMapping(value="/userinfo/{userid}",method = RequestMethod.GET)
	 // Parameters in query String is not required..........
//  http://localhost:8080/UdmywebProject/userinfo/1
    public String   getUserById(@PathVariable(value="userid") Integer userid ,ModelMap map)// It is an implementation of LinkedHasMap Interface
   
    {
		     User u=user.getUserById(userid);
		     if(u!=null)
		      {
    	        map.addAttribute("Data",u.getUserName() );
    	        return "userhome";
		      }
		     else
		     {
		    	 
		    	 map.addAttribute("userErrorMessage","User Not existed...."); 
		    	 return "userError";
		    	 
		     }
    	       
    	  
   
    	 //	  we can also use ModelAndView to return view name and Model Object in Single Value
    	 //return new ModelAndView("welcome","message",map);
	}  
	 
	//  If user is crearted...
	// http://localhost:8080/user/openAccount?userid=1&balance=22334 
	@RequestMapping(value="/openAccount",method=RequestMethod.GET)
	public String openAccount(@RequestParam(value="userid")Integer userid,@RequestParam(value="balance") double balance,ModelMap map)
	{
		// Check the userid is already existed ...?
		
		
          User u=user.getUserById(userid);
           if(u!=null)
		      {//  Load Data in Loan Account....
			
        	   System.out.println("yes here2............"+u);
        	   LoanAccounts loanaccounts =new LoanAccounts();
		  
        	   loanaccounts.setBalance(balance);
        	   
        	     loanaccounts.setUser(u);
        	     u.getLoansAccount().add(loanaccounts);
        	     Integer k	=loanAccountService.loadDetails(loanaccounts);
	     	     map.addAttribute("userName",u.getUserName()); 
	     	     map.addAttribute("loanAccount",k); 
	     	
	            return "loanPage";
		}
		
		else
		{
			 map.addAttribute("userErrorMessage","User Not existed...."); 
	    	 return "userError";
			
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String testingPage()
	{
		
		return "user Testing URL";
	}
	
	
	@RequestMapping(value="/allUsers",method=RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Object> getAllUsers()
	{
		
		 //  model.addAttribute("allUsers",user.getAllUserDetails());
		   
		   return new ResponseEntity(user.getAllUserDetails(),HttpStatus.OK);
	}
	
	
	 
}
