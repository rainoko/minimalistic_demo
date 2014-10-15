package ee.dummy

import javax.naming.InitialContext
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

// Extend HttpServlet class
public class Servlet extends HttpServlet {

  private String message

  public void init() throws ServletException
  {
    message = "Hello World"
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
          throws ServletException, IOException
  {
    InitialContext ic = new InitialContext();
    String mySpecialValue = (String)ic.lookup("java:comp/env/testname");

    response.setContentType "text/html"
    PrintWriter out = response.getWriter()
    out.println("<h1>" + message + "</h1>" + mySpecialValue)
  }

  public void destroy()
  {
    // do nothing.
  }
}