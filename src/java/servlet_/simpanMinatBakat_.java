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
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kelasJava.koneksi_db;
import kelasJava.minatBakat_suster;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "simpanMinatBakat_", urlPatterns = {"/simpanMinatBakat_"})
public class simpanMinatBakat_ extends HttpServlet {


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
        String[] minatBakat = request.getParameterValues("minatbakat[]");
        String list_minatBakat = "";
        
        for (int i = 0; i < minatBakat.length; i++) {
            list_minatBakat = list_minatBakat+" | "+minatBakat[i];
        }
        minatBakat_suster minat_bakatnyaSuster = new minatBakat_suster();
        minat_bakatnyaSuster.setId_suster(idSuster);
        minat_bakatnyaSuster.setMinatBakat(list_minatBakat);
        
        try {
            Connection con = koneksi_db.initializeDatabase();
            PreparedStatement prpStmt = con.prepareStatement("INSERT INTO minatbakat_suster values(?,?)");
            prpStmt.setString(1, minat_bakatnyaSuster.getId_suster());
            prpStmt.setString(2, minat_bakatnyaSuster.getMinatBakat());

            prpStmt.executeUpdate();
            prpStmt.close();
            con.close();
            

        } catch (Exception e) {
            e.printStackTrace();
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
