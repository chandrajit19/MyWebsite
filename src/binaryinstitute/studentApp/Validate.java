package binaryinstitute.studentApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate {
    static Connection con = null;
    static PreparedStatement pstmt = null;

    static boolean checkUser(String username, String pwd) {
        boolean st = false;
        con = StudentDao.getConnection();
        try {
            pstmt = con.prepareStatement("SELECT * FROM binarydb.student WHERE username=? AND password=?");
            pstmt.setString(1, username);
            pstmt.setString(2, pwd);
            ResultSet rs = pstmt.executeQuery();
            st = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return st;
    }
}
