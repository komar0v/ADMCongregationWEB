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
@WebServlet(name = "tambahRiwayatPendidikan_suster", urlPatterns = {"/tambahRiwayatPendidikan_suster"})
public class tambahRiwayatPendidikan_suster extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idSuster = request.getParameter("idSuster");
        String[] jenjang = request.getParameterValues("riwayatPendidikan1[]");
        String[] instansi = request.getParameterValues("riwayatPendidikan2[]");
        String[] tahun = request.getParameterValues("riwayatPendidikan3[]");
        
        String pendidikannya_suster="";

        for (int i = 0; i < jenjang.length; i++) {
            pendidikannya_suster = pendidikannya_suster + jenjang[i] + " " + instansi[i] + " " + tahun[i]+ " , ";
        }
        
        try {
            Connection con = koneksi_db.initializeDatabase();

            PreparedStatement prpStmt = con.prepareStatement("SELECT * FROM pendidikan_suster WHERE id_suster=?");
            prpStmt.setString(1, idSuster);

            ResultSet rs = prpStmt.executeQuery();
            String pendidikan = "";
            if (rs.next()) {
                pendidikan = rs.getString("pendidikan");
            }
            String pendidikan_updt = pendidikannya_suster + pendidikan;
            con.close();
            koneksi_db.updateRiwayatPendidikan(pendidikan_updt, idSuster);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("./editSusterView_?id_suster=" + idSuster);
    }

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
