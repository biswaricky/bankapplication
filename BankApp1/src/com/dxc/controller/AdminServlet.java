package com.dxc.controller;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.pojos.User;
import com.dxc.service.AdminServiceImpl;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet 
{ 
	String Message="";
	String errorMessage="";
	AdminServiceImpl service=new AdminServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		String action="";
		String message = "";
		String temp = request.getParameter("btn");

		if (temp != null)
			action = request.getParameter("btn");
		
		HttpSession session=request.getSession();
		
		if(action.equals("login")) {
		String adminId=request.getParameter("admin");
				          String adminPwd=request.getParameter("pass");
				         // System.out.println(adminPwd);
				          boolean res=service.loginCheck(adminId,adminPwd);
				          if(res==true)
				          {
				        	  response.sendRedirect("adminmenu.jsp");
				          }
				          else
			                  {
				                Message="invalid login";
				                 session.setAttribute("Message", Message);
				                   response.sendRedirect("view.jsp");
			                  }
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {	
    	   String action="";
    	   String temp=request.getParameter("adminbtn");
    	   HttpSession session=request.getSession();
    	   if(temp!=null)
    		   action=temp;
    	   if(action.equals("add_customer"))
    	   {
    		   int accno=Integer.parseInt(request.getParameter("accno")) ;
    		   String name=request.getParameter("name");
    		   double balance=Double.parseDouble(request.getParameter("balance"));
    		   int password=Integer.parseInt(request.getParameter("password"));
    		   User u1=new User(accno,name,balance,password);
    		   service.addCust(accno, name, balance,password);
    		   Message="Customer added successfully!!";
    		   session.setAttribute("Message", Message);
    		   response.sendRedirect("view.jsp");
    		   
    	   }
    	   else if(action.equals("show_customer"))
    	   {
    		   int accno=Integer.parseInt(request.getParameter("accno"));
    		//   session.setAttribute("accno", accno);
    		   boolean searchStatus=service.searchUser(accno);
    		   User u1=new User();
    		   if(searchStatus==true)
    		   {
    			   List<User> list = service.showCustomer(accno);
    			   session.setAttribute("list", list);
    			   response.sendRedirect("ShowUser.jsp");
    		   }
    		   else
    		   {
    			   Message="User not found";
        		   session.setAttribute("Message", Message);
        		   response.sendRedirect("view.jsp");

    		   }
    		   
    	   }
    	   
    	   else if(action.equals("update_customer"))
    	   {
    		  // System.out.println("servlet - update user");
    		   int accno=Integer.parseInt(request.getParameter("accno"));
    		   String name=request.getParameter("name");
    		   User u1=new User();
    		   u1.setAccno(accno);
    		   u1.setName(name);
    		   
    		   service.updateUser(u1);
    		   Message="User Updated!!";
    		   session.setAttribute("Message", Message);
    		   response.sendRedirect("view.jsp");
    		   
    		   
    	   }
    	   else if(action.equals("get_cust_bal"))
    	   {
    		   int accno=Integer.parseInt(request.getParameter("accno"));
    		   User u1=new User();
    		   u1.setAccno(accno);
    	
    		   double bal=service.getCustBalance(u1);
    		   Message="avail balance is-"+bal;
    		   u1.setBalance(bal);
    		   //System.out.println(u1.getBalance());
    		   session.setAttribute("Message", Message);
    		   response.sendRedirect("view.jsp");
    	  }
    		  
    	   else if(action.equals("remove_customer"))
    	   {
    		   int accno=Integer.parseInt(request.getParameter("accno"));
    		   boolean removeStatus=service.removeUser(accno);
    		   if(removeStatus==true)
    		   {
    			   Message="user removed";
    		   }
    		   else
    		   {
    			   Message="user not found";
    		   }
    		   session.setAttribute("Message", Message);
    		   response.sendRedirect("view.jsp");
    	   }
    	   else
    	   {
            List<User> list=service.getAllUser();
   			session.setAttribute("list", list);
   			response.sendRedirect("ShowAllCustomers.jsp");
   			
    	   }
    }
	}

	
	


