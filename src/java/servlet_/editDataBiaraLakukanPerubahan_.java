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
import kelasJava.dataBiara_suster;
import kelasJava.koneksi_db;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "editDataBiaraLakukanPerubahan_", urlPatterns = {"/editDataBiaraLakukanPerubahan_"})
public class editDataBiaraLakukanPerubahan_ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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

        dataBiara_suster datanya = new dataBiara_suster();
        datanya.setId_suster(request.getParameter("idSuster"));
        datanya.setTempat_baptis(request.getParameter("tempatBaptis"));
        datanya.setTanggal_baptis(request.getParameter("tanggalBaptis"));
        datanya.setTempat_sakramen_krisma(request.getParameter("tempatSakramenKrisma"));
        datanya.setTanggal_sakramen_krisma(request.getParameter("tanggalSakramenKrisma"));
        datanya.setTempat_komuni_pertama(request.getParameter("tempatKomuniPertama"));
        datanya.setTanggal_komuni_pertama(request.getParameter("tanggalKomuniPertama"));
        datanya.setParoki_asal(request.getParameter("parokiAsal"));
        datanya.setUkuran_pakaian(request.getParameter("ukuranPakaian"));
        datanya.setTempat_kleding(request.getParameter("tempatKleding"));
        datanya.setTanggal_kleding(request.getParameter("tanggalKleding"));
        datanya.setProfes_pertama(request.getParameter("profesPertama"));
        datanya.setTempat_pembaruan_pertama(request.getParameter("tempatPembaruanPertama"));
        datanya.setTanggal_pembaruan_pertama(request.getParameter("tanggalPembaruanPertama"));
        datanya.setTempat_pembaruan_kedua(request.getParameter("tempatPembaruanKedua"));
        datanya.setTanggal_pembaruan_kedua(request.getParameter("tanggalPembaruanKedua"));
        datanya.setTempat_pembaruan_ketiga(request.getParameter("tempatPembaruanKetiga"));
        datanya.setTanggal_pembaruan_ketiga(request.getParameter("tanggalPembaruanKetiga"));
        datanya.setTempat_kaulkekal(request.getParameter("tempatKaulKekal"));
        datanya.setTanggal_kaulkekal(request.getParameter("tanggalKaulKekal"));
        datanya.setTempat_aspiran(request.getParameter("tempat_aspiran"));
        datanya.setTempat_postulat(request.getParameter("tempat_postulat"));
        //hehe
        try {
            Connection con = koneksi_db.initializeDatabase();
            PreparedStatement prpStmt = con.prepareStatement("UPDATE databiara_suster SET tempat_baptis=?, tanggal_baptis=?, tempat_sakramen_krisma=?, tanggal_sakramen_krisma=?, tempat_komuni_pertama=?, tanggal_komuni_pertama=?, paroki_asal=?, ukuran_pakaian=?, tempat_kleding=?, tanggal_kleding=?, profes_pertama=?, tempat_pembaruan_pertama=?, tanggal_pembaruan_pertama=?, tempat_pembaruan_kedua=?, tanggal_pembaruan_kedua=?, tempat_pembaruan_ketiga=?, tanggal_pembaruan_ketiga=?, tempat_kaulkekal=?, tanggal_kaulkekal=?, tempat_aspiran=?, tempat_postulat=? WHERE id_suster=?");
            prpStmt.setString(1, datanya.getTempat_baptis());
            prpStmt.setString(2, datanya.getTanggal_baptis());
            prpStmt.setString(3, datanya.getTempat_sakramen_krisma());
            prpStmt.setString(4, datanya.getTanggal_sakramen_krisma());
            prpStmt.setString(5, datanya.getTempat_komuni_pertama());
            prpStmt.setString(6, datanya.getTanggal_komuni_pertama());
            prpStmt.setString(7, datanya.getParoki_asal());
            prpStmt.setString(8, datanya.getUkuran_pakaian());
            prpStmt.setString(9, datanya.getTempat_kleding());
            prpStmt.setString(10, datanya.getTanggal_kleding());
            prpStmt.setString(11, datanya.getProfes_pertama());
            prpStmt.setString(12, datanya.getTempat_pembaruan_pertama());
            prpStmt.setString(13, datanya.getTanggal_pembaruan_pertama());
            prpStmt.setString(14, datanya.getTempat_pembaruan_kedua());
            prpStmt.setString(15, datanya.getTanggal_pembaruan_kedua());
            prpStmt.setString(16, datanya.getTempat_pembaruan_ketiga());
            prpStmt.setString(17, datanya.getTanggal_pembaruan_ketiga());
            prpStmt.setString(18, datanya.getTempat_kaulkekal());
            prpStmt.setString(19, datanya.getTanggal_kaulkekal());
            prpStmt.setString(20, datanya.getTempat_aspiran());
            prpStmt.setString(21, datanya.getTempat_postulat());
            prpStmt.setString(22, datanya.getId_suster());
            
            prpStmt.executeUpdate();
            prpStmt.close();
            con.close();
            try {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data biara berhasil diedit!');");
                out.println("location='./showSuster_';");
                out.println("</script>");

            } finally {
                out.close();
            }
        }
        catch(Exception e){
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
