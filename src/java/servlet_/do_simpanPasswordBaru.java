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
import java.sql.ResultSet;
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
@WebServlet(name = "do_simpanPasswordBaru", urlPatterns = {"/do_simpanPasswordBaru"})
public class do_simpanPasswordBaru extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = koneksi_db.initializeDatabase();

            PreparedStatement ps = conn.prepareStatement("UPDATE tabel_akun SET pass_akun=? WHERE id_akun=?");

            ps.setString(1, output_thesha256);
            ps.setInt(2, idAkun);
            ps.executeUpdate();
            ps.close();
            conn.close();
            PrintWriter out = response.getWriter();
            try {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Berhasil mengganti password. Silahkan login kembali.');");
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
