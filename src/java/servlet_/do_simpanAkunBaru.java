/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kelasJava.akun_;
import kelasJava.koneksi_db;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "do_simpanAkunBaru", urlPatterns = {"/do_simpanAkunBaru"})
public class do_simpanAkunBaru extends HttpServlet {

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
        try {
            String passWd = request.getParameter("password_");
            int idAkun = Integer.parseInt(request.getParameter("id_akun"));
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = passWd;

            md.update(text.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();

            String output_thesha256 = String.format("%064x", new BigInteger(1, digest));
            String namaAkun = request.getParameter("nama_");
            String emailAkun = request.getParameter("email_");
            
            akun_ account_ = new akun_();
            account_.setId_akun(idAkun);
            account_.setNama_akun(namaAkun);
            account_.setPassword_akun(output_thesha256);
            account_.setEmail_akun(emailAkun);
            

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = koneksi_db.initializeDatabase();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO tabel_akun VALUES (?,?,?,?,?)");
            
            ps.setInt(1, account_.getId_akun());
            ps.setString(2, namaAkun);
            ps.setString(3, account_.getEmail_akun());
            ps.setString(4, account_.getPassword_akun());
            ps.setString(5, "idle");
            ps.executeUpdate();
            ps.close();
            conn.close();
            PrintWriter out = response.getWriter();
            try {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Berhasil menambahkan akun "+namaAkun+".');");
                out.println("location='./home_';");
                out.println("</script>");
            } finally {
                out.close();
            }

        } catch (Exception ex) {
            Logger.getLogger(do_simpanAkunBaru.class.getName()).log(Level.SEVERE, null, ex);
            String pesan_error = ex.getMessage();
            System.out.println("ERR  "+pesan_error);
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
