package binaryinstitute.studentApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("uname");
        String password = req.getParameter("pw");

        if (Validate.checkUser(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedIn", true);
            resp.sendRedirect("Firstpage.html"); // Redirect to Firstpage.html after successful login
        } else {
            out.println("User name or password incorrect");
            RequestDispatcher rd = req.getRequestDispatcher("Login.html");
            rd.include(req, resp);
        }
    }
}
