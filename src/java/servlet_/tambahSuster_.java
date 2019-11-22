/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import kelasJava.biodata_suster;
import kelasJava.koneksi_db;

/**
 *
 * @author ASUS
 */
@MultipartConfig(location = "/.", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "tambahSuster_", urlPatterns = {"/tambahSuster_"})
public class tambahSuster_ extends HttpServlet {

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
        InputStream inputStream;
        Part filePart;
        biodata_suster suster = new biodata_suster();
        filePart = request.getPart("fotoSuster");
        inputStream = filePart.getInputStream();

        String idSust = request.getParameter("idSuster");
        suster.setId_Suster(idSust);
        suster.setNama_suster(request.getParameter("namaSuster"));
        suster.setNama_asal_suster(request.getParameter("namaAsal"));
        suster.setNama_ayah_suster(request.getParameter("namaAyah"));
        suster.setNama_ibu_suster(request.getParameter("namaIbu"));
        suster.setTempat_lahir_suster(request.getParameter("tempat_lahir_suster"));
        suster.setTanggal_lahir_suster(request.getParameter("tanggal_lahir_suster"));
        String anakKe_ = request.getParameter("anak_ke");
        int anakKee = Integer.parseInt(anakKe_);
        suster.setAnak_ke(anakKee);

        String jmlSaudara = request.getParameter("jmlh_saudara");
        int jml_saudara = Integer.parseInt(jmlSaudara);
        suster.setJmlh_saudara(jml_saudara);

        try {
            Connection con = koneksi_db.initializeDatabase();
            PreparedStatement prpStmt = con.prepareStatement("INSERT INTO biodata_suster values(?,?,?,?,?,?,?,?,?,?)");
            
            prpStmt.setString(1, suster.getId_Suster());
            prpStmt.setString(2, suster.getNama_suster());
            prpStmt.setString(3, suster.getNama_asal_suster());
            prpStmt.setString(4, suster.getTempat_lahir_suster());
            prpStmt.setString(5, suster.getTanggal_lahir_suster());
            prpStmt.setString(6, suster.getNama_ayah_suster());
            prpStmt.setString(7, suster.getNama_ibu_suster());
            prpStmt.setInt(8, suster.getAnak_ke());
            prpStmt.setInt(9, suster.getJmlh_saudara());
            prpStmt.setBlob(10, inputStream);
            
            PreparedStatement prpStmt2=con.prepareStatement("INSERT INTO minatbakat_suster values(?,?)");
            prpStmt2.setString(1, suster.getId_Suster());
            prpStmt2.setString(2, null);

            prpStmt.executeUpdate();
            prpStmt.close();
            con.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("./db_suster/formAdd_suster.html");

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
