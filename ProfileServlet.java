/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet
{

   
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("index.html").include(request, response);
        
        HttpSession session=request.getSession();
        String uname=(String)session.getAttribute("Username");
        String pass=(String)session.getAttribute("Password");
        
          if((session.getLastAccessedTime()-session.getCreationTime())/1000 < 30)   //to give the session 30 sec validity
          {
        
                if(uname!=null && pass!=null && uname!="" && pass!="")
                {
                 //out.println((session.getLastAccessedTime()-session.getCreationTime())/1000);
                 out.println("</br>Welcome to profile...</br>Username: "+uname+"</br>Password:"+pass);
                }
                else
                {
                 out.println("Please login first.</br>");
                }
          }
          else
           {
             out.println("</br>Session expired.</br>Login again");
             session.invalidate();
           }
    }

   

}
