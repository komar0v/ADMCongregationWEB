/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv_catatanPribadi_yunior_satu;

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
import kelasJava.catatan_suster;
import kelasJava.koneksi_db;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "catPribadi_yunior_satu_postulan_dua", urlPatterns = {"/catPribadi_yunior_satu_postulan_dua"})
public class catPribadi_yunior_satu_postulan_dua extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            biodata_suster datanya = new biodata_suster();
            catatan_suster catatan = new catatan_suster();

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = koneksi_db.initializeDatabase();

            PreparedStatement ps = conn.prepareStatement("SELECT * from biodata_suster WHERE id_suster=?");
            PreparedStatement ps2 = conn.prepareStatement("SELECT * from catatanpribadi_yunior_satu_notes WHERE id_suster=?");

            String idnyaSuster = request.getParameter("id_suster");
            ps.setString(1, idnyaSuster);
            ps2.setString(1, idnyaSuster);

            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();

            if (rs.next()) {
                datanya.setId_Suster(rs.getString("id_suster"));
                datanya.setNama_suster(rs.getString("nama_suster"));
            }

            if (rs2.next()) {
                catatan.setCatatans(rs2.getString("postulan2"));
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
                        + "\n"
                        + "        <style type=\"text/css\">\n"
                        + "            a {\n"
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
                        + "            }\n"
                        + "        </style>    </head>\n"
                        + "\n"
                        + "    <body>\n"
                        + "        <div class=\"row\">\n"
                        + "            <a class=\"previous\" href=\"./catatanPribadi_suster?id_suster="+datanya.getId_Suster()+"\">&#10094; KEMBALI</a>\n"
                        + "        </div>        <div class=\"container bootstrap snippet\">\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"col-sm-10\"><h1>Data Catatan Pribadi</h1></div>\n"
                        + "\n"
                        + "            </div>\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"col-sm-3\"><!--left col-->\n"
                        + "\n"
                        + "\n"
                        + "                    <div class=\"text-center\">\n"
                        + "                        <img src=\"getImagefromDB?id_suster="+datanya.getId_Suster()+"\"  height=\"200\" width=\"200\" >\n"
                        + "\n"
                        + "                    </div><br>\n"
                        + "\n"
                        + "                </div><!--/col-3-->\n"
                        + "                <div class=\"col-sm-9\">\n"
                        + "                    <ul class=\"nav nav-tabs\">\n"
                        + "                        <li class=\"active\"><a href=\"#\">Yunior 1</a></li>\n"
                        + "                        <li ><a href=\"./catPribadi_yunior_dua_postulan_satu?id_suster="+datanya.getId_Suster()+"\">Yunior 2</a></li>\n"
                              + "                  <li ><a href=\"./catPribadi_yunior_tiga_postulan_satu?id_suster="+datanya.getId_Suster()+"\">Yunior 3</a></li>"
                        + "                        \n"
                        + "                        \n"
                        + "                    </ul>\n"
                        + "                    <ul class=\"nav nav-tabs\">\n"
                        + "                        <li ><a href=\"./catPribadi_yunior_satu_postulan_satu?id_suster="+datanya.getId_Suster()+"\">POSTULAN 1</a></li>\n"
                        + "                        <li class=\"active\"><a href=\"#\">POSTULAN 2</a></li>\n"
                        + "                        <li ><a href=\"./catPribadi_yunior_satu_postulan_tiga?id_suster="+datanya.getId_Suster()+"\">POSTULAN 3</a></li>\n"
                        + "                        <li ><a href=\"./catPribadi_yunior_satu_postulan_empat?id_suster="+datanya.getId_Suster()+"\">POSTULAN 4</a></li>\n"
                        + "                        <li ><a href=\"./catPribadi_yunior_satu_postulan_lima?id_suster="+datanya.getId_Suster()+"\">POSTULAN 5</a></li>\n"
                        + "                        <li ><a href=\"./catPribadi_yunior_satu_postulan_enam?id_suster="+datanya.getId_Suster()+"\">POSTULAN 6</a></li>\n"
                        + "                        <li ><a href=\"./catPribadi_yunior_satu_postulan_tujuh?id_suster="+datanya.getId_Suster()+"\">POSTULAN 7</a></li>\n"
                        + "                        <li ><a href=\"./catPribadi_yunior_satu_postulan_delapan?id_suster="+datanya.getId_Suster()+"\">POSTULAN 8</a></li>\n"
                        + "                        <li ><a href=\"./catPribadi_yunior_satu_postulan_sembilan?id_suster=" + datanya.getId_Suster() + "\">POSTULAN 9</a></li>\n"
                        + "                        <li ><a href=\"./catPribadi_yunior_satu_postulan_sepuluh?id_suster=" + datanya.getId_Suster() + "\">POSTULAN 10</a></li>\n"
                        + "                    </ul>\n"
                        + "\n"
                        + "\n"
                        + "                    <div class=\"tab-content\">\n"
                        + "                        <div class=\"tab-pane active\" id=\"home\">\n"
                        + "                            <form class=\"form\" action=\"./catPribadi_yunior_satu_postulan_dua_save\" method=\"POST\" id=\"registrationForm\">\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <h4>Nama Suster</h4>\n"
                        + "                                    <input type=\"text\"  class=\"form-control\" name=\"temp_name\" readonly value=\""+datanya.getNama_suster()+"\">\n"
                        + "                                </div>\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <h4>NIK Suster</h4>\n"
                        + "                                    <input type=\"text\"  class=\"form-control\" name=\"idSuster\" readonly value=\""+datanya.getId_Suster()+"\">\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <hr><h4>Catatan Pribadi</h4>                                    \n"
                        + "                                                                \n"
                        + "                                <div class=\"field_wrapper\">\n"
                        + "                                    <div>\n"
                        + "                                        \n"
                        + "                                        <textarea name=\"catanPribadi\" rows=\"15\" cols=\"90\">"+catatan.getCatatans()+"</textarea>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "\n"
                        + "\n"
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
                        + "\n"
                        + "    </body>\n"
                        + "\n"
                        + "</html>\n"
                        + "\n"
                        + "");
            } finally {
                out.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(catPribadi_yunior_satu_postulan_dua.class.getName()).log(Level.SEVERE, null, ex);
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
