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
@WebServlet(name = "editMinatBakat_susterLakukanPerubahan", urlPatterns = {"/editMinatBakat_susterLakukanPerubahan"})
public class editMinatBakat_susterLakukanPerubahan extends HttpServlet {

    
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
        String[] minatBakat_ = request.getParameterValues("minatBakat_");

        String minat_bakat = "";
        
        for (int i = 0; i < minatBakat_.length; i++) {
            minat_bakat = minat_bakat + minatBakat_[i] + " , ";
            
        }
        
        try{
            Connection con3 = koneksi_db.initializeDatabase();
            PreparedStatement prpStmt3 = con3.prepareStatement("UPDATE minatbakat_suster SET minatbakat=?, WHERE id_suster=?");
            prpStmt3.setString(1, minat_bakat);
            prpStmt3.setString(2, idSuster);

            prpStmt3.executeUpdate();
            con3.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("./minatBakat_suster?id_suster="+idSuster);
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
