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
@WebServlet(name = "editSeminar_susterLakukanPerubahan", urlPatterns = {"/editSeminar_susterLakukanPerubahan"})
public class editSeminar_susterLakukanPerubahan extends HttpServlet {


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
        String idSuster = request.getParameter("idSuster");
        String[] nama_seminar = request.getParameterValues("namaSeminar");
        String[] nama_sertif_seminar = request.getParameterValues("namaSertif");

        String namaseminarYgPernahikut_suster = "";
        String namasertifnya = "";
        
        for (int i = 0; i < nama_seminar.length; i++) {
            namaseminarYgPernahikut_suster = namaseminarYgPernahikut_suster + nama_seminar[i] + " , ";
            namasertifnya = namasertifnya + nama_sertif_seminar[i] + " , ";
            
        }
        
        try{
            Connection con3 = koneksi_db.initializeDatabase();
            PreparedStatement prpStmt3 = con3.prepareStatement("UPDATE seminar_suster SET seminar=?, sertifikat=? WHERE id_suster=?");
            prpStmt3.setString(1, namaseminarYgPernahikut_suster);
            prpStmt3.setString(2, namasertifnya);
            prpStmt3.setString(3, idSuster);

            prpStmt3.executeUpdate();
            con3.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("./seminarYgPernahIkut_suster?id_suster="+idSuster);
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
