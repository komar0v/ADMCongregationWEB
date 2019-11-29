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
import kelasJava.minatBakat_suster;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "tambahMinatBakatSuster", urlPatterns = {"/tambahMinatBakatSuster"})
public class tambahMinatBakatSuster extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idSuster = request.getParameter("idSuster");
        String[] minatBakat = request.getParameterValues("minatbakat[]");
        String list_minatBakat = "";

        for (int i = 0; i < minatBakat.length; i++) {
            list_minatBakat = list_minatBakat + " , " + minatBakat[i];
        }
        minatBakat_suster minatBakatnya = new minatBakat_suster();
        
        minatBakatnya.setId_suster(idSuster);
        minatBakatnya.setMinatBakat(list_minatBakat);
        

        try {
            Connection con = koneksi_db.initializeDatabase();

            PreparedStatement prpStmt = con.prepareStatement("SELECT * FROM minatbakat_suster WHERE id_suster=?");
            prpStmt.setString(1, minatBakatnya.getId_suster());

            ResultSet rs = prpStmt.executeQuery();
            String minat_bakat = "";
            if (rs.next()) {
                minat_bakat = rs.getString("minatbakat");
            }
            String minatBakat_updt = list_minatBakat + minat_bakat;
            con.close();
            koneksi_db.updateMinatbakat(minatBakat_updt, idSuster);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("./minatBakat_suster?id_suster=" + minatBakatnya.getId_suster());

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
