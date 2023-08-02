package binaryinstitute.studentApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Update Employee</title>");
        // Link to your CSS file for styling
        out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
        out.println("</head>");
       out.println("<body>");
        out.println("<header>");
        out.println("<h1>Update Employee</h1>");
        out.println("</header>");
        out.println("<main>");
        String username = request.getParameter("username");
        Student s = StudentDao.getStudentByUsername(username);

        out.println("<form action='EditServlet2' method='post'>");
        out.println("<input type='hidden' name='uname' value='" + s.getUsername() + "'>");

        out.println("<div class='form-group'>");
        out.println("<label for='name'>Name:</label>");
        out.println("<input type='text' id='name' name='name' value='" + s.getName() + "' required>");
        out.println("</div>");

        out.println("<div class='form-group'>");
        out.println("<label for='email'>Email:</label>");
        out.println("<input type='email' id='email' name='email' value='" + s.getEmail() + "' required>");
        out.println("</div>");

        out.println("<div class='form-group'>");
        out.println("<label for='gender'>Gender:</label>");
        out.println("<select id='gender' name='gender' required>");
        out.println("<option value='Male'" + (s.getGender().equals("Male") ? " selected" : "") + ">Male</option>");
        out.println("<option value='Female'" + (s.getGender().equals("Female") ? " selected" : "") + ">Female</option>");
        out.println("<option value='Other'" + (s.getGender().equals("Other") ? " selected" : "") + ">Other</option>");
        out.println("</select>");
        out.println("</div>");

        out.println("<div class='form-group'>");
        out.println("<label for='city'>City:</label>");
        out.println("<input type='text' id='city' name='city' value='" + s.getCity() + "' required>");
        out.println("</div>");

        out.println("<div class='form-group'>");
        out.println("<label for='country'>Country:</label>");
        out.println("<select id='country' name='country' required>");
        out.println("<option value='India'" + (s.getCountry().equals("India") ? " selected" : "") + ">India</option>");
        out.println("<option value='USA'" + (s.getCountry().equals("USA") ? " selected" : "") + ">USA</option>");
        out.println("<option value='UK'" + (s.getCountry().equals("UK") ? " selected" : "") + ">UK</option>");
        out.println("<option value='Other'" + (s.getCountry().equals("Other") ? " selected" : "") + ">Other</option>");
        out.println("</select>");
        out.println("</div>");

        out.println("<button type='submit'>Update</button>");
        out.println("</form>");
        out.println("</main>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
