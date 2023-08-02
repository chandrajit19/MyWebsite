package binaryinstitute.studentApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/binarydb", "root", "tiger");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Student s) {
        int status = 0;
        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO binarydb.student(name, username, email, gender, city, country, password) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getUsername());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getGender());
            ps.setString(5, s.getCity());
            ps.setString(6, s.getCountry());
            ps.setString(7, s.getPassword());
            status = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int delete(String username) {
        int status = 0;
        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM binarydb.student WHERE username=?");
            ps.setString(1, username);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Student getStudentByUsername(String username) {
        Student s = new Student();
        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM binarydb.student WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setName(rs.getString(1));
                s.setUsername(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setGender(rs.getString(4));
                s.setCity(rs.getString(5));
                s.setCountry(rs.getString(6));
                s.setPassword(rs.getString(7));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s;
    }

    public static List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM binarydb.student");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setName(rs.getString(1));
                s.setUsername(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setGender(rs.getString(4));
                s.setCity(rs.getString(5));
                s.setCountry(rs.getString(6));
                s.setPassword(rs.getString(7));
                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int update(Student s) {
        int status = 0;
        try {
            Connection con = StudentDao.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE binarydb.student SET name=?, email=?, gender=?, city=?, country=?, password=? WHERE username=?");
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getGender());
            ps.setString(4, s.getCity());
            ps.setString(5, s.getCountry());
            ps.setString(6, s.getPassword());
            ps.setString(7, s.getUsername());
            status = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    // ... (other methods if needed)

}
