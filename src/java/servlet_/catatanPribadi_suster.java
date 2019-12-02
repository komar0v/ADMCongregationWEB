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
import kelasJava.koneksi_db;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "catatanPribadi_suster", urlPatterns = {"/catatanPribadi_suster"})
public class catatanPribadi_suster extends HttpServlet {

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
            String idnyaSuster = request.getParameter("id_suster");

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
                        + "                background-color: #1976D2;\n"
                        + "                color: white;\n"
                        + "            }\n"
                        + "\n"
                        + "            .round {\n"
                        + "                border-radius: 50%;\n"
                        + "            }\n"
                        + "        </style>    </head>\n"
                        + "\n"
                        + "    <body>\n"
                        + "        <div class=\"container bootstrap snippet\">\n"
                        + "            <div class=\"row\">\n"
                        + "                <a class=\"previous\" href=\"./detailViewSuster_?id_suster="+idnyaSuster+"\">&#10094; KEMBALI</a>\n"
                        + "            </div> \n"
                        + "            <div class=\"container bootstrap snippet\">\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-sm-10\"><h1>Edit Data Suster</h1></div>\n"
                        + "\n"
                        + "                </div>\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"col-sm-3\"><!--left col-->\n"
                        + "\n"
                        + "\n"
                        + "                        <div class=\"text-center\">\n"
                        + "                            <img src=\"getImagefromDB?id_suster="+idnyaSuster+"\"  height=\"200\" width=\"200\" >\n"
                        + "\n"
                        + "                        </div><br>\n"
                        + "\n"
                        + "                    </div><!--/col-3-->\n"
                        + "                    <div class=\"col-sm-9\">\n"
                        + "                        <ul class=\"nav nav-tabs\">\n"
                        + "                            <li ><a href=\"./editSusterView_?id_suster="+idnyaSuster+"\">Informasi Dasar</a></li>\n"
                        + "                            <li ><a href=\"./minatBakat_suster?id_suster="+idnyaSuster+"\">Minat Bakat</a></li>                        \n"
                        + "                            <li ><a href=\"./riwayatPendidikan_suster?id_suster="+idnyaSuster+"\">Riwayat Pendidikan</a></li>\n"
                        + "                            <li ><a href=\"./editDataBiaraView_?id_suster="+idnyaSuster+"\">Data Biara</a></li>                        \n"
                        + "                            <li ><a href=\"./seminarYgPernahIkut_suster?id_suster="+idnyaSuster+"\">Data Seminar</a></li>\n"
                        + "                            <li class=\"active\"><a href=\"#\">Catatan Pribadi</a></li>\n"
                        + "                        </ul>\n"
                        + "\n"
                        + "\n"
                        + "                        <div class=\"tab-content\">\n"
                        + "                            <div class=\"tab-pane active\" id=\"home\">\n"
                        + "                                    \n"
                        + "                                    <div class=\"form-group\">\n"
                        + "                                        <h4>NIK Suster</h4>\n"
                        + "                                        <input type=\"text\"  class=\"form-control\" name=\"idSuster\" readonly value=\""+idnyaSuster+"\">\n"
                        + "                                    </div>\n"
                        + "\n"
                        + "                                    <hr><h4>Catatan Pribadi Suster disimpan disini</h4>                                    \n"
                        + "                                    <h5>Klik salah satu link untuk masuk ke bagian catatan pribadi</h5>                                \n"
                        + "                                    <div class=\"field_wrapper\">\n"
                        + "                                        <div>\n"
                        + "                                            <center><a class=\"next\" href=\"./=#\">&#8811; CATATAN NOVIS&nbsp;&nbsp;</a></center>\n"
                        + "                                            <br>\n"
                        + "                                            <center><a class=\"next\" href=\"./=#\">&#8811; CATATAN YUNIOR</a></center>\n"
                        + "\n"
                        + "\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "\n"
                        + "\n"
                        + "                                    \n"
                        + "                                <hr>\n"
                        + "                            </div><!--/tab-pane-->\n"
                        + "                        </div><!--/tab-content-->\n"
                        + "\n"
                        + "                    </div><!--/col-9-->\n"
                        + "                </div><!--/row-->\n"
                        + "            </div>\n"
                        + "</div>\n"
                        + "    </body>\n"
                        + "\n"
                        + "</html>\n"
                        + "\n"
                        + "");

            } finally {
                out.close();
            }

        } catch (Exception ex) {
            Logger.getLogger(catatanPribadi_suster.class.getName()).log(Level.SEVERE, null, ex);
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
