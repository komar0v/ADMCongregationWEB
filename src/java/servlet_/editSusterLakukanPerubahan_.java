/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
@WebServlet(name = "editSusterLakukanPerubahan_", urlPatterns = {"/editSusterLakukanPerubahan_"})
public class editSusterLakukanPerubahan_ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        PrintWriter out = response.getWriter();
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
            PreparedStatement prpStmt = con.prepareStatement("UPDATE biodata_suster SET nama_suster=?, nama_asal_suster=?, tempat_lahir_suster=?, tanggal_lahir_suster=?, nama_ayah_suster=?, nama_ibu_suster=?, anak_ke=?, jmlh_saudara=?, foto=? WHERE id_suster=?");
            
            prpStmt.setString(1, suster.getNama_suster());
            prpStmt.setString(2, suster.getNama_asal_suster());
            prpStmt.setString(3, suster.getTempat_lahir_suster());
            prpStmt.setString(4, suster.getTanggal_lahir_suster());
            prpStmt.setString(5, suster.getNama_ayah_suster());
            prpStmt.setString(6, suster.getNama_ibu_suster());
            prpStmt.setInt(7, suster.getAnak_ke());
            prpStmt.setInt(8, suster.getJmlh_saudara());
            prpStmt.setBlob(9, inputStream);
            prpStmt.setString(10, suster.getId_Suster());

            prpStmt.executeUpdate();
            prpStmt.close();
            con.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("./showSuster");
        
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
