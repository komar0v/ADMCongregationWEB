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
@WebServlet(name = "formAddRiwayatPendidikan_suster", urlPatterns = {"/formAddRiwayatPendidikan_suster"})
public class formAddRiwayatPendidikan_suster extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                + "    </head>\n"
                + "\n"
                + "    <body>\n"
                + "        <div class=\"container bootstrap snippet\">\n"
                + "            <div class=\"row\">\n"
                + "                <div class=\"col-sm-10\"><h1>Edit Data Suster</h1></div>\n"
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
                + "                        <li><a href=\"./editSusterView_?id_suster="+datanya.getId_Suster()+"\">Informasi Dasar</a></li>\n"
                + "                        <li><a href=\"./formAddMinatBakat_suster?id_suster="+datanya.getId_Suster()+"\">Minat Bakat</a></li>\n"
                + "                        <li class=\"active\" ><a data-toggle=\"tab\" href=\"#\">Riwayat Pendidikan</a></li>\n"
                + "                    </ul>\n"
                + "\n"
                + "\n"
                + "                    <div class=\"tab-content\">\n"
                + "                        <div class=\"tab-pane active\" id=\"home\">\n"
                + "                            <hr>\n"
                + "                            <form class=\"form\" action=\"#\" method=\"POST\" id=\"registrationForm\">\n"
                + "\n"
                + "                                <div class=\"form-group\">\n"
                + "                                    <h4>NIK Suster</h4>\n"
                + "                                    <input type=\"text\"  class=\"form-control\" name=\"idSuster\" readonly value=\""+datanya.getId_Suster()+"\">\n"
                + "                                </div>\n"
                + "\n<hr><h4>Riwayat Pendidikan</h4>"
                + "                                <div class=\"field_wrapper\">\n"
                + "                                    <div>\n"
                + "                                        <input type=\"text\" name=\"riwayatPendidikan1[]\" value=\"\" size=\"10\"/>\n"
                + "                                        <input type=\"text\" name=\"riwayatPendidikan2[]\" value=\"\" size=\"30\"/>\n"
                + "                                        <a href=\"javascript:void(0);\" class=\"add_button\" title=\"Add field\"><img src=\"https://img.icons8.com/pastel-glyph/64/000000/plus.png\" width=\"25\" height=\"25\"></a>\n"
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
                + "        <script>\n"
                + "            $(\".custom-file-input\").on(\"change\", function () {\n"
                + "                var fileName = $(this).val().split(\"\\\\\").pop();\n"
                + "                $(this).siblings(\".custom-file-label\").addClass(\"selected\").html(fileName);\n"
                + "            });\n"
                + "        </script>\n"
                + "        <script type=\"text/javascript\">\n"
                + "            $(document).ready(function () {\n"
                + "                var maxField = 10; //Input fields increment limitation\n"
                + "                var addButton = $('.add_button'); //Add button selector\n"
                + "                var wrapper = $('.field_wrapper'); \n"
                + "                var fieldHTML = '<div><input type=\"text\" name=\"riwayatPendidikan1[]\" value=\"\" size=\"10\"/> <input type=\"text\" name=\"riwayatPendidikan2[]\" value=\"\" size=\"30\"/><a href=\"javascript:void(0);\" class=\"remove_button\"><img src=\"https://img.icons8.com/pastel-glyph/64/000000/minus.png\" width=\"25\" height=\"25\"></a></div>';\n"
                + "                var x = 1; //Initial field counter is 1\n"
                + "\n"
                + "                //Once add button is clicked\n"
                + "                $(addButton).click(function () {\n"
                + "                    //Check maximum number of input fields\n"
                + "                    if (x < maxField) {\n"
                + "                        x++; //Increment field counter\n"
                + "                        $(wrapper).append(fieldHTML); //Add field html\n"
                + "                    }\n"
                + "                });\n"
                + "\n"
                + "                //Once remove button is clicked\n"
                + "                $(wrapper).on('click', '.remove_button', function (e) {\n"
                + "                    e.preventDefault();\n"
                + "                    $(this).parent('div').remove(); //Remove field html\n"
                + "                    x--; //Decrement field counter\n"
                + "                });\n"
                + "            });\n"
                + "        </script>\n"
                + "    </body>\n"
                + "\n"
                + "</html>\n"
                + "\n"
                + "");
        } finally {
                out.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(formAddRiwayatPendidikan_suster.class.getName()).log(Level.SEVERE, null, ex);
        }

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
