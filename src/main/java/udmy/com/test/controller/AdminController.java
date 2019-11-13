package udmy.com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class AdminController {
	
	 @ResponseBody
     @RequestMapping(value="/")
	public  String   getHomeResponse()
    {
    
      return "welcome";
    }
	
	 
	    
	    // URL............................
	    
	    @RequestMapping(value="/admininfo")
		// Parameters in query String is not required..........
	    public  String   user(@RequestParam(value="adminid") String adminid   ,ModelMap map)// It is an implementation of LinkedHasMap Interface
	   
	    //2. Parameters in query String is  required..........
	     //  http://localhost:8080/UdmywebProject/user?userid=1 or 2
	    // public  String   user(@RequestParam(value="userid") String userid   ,ModelMap map)
	    
	       //3. Default value of  parameters in query String is 1
	       //  http://localhost:8080/UdmywebProject/user?userid=1
	      // public  String   user(@RequestParam(value="userid" defaultValue="1") String userid   ,ModelMap map)
	    
	    {
	    	
	    	System.out.println("Yes here.........................."+adminid);
	    	
	        String user=null;
	        if(adminid!=null)
	        {
	    	if(adminid.equals("1"))
	    		 user="admin"; 
	    	else if(adminid.equals("2"))
	    		  user="user";
	    	else
	    		user="Annonymous";
	        }
	        else
	        	user="Annonymous";
	        
	    	   map.addAttribute("Data",user);
	    	   return "adminhome";
	    	  
	   
	    	 //	  we can also use ModelAndView to return view name and Model Object in Single Value
	    	 //return new ModelAndView("welcome","message",map);
		}
	    
	    
	    
	        
	    
	    
	

}
