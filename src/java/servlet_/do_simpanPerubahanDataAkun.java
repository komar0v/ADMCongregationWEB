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
import kelasJava.koneksi_db;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "do_simpanPerubahanDataAkun", urlPatterns = {"/do_simpanPerubahanDataAkun"})
public class do_simpanPerubahanDataAkun extends HttpServlet {

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
            String namaAkun = request.getParameter("nama_");
            String emailAkun = request.getParameter("email_");
            int idAkun = Integer.parseInt(request.getParameter("id_akun"));
            

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = koneksi_db.initializeDatabase();

            PreparedStatement ps = conn.prepareStatement("UPDATE tabel_akun SET email_akun=?, nama_akun=? WHERE id_akun=?");

            ps.setString(1, emailAkun);
            ps.setString(2, namaAkun);
            ps.setInt(3, idAkun);
            ps.executeUpdate();
            ps.close();
            conn.close();
            PrintWriter out = response.getWriter();
            try {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Berhasil mengubah data. Silahkan login kembali.');");
                out.println("location='./doLogout';");
                out.println("</script>");
            } finally {
                out.close();
            }

        } catch (Exception ex) {
            Logger.getLogger(do_simpanPasswordBaru.class.getName()).log(Level.SEVERE, null, ex);
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
