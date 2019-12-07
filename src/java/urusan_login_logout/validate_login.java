/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urusan_login_logout;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kelasJava.koneksi_db;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "validate_login", urlPatterns = {"/validate_login"})
public class validate_login extends HttpServlet {

    static String sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA256");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email4login="";
        String pass4login="";

        String email_ = request.getParameter("email_");
        String password_ = request.getParameter("password_");

        try {

            String encrypted_str_pswd = sha256(password_);

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = koneksi_db.initializeDatabase();

            PreparedStatement prepStmt_auth = conn.prepareStatement("SELECT * FROM tabel_akun WHERE email_akun=? AND pass_akun=?");
            prepStmt_auth.setString(1, email_);
            prepStmt_auth.setString(2, encrypted_str_pswd);
            ResultSet rs = prepStmt_auth.executeQuery();

            while (rs.next()) {
                email4login = rs.getString("email_akun");
                pass4login = rs.getString("pass_akun");
            }
            rs.close();
            
            if(email4login.equals(email_)){
                System.out.println("login berhasil");
            }

        } catch (Exception ex) {

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
