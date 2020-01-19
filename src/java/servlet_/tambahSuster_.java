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

            PreparedStatement prpStmt = con.prepareStatement("INSERT INTO biodata_suster VALUES(?,?,?,?,?,?,?,?,?,?,?)");
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
            prpStmt.setString(11, request.getParameter("motto_suster"));
            prpStmt.executeUpdate();
            prpStmt.close();

            PreparedStatement prpStmt2 = con.prepareStatement("INSERT INTO minatbakat_suster VALUES(?,?)");
            prpStmt2.setString(1, suster.getId_Suster());
            prpStmt2.setString(2, "");
            prpStmt2.executeUpdate();
            prpStmt2.close();

            PreparedStatement prpStmt3 = con.prepareStatement("INSERT INTO pendidikan_suster VALUES(?,?)");
            prpStmt3.setString(1, suster.getId_Suster());
            prpStmt3.setString(2, "");
            prpStmt3.executeUpdate();
            prpStmt3.close();

            PreparedStatement prpStmt4=con.prepareStatement("INSERT INTO databiara_suster VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            prpStmt4.setString(1, suster.getId_Suster());
            prpStmt4.setString(2, "");
            prpStmt4.setString(3, "");
            prpStmt4.setString(4, "");
            prpStmt4.setString(5, "");
            prpStmt4.setString(6, "");
            prpStmt4.setString(7, "");
            prpStmt4.setString(8, "");
            prpStmt4.setString(9, "");
            prpStmt4.setString(10, "");
            prpStmt4.setString(11, "");
            prpStmt4.setString(12, "");
            prpStmt4.setString(13, "");
            prpStmt4.setString(14, "");
            prpStmt4.setString(15, "");
            prpStmt4.setString(16, "");
            prpStmt4.setString(17, "");
            prpStmt4.setString(18, "");
            prpStmt4.setString(19, "");
            prpStmt4.setString(20, "");
            prpStmt4.setString(21, "");
            prpStmt4.setString(22, "");
            prpStmt4.executeUpdate();
            prpStmt4.close();
            
            PreparedStatement prpStmt5 = con.prepareStatement("INSERT INTO seminar_suster VALUES(?,?,?)");
            prpStmt5.setString(1, suster.getId_Suster());
            prpStmt5.setString(2, "");
            prpStmt5.setString(3, "");
            prpStmt5.executeUpdate();
            prpStmt5.close();
            
            PreparedStatement prpStmt6 = con.prepareStatement("INSERT INTO catatanpribadi_novis_satu_notes VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            prpStmt6.setString(1, suster.getId_Suster());
            prpStmt6.setString(2, "");
            prpStmt6.setString(3, "");
            prpStmt6.setString(4, "");
            prpStmt6.setString(5, "");
            prpStmt6.setString(6, "");
            prpStmt6.setString(7, "");
            prpStmt6.setString(8, "");
            prpStmt6.setString(9, "");
            prpStmt6.setString(10, "");
            prpStmt6.setString(11, "");
            prpStmt6.executeUpdate();
            prpStmt6.close();
            
            PreparedStatement prpStmt7 = con.prepareStatement("INSERT INTO catatanpribadi_novis_dua_notes VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            prpStmt7.setString(1, suster.getId_Suster());
            prpStmt7.setString(2, "");
            prpStmt7.setString(3, "");
            prpStmt7.setString(4, "");
            prpStmt7.setString(5, "");
            prpStmt7.setString(6, "");
            prpStmt7.setString(7, "");
            prpStmt7.setString(8, "");
            prpStmt7.setString(9, "");
            prpStmt7.setString(10, "");
            prpStmt7.setString(11, "");
            prpStmt7.executeUpdate();
            prpStmt7.close();
            
            PreparedStatement prpStmt8 = con.prepareStatement("INSERT INTO catatanpribadi_yunior_satu_notes VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            prpStmt8.setString(1, suster.getId_Suster());
            prpStmt8.setString(2, "");
            prpStmt8.setString(3, "");
            prpStmt8.setString(4, "");
            prpStmt8.setString(5, "");
            prpStmt8.setString(6, "");
            prpStmt8.setString(7, "");
            prpStmt8.setString(8, "");
            prpStmt8.setString(9, "");
            prpStmt8.setString(10, "");
            prpStmt8.setString(11, "");
            prpStmt8.executeUpdate();
            prpStmt8.close();
            
            PreparedStatement prpStmt9 = con.prepareStatement("INSERT INTO catatanpribadi_yunior_dua_notes VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            prpStmt9.setString(1, suster.getId_Suster());
            prpStmt9.setString(2, "");
            prpStmt9.setString(3, "");
            prpStmt9.setString(4, "");
            prpStmt9.setString(5, "");
            prpStmt9.setString(6, "");
            prpStmt9.setString(7, "");
            prpStmt9.setString(8, "");
            prpStmt9.setString(9, "");
            prpStmt9.setString(10, "");
            prpStmt9.setString(11, "");
            prpStmt9.executeUpdate();
            prpStmt9.close();
            
            PreparedStatement prpStmt10 = con.prepareStatement("INSERT INTO catatanpribadi_yunior_tiga_notes VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            prpStmt10.setString(1, suster.getId_Suster());
            prpStmt10.setString(2, "");
            prpStmt10.setString(3, "");
            prpStmt10.setString(4, "");
            prpStmt10.setString(5, "");
            prpStmt10.setString(6, "");
            prpStmt10.setString(7, "");
            prpStmt10.setString(8, "");
            prpStmt10.setString(9, "");
            prpStmt10.setString(10, "");
            prpStmt10.setString(11, "");
            prpStmt10.executeUpdate();
            prpStmt10.close();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("./showSuster_");

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
