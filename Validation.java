import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/Validation"})
public class Validation extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
     
        String uname=request.getParameter("uname");
        String pass=request.getParameter("pas");
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        
        request.getRequestDispatcher("index.html").include(request, response);
        
        String compare="";
          if(LoginValidation.checkUser(uname,pass) && !(uname.equals(compare) || pass.equals(compare)))
          {
              out.print("</br></br>Welcome "+uname+"</br>");
              
              //creating session by HttpSession
              
              HttpSession session=request.getSession();
              session.setAttribute("Username",uname);
              session.setAttribute("Password",pass);
              
          }
          else
          {
             out.println("</br>Incorrect credentials</br> Try again..</br>");
             RequestDispatcher rd=request.getRequestDispatcher("Login.html");
             rd.include(request, response);
            // out.println("\nIncorrect credentials.\n");
          }
         
    }


}
