/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "tambahSeminarYgPernahIkut_suster", urlPatterns = {"/tambahSeminarYgPernahIkut_suster"})
public class tambahSeminarYgPernahIkut_suster extends HttpServlet {

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

        String idSuster = request.getParameter("idSuster");
        String[] nama_seminar = request.getParameterValues("seminar_suster1[]");
        String[] nama_sertif_seminar = request.getParameterValues("seminar_suster2[]");

        String namaseminarYgPernahikut_suster = "";
        String namasertifnya = "";
        
        for (int i = 0; i < nama_seminar.length; i++) {
            namaseminarYgPernahikut_suster = namaseminarYgPernahikut_suster + namaseminarYgPernahikut_suster + " , ";
            namasertifnya = namasertifnya + nama_sertif_seminar[i] + " , ";
            
        }
        
        try {
            Connection con = koneksi_db.initializeDatabase();

            PreparedStatement prpStmt = con.prepareStatement("SELECT * FROM seminar_suster WHERE id_suster=?");
            prpStmt.setString(1, idSuster);

            ResultSet rs = prpStmt.executeQuery();
            String namaseminar = "";
            String namasertif = "";
            if (rs.next()) {
                namaseminar = rs.getString("seminar");
                namasertif = rs.getString("sertifikat");
            }
            String namaseminar_updt = namaseminarYgPernahikut_suster + namaseminar;
            String sertifseminar_updt = namasertifnya + namasertif;
            con.close();
            koneksi_db.updateSeminarYgPernahIkut(namaseminar_updt, sertifseminar_updt, idSuster);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("./seminarYgPernahIkut_suster?id_suster=" + idSuster);

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
