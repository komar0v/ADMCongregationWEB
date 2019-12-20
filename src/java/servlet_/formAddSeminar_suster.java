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
@WebServlet(name = "formAddSeminar_suster", urlPatterns = {"/formAddSeminar_suster"})
public class formAddSeminar_suster extends HttpServlet {

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
                datanya.setNama_suster(rs.getString("nama_suster"));
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
                        + "\n"
                        + "<style type=\"text/css\">\n"
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
                        + "}\n"
                        + "</style>    </head>\n"
                        + "\n"
                        + "    <body>\n"
                        + "<div class=\"row\">\n"
                        + "<a class=\"previous\" href=\"./seminarYgPernahIkut_suster?id_suster=" + datanya.getId_Suster() + "\">&#10094; KEMBALI</a>\n"
                        + "</div>        <div class=\"container bootstrap snippet\">\n"
                        + "            <div class=\"row\">\n"
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
                        + "                </div><!--/col-3-->\n"
                        + "                <div class=\"col-sm-9\">\n"
                        + "                    <ul class=\"nav nav-tabs\">\n"
                        + "                        <li class=\"active\" ><a data-toggle=\"tab\" href=\"#\">Tambah Seminar</a></li>\n"
                        + "                    </ul>\n"
                        + "\n"
                        + "\n"
                        + "                    <div class=\"tab-content\">\n"
                        + "                        <div class=\"tab-pane active\" id=\"home\">\n"
                        + "                            <hr>\n"
                        + "                            <form class=\"form\" action=\"./tambahSeminarYgPernahIkut_suster\" method=\"GET\" id=\"registrationForm\">\n"
                        + "\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                   <h4>Nama Suster</h4>\n"
                        + "				      <input type=\"text\"  class=\"form-control\" name=\"temp_name\" readonly value=\"" + datanya.getNama_suster() + "\">\n"
                        + "                                </div>\n"
                        + "                                <div class=\"form-group\">\n"
                        + "                                    <h4>NIK Suster</h4>\n"
                        + "                                    <input type=\"text\"  class=\"form-control\" name=\"idSuster\" readonly value=\"" + datanya.getId_Suster() + "\">\n"
                        + "                                </div>\n"
                        + "\n"
                        + "                                <hr><h4>Seminar yang pernah diikuti</h4>"
                        + "                                    <h5>Bila tidak ada sertifikat isi \"tidak ada\"</h5>"
                        + "                                    <div id=\"error_msg\"></div>"
                        + "                                <div class=\"field_wrapper\">\n"
                        + "                                    <div>\n"
                        + "                                        <input type=\"text\" id=\"inputan1\" name=\"seminar_suster1[]\" value=\"\" placeholder=\"nama seminar\" size=\"30\"/>\n"
                        + "                                        <input type=\"text\" id=\"inputan2\" name=\"seminar_suster2[]\" value=\"\" placeholder=\"nama sertifikat yang diterima\" size=\"30\"/>\n"
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
                        + "                var fieldHTML = '<div><input type=\"text\" name=\"seminar_suster1[]\" value=\"\" placeholder=\"nama seminar\" size=\"30\"/> <input type=\"text\" name=\"seminar_suster2[]\" value=\"\" placeholder=\"nama sertifikat yang diterima\" size=\"30\"/><a href=\"javascript:void(0);\" class=\"remove_button\"><img src=\"https://img.icons8.com/pastel-glyph/64/000000/minus.png\" width=\"25\" height=\"25\"></a></div>';\n"
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
                        + "        </script>"
                        + "        <script>"
                        + "         $(document).ready(function(){\n"
                        + "      $(\"#inputan1\").keypress(function (e) {\n"
                        + "        var key = e.keyCode || e.which;       \n"
                        + "        $(\"#error_msg\").html(\"\");\n"
                        + "        //Regular Expression\n"
                        + "        var reg_exp = /^[A-Za-z0-9 ]+$/;\n"
                        + "        //Validate Text Field value against the Regex.\n"
                        + "        var is_valid = reg_exp.test(String.fromCharCode(key));\n"
                        + "        if (!is_valid) {\n"
                        + "          $(\"#error_msg\").html(\"<h5>Jangan masukkan tanda koma (,) didalam kotak.</h5>\");\n"
                        + "        }\n"
                        + "        return is_valid;\n"
                        + "      });\n"
                        + "    });"
                        + "            </script>"
                        + ""
                        + "<script>"
                        + "         $(document).ready(function(){\n"
                        + "      $(\"#inputan2\").keypress(function (e) {\n"
                        + "        var key = e.keyCode || e.which;       \n"
                        + "        $(\"#error_msg\").html(\"\");\n"
                        + "        //Regular Expression\n"
                        + "        var reg_exp = /^[A-Za-z0-9 ]+$/;\n"
                        + "        //Validate Text Field value against the Regex.\n"
                        + "        var is_valid = reg_exp.test(String.fromCharCode(key));\n"
                        + "        if (!is_valid) {\n"
                        + "          $(\"#error_msg\").html(\"<h5>Jangan masukkan tanda koma (,) didalam kotak.</h5>\");\n"
                        + "        }\n"
                        + "        return is_valid;\n"
                        + "      });\n"
                        + "    });"
                        + "            </script>"
                        + "    </body>\n"
                        + "\n"
                        + "</html>\n"
                        + "");
            } finally {
                out.close();
            }

        } catch (Exception ex) {
            Logger.getLogger(formAddSeminar_suster.class.getName()).log(Level.SEVERE, null, ex);
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
