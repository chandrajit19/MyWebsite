package binaryinstitute.studentApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<body style='background-image: url(\"E:\\\\Image/back16.jpg\"); background-size: cover; '>");
        out.println("<a href='signup.html'>Add New Student</a>");
        out.println("<h1>Binary Institute Students List</h1>");
        List<Student> list = StudentDao.getAllStudent();
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Name</th><th>UserName</th><th>Email</th><th>Gender</th><th>City</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
        for (Student s : list) {
            out.print("<tr><td>" + s.getName() + "</td><td>" + s.getUsername() + "</td><td>" + s.getEmail()
                    + "</td><td>" + s.getGender() + "</td><td>" + s.getCity() + "</td><td>" + s.getCountry()
                    + "</td><td><a href='EditServlet?username=" + s.getUsername() + "'>edit</a></td><td><a href='DeleteServlet?username="
                    + s.getUsername() + "'>delete</a></td></tr>");
        }
        out.print("</table>");
        out.println("</body>");
        out.close();
    }
}
