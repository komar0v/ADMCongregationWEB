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
@WebServlet(name = "editRiwayatPendidikan_susterLakukanPerubahan", urlPatterns = {"/editRiwayatPendidikan_susterLakukanPerubahan"})
public class editRiwayatPendidikan_susterLakukanPerubahan extends HttpServlet {

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
        String[] pendidikan_ = request.getParameterValues("pendidikan_");

        String data_pendidikan = "";
        
        for (int i = 0; i < pendidikan_.length; i++) {
            data_pendidikan = data_pendidikan + pendidikan_[i] + " , ";
            
        }
        try{
            Connection con_ = koneksi_db.initializeDatabase();
            PreparedStatement prpStmt_ = con_.prepareStatement("UPDATE pendidikan_suster SET pendidikan=? WHERE id_suster=?");
            prpStmt_.setString(1, data_pendidikan);
            prpStmt_.setString(2, idSuster);
            prpStmt_.executeUpdate();
            con_.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("./riwayatPendidikan_suster?id_suster="+idSuster);
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
