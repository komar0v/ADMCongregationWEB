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
import kelasJava.biodata_suster;
import kelasJava.koneksi_db;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "editSusterView_", urlPatterns = {"/editSusterView_"})
public class editSusterView_ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

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
        processRequest(request, response);

        PrintWriter out = response.getWriter();

        try {
            biodata_suster datanya = new biodata_suster();

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = koneksi_db.initializeDatabase();

            PreparedStatement ps = conn.prepareStatement("SELECT * from biodata_suster WHERE id_suster=?");

            String idnyaSuster = request.getParameter("id_suster");
            ps.setString(1, idnyaSuster);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                datanya.setId_Suster(rs.getString("id_suster"));
                datanya.setNama_suster(rs.getString("nama_suster"));
                datanya.setNama_asal_suster(rs.getString("nama_asal_suster"));
                datanya.setNama_ayah_suster(rs.getString("nama_ayah_suster"));
                datanya.setNama_ibu_suster(rs.getString("nama_ibu_suster"));
                datanya.setJmlh_saudara(rs.getInt("jmlh_saudara"));
                datanya.setAnak_ke(rs.getInt("anak_ke"));
                datanya.setTempat_lahir_suster(rs.getString("tempat_lahir_suster"));
                datanya.setTanggal_lahir_suster(rs.getString("tanggal_lahir_suster"));
            }

            try {
                out.println("<!DOCTYPE html>\n"
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
                        + "<style type=\"text/css\">"
                        + "a {\n"
                        + "  text-decoration: none;\n"
                        + "  display: inline-block;\n"
                        + "  padding: 8px 16px;\n"
                        + "}\n"
                        + "\n"
                        + "a:hover {\n"
                        + "  background-color: #ddd;\n"
                        + "  color: black;\n"
                        + "}\n"
                        + "\n"
                        + ".previous {\n"
                        + "  background-color: #4CAF50;\n"
                        + "  color: black;\n"
                        + "}\n"
                        + "\n"
                        + ".next {\n"
                        + "  background-color: #4CAF50;\n"
                        + "  color: white;\n"
                        + "}\n"
                        + "\n"
                        + ".round {\n"
                        + "  border-radius: 50%;\n"
                        + "}"
                        + "</style>"
                        + "    </head>\n"
                        + "\n"
                        + "    <body>\n"
                        + "        <div class=\"container bootstrap snippet\">\n"
                        + "<div class=\"row\"> "
                        + "<a class=\"previous\" href=\"./detailViewSuster_?id_suster=" + datanya.getId_Suster() + "\">&#10094; KEMBALI</a>"
                        + "</div>\n"
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
                        + "                        <img src=\"getImagefromDB?id_suster=" + datanya.getId_Suster() + "\"  height=\"200\" width=\"200\" >\n"
                        + "\n"
                        + "                    </div><br>\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "                </div><!--/col-3-->\n"
                        + "                <div class=\"col-sm-9\">\n"
                        + "                    <ul class=\"nav nav-tabs\">\n"
                        + "                        <li class=\"active\"><a data-toggle=\"tab\" href=\"#\">Informasi Dasar</a></li>"
                        + "                        <li ><a href=\"./minatBakat_suster?id_suster=" + datanya.getId_Suster() + "\">Minat Bakat</a></li>"
                        + "                        <li ><a href=\"./riwayatPendidikan_suster?id_suster=" + datanya.getId_Suster() + "\">Riwayat Pendidikan</a></li>\n"
                        + "                        <li ><a href=\"./editDataBiaraView_?id_suster="+datanya.getId_Suster()+"\">Data Biara</a></li>            "
                        + "                    <li ><a href=\"./seminarYgPernahIkut_suster?id_suster="+datanya.getId_Suster()+"\">Data Seminar</a></li>\n"
                        + "                    </ul>\n"
                        + "\n"
                        + "\n"
                        + "                    <div class=\"tab-content\">\n"
                        + "                        <div class=\"tab-pane active\" id=\"home\">\n"
                        + "                            <hr>\n"
                        + "                            <form class=\"form\" action=\"./editSusterLakukanPerubahan_\" method=\"POST\" id=\"registrationForm\" enctype=\"multipart/form-data\">\n"
                        + "                                    "
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                   <h4>NIK Suster</h4>\n <input type=\"text\"  class=\"form-control\" name=\"idSuster\" readonly value=\"" + datanya.getId_Suster() + "\">\n<h6>Untuk ganti foto klik dibawah ini</h6>\n"
                        + "                                    <div class=\"custom-file mb-3\">\n"
                        + "                                        <input type=\"file\" class=\"custom-file-input\" id=\"fotoSuster\" name=\"fotoSuster\" required accept=\"image/*\"/>\n"
                        + "                                        <label class=\"custom-file-label\" for=\"customFile\">FILE FOTO</label>\n"
                        + "                                    </div>\n"
                        + "                                </div><div class=\"form-group\">"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Nama Suster</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"namaSuster\" required value=\"" + datanya.getNama_suster() + "\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Nama Asal Suster</h4>\n"
                        + "                                        <input type=\"text\" class=\"form-control\" name=\"namaAsal\" required value=\"" + datanya.getNama_asal_suster() + "\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Nama Ayah</h4>\n"
                        + "                                        <input type=\"text\" class=\"form-control\" name=\"namaAyah\" required value=\"" + datanya.getNama_ayah_suster() + "\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Nama Ibu</h4>\n"
                        + "                                        <input type=\"text\" class=\"form-control\" name=\"namaIbu\" required value=\"" + datanya.getNama_ibu_suster() + "\">\n"
                        + "                                    </div>\n"
                        + "                                </div>"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Jumlah Saudara</h4>\n"
                        + "                                        <input type=\"number\" min=\"0\" class=\"form-control\" required name=\"jmlh_saudara\" value=\"" + datanya.getJmlh_saudara() + "\">\n"
                        + "                                    </div>\n"
                        + "                                </div>"
                        + "\n"
                        + "                        <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Anak ke</h4>\n"
                        + "                                        <input type=\"number\" min=\"1\" class=\"form-control\" required name=\"anak_ke\" value=\"" + datanya.getAnak_ke() + "\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tempat Lahir</h4>\n"
                        + "                                        <input type=\"text\" class=\"form-control\" name=\"tempat_lahir_suster\" required value=\"" + datanya.getTempat_lahir_suster() + "\">\n"
                        + "                                    </div>\n"
                        + "                                </div>"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <div class=\"col-xs-6\">\n"
                        + "                                        <h4>Tanggal Lahir</h4>\n"
                        + "                                        <input type=\"date\" class=\"form-control\" required name=\"tanggal_lahir_suster\" value=\"" + datanya.getTanggal_lahir_suster() + "\">\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
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
                        + "        <script>\n"
                        + "// Add the following code if you want the name of the file appear on select\n"
                        + "            $(\".custom-file-input\").on(\"change\", function () {\n"
                        + "                var fileName = $(this).val().split(\"\\\\\").pop();\n"
                        + "                $(this).siblings(\".custom-file-label\").addClass(\"selected\").html(fileName);\n"
                        + "            });\n"
                        + "        </script>\n"
                        + "    </body>\n"
                        + "\n"
                        + "</html>\n"
                        + "");
            } finally {
                out.close();
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(editSusterView_.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
