/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv_berita;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kelasJava.koneksi_db;
import urusan_login_logout.validate_login;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "login_ke_panel_berita", urlPatterns = {"/login_ke_panel_berita"})
public class login_ke_panel_berita extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String uname = "";
        String pswd = "";
        String id_user = "";
        String nama_user = "";

        try {

            String usrName = request.getParameter("email_");
            String passWd = request.getParameter("password_");

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = passWd;

            md.update(text.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();

            String output_thesha256 = String.format("%064x", new BigInteger(1, digest));

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = koneksi_db.initializeDatabase();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tabel_akun WHERE email_akun=? AND pass_akun=?");

            ps.setString(1, usrName);
            ps.setString(2, output_thesha256);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                uname = rs.getString("email_akun");
                pswd = rs.getString("pass_akun");
                nama_user = rs.getString("nama_akun");
                id_user = rs.getString("id_akun");
            }
            rs.close();

            if (uname.equals(usrName) && pswd.equalsIgnoreCase(output_thesha256)) {
                try {
                    Connection con_uptd = koneksi_db.initializeDatabase();
                    PreparedStatement ps2uptd = con_uptd.prepareStatement("UPDATE tabel_akun SET status_akun=? WHERE id_akun=?");
                    ps2uptd.setString(1, "used");
                    ps2uptd.setString(2, id_user);

                    ps2uptd.executeUpdate();
                    ps2uptd.close();
                    con_uptd.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                //generate a new session
                HttpSession newSession = request.getSession(true);

                //setting session to expiry in 5 mins
                newSession.setMaxInactiveInterval(5 * 60);

                Cookie namaUser = new Cookie("namaUser", nama_user);
                Cookie idUser = new Cookie("idUser", id_user);
                response.addCookie(namaUser);
                response.addCookie(idUser);
                response.sendRedirect("./panel_berita");
                
            }
            else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('PASSWORD/USERNAME SALAH');");
                out.println("location='./login_panel_berita';");
                out.println("</script>");
            }

        } catch (Exception ex) {
            Logger.getLogger(validate_login.class.getName()).log(Level.SEVERE, null, ex);
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
