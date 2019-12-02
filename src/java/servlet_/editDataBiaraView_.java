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
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "editDataBiaraView_", urlPatterns = {"/editDataBiaraView_"})
public class editDataBiaraView_ extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            dataBiara_suster datanya = new dataBiara_suster();

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = koneksi_db.initializeDatabase();

            PreparedStatement ps = conn.prepareStatement("SELECT * from databiara_suster WHERE id_suster=?");

            String idnyaSuster = request.getParameter("id_suster");
            ps.setString(1, idnyaSuster);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                datanya.setId_suster(rs.getString("id_suster"));
                datanya.setTempat_baptis(rs.getString("tempat_baptis"));
                datanya.setTanggal_baptis(rs.getString("tanggal_baptis"));
                datanya.setTempat_sakramen_krisma(rs.getString("tempat_sakramen_krisma"));
                datanya.setTanggal_sakramen_krisma(rs.getString("tanggal_sakramen_krisma"));
                datanya.setTempat_komuni_pertama(rs.getString("tempat_komuni_pertama"));
                datanya.setTanggal_komuni_pertama(rs.getString("tanggal_komuni_pertama"));
                datanya.setParoki_asal(rs.getString("paroki_asal"));
                datanya.setUkuran_pakaian(rs.getString("ukuran_pakaian"));
                datanya.setTempat_kleding(rs.getString("tempat_kleding"));
                datanya.setTanggal_kleding(rs.getString("tanggal_kleding"));
                datanya.setProfes_pertama(rs.getString("profes_pertama"));
                datanya.setTempat_pembaruan_pertama(rs.getString("tempat_pembaruan_pertama"));
                datanya.setTanggal_pembaruan_pertama(rs.getString("tanggal_pembaruan_pertama"));
                datanya.setTempat_pembaruan_kedua(rs.getString("tempat_pembaruan_kedua"));
                datanya.setTanggal_pembaruan_kedua(rs.getString("tanggal_pembaruan_kedua"));
                datanya.setTempat_pembaruan_ketiga(rs.getString("tempat_pembaruan_ketiga"));
                datanya.setTanggal_pembaruan_ketiga(rs.getString("tanggal_pembaruan_ketiga"));
                datanya.setTempat_kaulkekal(rs.getString("tempat_kaulkekal"));
                datanya.setTanggal_kaulkekal(rs.getString("tanggal_kaulkekal"));

            }
            try {
                out.println("\n"
                        + "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <title>Edit Data</title>\n"
                        + "        <meta charset=\"utf-8\">\n"
                        + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                        + "        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n"
                        + "        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n"
                        + "        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n"
                        + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n"
                        + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
                        + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n"
                        + "        <style type=\"text/css\">a {\n"
                        + "                text-decoration: none;\n"
                        + "                display: inline-block;\n"
                        + "                padding: 8px 16px;\n"
                        + "            }\n"
                        + "\n"
                        + "            a:hover {\n"
                        + "                background-color: #ddd;\n"
                        + "                color: black;\n"
                        + "            }\n"
                        + "\n"
                        + "            .previous {\n"
                        + "                background-color: #4CAF50;\n"
                        + "                color: black;\n"
                        + "            }\n"
                        + "\n"
                        + "            .next {\n"
                        + "                background-color: #4CAF50;\n"
                        + "                color: white;\n"
                        + "            }\n"
                        + "\n"
                        + "            .round {\n"
                        + "                border-radius: 50%;\n"
                        + "            }</style>    </head>\n"
                        + "\n"
                        + "    <body>\n"
                        + "        <div class=\"container bootstrap snippet\">\n"
                        + "            <div class=\"row\"> <a class=\"previous\" href=\"./detailViewSuster_?id_suster="+datanya.getId_suster()+"\">&#10094; KEMBALI</a></div>\n"
                        + "            <div class=\"row\">\n"
                        + "\n"
                        + "                <div class=\"col-sm-10\"><h1>Edit Data Suster</h1></div>\n"
                        + "\n"
                        + "            </div>\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"col-sm-3\"><!--left col-->\n"
                        + "\n"
                        + "\n"
                        + "                    <div class=\"text-center\">\n"
                        + "                        <img src=\"getImagefromDB?id_suster="+datanya.getId_suster()+"\"  height=\"200\" width=\"200\" >\n"
                        + "\n"
                        + "                    </div><br>\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "                </div><!--/col-3-->\n"
                        + "                <div class=\"col-sm-9\">\n"
                        + "                    <ul class=\"nav nav-tabs\">\n"
                        + "                        <li ><a href=\"./editSusterView_?id_suster="+datanya.getId_suster()+"\">Informasi Dasar</a></li>                        \n"
                        + "                        <li ><a href=\"./minatBakat_suster?id_suster="+datanya.getId_suster()+"\">Minat Bakat</a></li>                \n"
                        + "                        <li ><a href=\"./riwayatPendidikan_suster?id_suster="+datanya.getId_suster()+"\">Riwayat Pendidikan</a></li>\n"
                        + "                        <li class=\"active\"><a data-toggle=\"tab\" href=\"#\">Data Biara</a></li>   \n"
                        + "                        <li ><a href=\"./seminarYgPernahIkut_suster?id_suster="+datanya.getId_suster()+"\">Data Seminar</a></li>\n"
                        + "                        <li ><a href=\"./catatanPribadi_suster?id_suster="+datanya.getId_suster()+"\">Catatan Pribadi</a></li>\n"
                        + "                    </ul>\n"
                        + "\n"
                        + "\n"
                        + "                    <div class=\"tab-content\">\n"
                        + "                        <div class=\"tab-pane active\" id=\"home\">\n"
                        + "                           \n"
                        + "                            <form class=\"form\" action=\"./editDataBiaraLakukanPerubahan_\" method=\"POST\" id=\"registrationForm\">\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <h4>NIK Suster</h4>\n"
                        + "                                    <input type=\"text\"  class=\"form-control\" name=\"idSuster\" readonly value=\""+datanya.getId_suster()+"\">\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">                                    \n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Paroki Asal</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"parokiAsal\" required value=\""+datanya.getParoki_asal()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">                                    \n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Ukuran Pakaian</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"ukuranPakaian\" required value=\""+datanya.getUkuran_pakaian()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">                                    \n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tempat Baptis</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"tempatBaptis\" required value=\""+datanya.getTempat_baptis()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tanggal Baptis</h4>\n"
                        + "                                        <input type=\"date\" class=\"form-control\" name=\"tanggalBaptis\" required value=\""+datanya.getTanggal_baptis()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">                                    \n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tempat Sakramen Krisma</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"tempatSakramenKrisma\" required value=\""+datanya.getTempat_sakramen_krisma()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tanggal Sakramen Krisma</h4>\n"
                        + "                                        <input type=\"date\" class=\"form-control\" name=\"tanggalSakramenKrisma\" required value=\""+datanya.getTanggal_sakramen_krisma()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">                                    \n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tempat Komuni Pertama</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"tempatKomuniPertama\" required value=\""+datanya.getTempat_komuni_pertama()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tanggal Komuni Pertama</h4>\n"
                        + "                                        <input type=\"date\" class=\"form-control\" name=\"tanggalKomuniPertama\" required value=\""+datanya.getTanggal_komuni_pertama()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">                                    \n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tempat Kleding</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"tempatKleding\" required value=\""+datanya.getTempat_kleding()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tanggal Kleding</h4>\n"
                        + "                                        <input type=\"date\" class=\"form-control\" name=\"tanggalKleding\" required value=\""+datanya.getTanggal_kleding()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"col-xs-12\">\n"
                        + "                                    <hr>\n"
                        + "                                    <center>----------------------</center>\n"
                        + "                                </div>\n"
                        + "                                \n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Profes Pertama</h4>\n"
                        + "                                        <input type=\"date\" class=\"form-control\" name=\"profesPertama\" value=\""+datanya.getProfes_pertama()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                                \n"
                        + "                                <div class=\"col-xs-12\">\n"
                        + "                                    <hr>\n"
                        + "                                    <center>----------------------</center>\n"
                        + "                                </div>\n"
                        + "                                \n"
                        + "                                \n"
                        + "                                <div class=\"form-group\">                                    \n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tempat Pembaruan Pertama</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"tempatPembaruanPertama\" value=\""+datanya.getTempat_pembaruan_pertama()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tanggal Pembaruan Pertama</h4>\n"
                        + "                                        <input type=\"date\" class=\"form-control\" name=\"tanggalPembaruanPertama\" value=\""+datanya.getTanggal_pembaruan_pertama()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                                \n"
                        + "                                <div class=\"form-group\">                                    \n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tempat Pembaruan Kedua</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"tempatPembaruanKedua\" value=\""+datanya.getTempat_pembaruan_kedua()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tanggal Pembaruan Kedua</h4>\n"
                        + "                                        <input type=\"date\" class=\"form-control\" name=\"tanggalPembaruanKedua\" value=\""+datanya.getTanggal_pembaruan_kedua()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                                \n"
                        + "                                <div class=\"form-group\">                                    \n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tempat Pembaruan Ketiga</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"tempatPembaruanKetiga\" value=\""+datanya.getTempat_pembaruan_ketiga()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tanggal Pembaruan Ketiga</h4>\n"
                        + "                                        <input type=\"date\" class=\"form-control\" name=\"tanggalPembaruanKetiga\" value=\""+datanya.getTanggal_pembaruan_ketiga()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                                \n"
                        + "                                <div class=\"form-group\">                                    \n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tempat Kaul Kekal</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"tempatKaulKekal\" value=\""+datanya.getTempat_kaulkekal()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tanggal Kaul Kekal</h4>\n"
                        + "                                        <input type=\"date\" class=\"form-control\" name=\"tanggalKaulKekal\" value=\""+datanya.getTanggal_kaulkekal()+"\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                                \n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-12\">\n"
                        + "                                        <br>\n"
                        + "                                        <button class=\"button primary icon solid fa-save\" type=\"submit\">SIMPAN PERUBAHAN</button>\n"
                        + "                                        <button class=\"button icon solid\" type=\"reset\"><i class=\"glyphicon glyphicon-repeat\"></i> Reset</button>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </form>\n"
                        + "                            <hr>\n"
                        + "                        </div><!--/tab-pane-->\n"
                        + "                    </div><!--/tab-content-->\n"
                        + "\n"
                        + "                </div><!--/col-9-->\n"
                        + "            </div><!--/row-->\n"
                        + "        </div>\n"
                        + "    </body>\n"
                        + "\n"
                        + "</html>\n"
                        + "\n"
                        + "\n"
                        + "");
            } finally {
                out.close();
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(editDataBiaraView_.class.getName()).log(Level.SEVERE, null, ex);
        }

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
