/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet_;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "home_", urlPatterns = {"/home_"})
public class home_ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_user = null;
        String nama_user = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("namaUser")) {
                    nama_user = cookie.getValue();
                }
                if (cookie.getName().equals("idUser")) {
                    id_user = cookie.getValue();
                }
            }

            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>\n"
                    + "<html lang=\"en\" >\n"
                    + "    <head>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <title>HOME ADM</title>\n"
                    + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js\" type=\"text/javascript\"></script>\n"
                    + "\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n"
                    + "        <link href=\"https://fonts.googleapis.com/css?family=Nunito:600&display=swap\" rel=\"stylesheet\">\n"
                    + "        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css\">\n"
                    + "        <style type=\"text/css\">\n"
                    + "            @import url(http://weloveiconfonts.com/api/?family=entypo);\n"
                    + "            @import url('https://fonts.googleapis.com/css?family=Nunito:600&display=swap');\n"
                    + "            @import url('https://fonts.googleapis.com/css?family=Heebo&display=swap');\n"
                    + "            .board:after {\n"
                    + "                clear: both;\n"
                    + "                content: \"\";\n"
                    + "                display: table;\n"
                    + "            }\n"
                    + "            .board:before {\n"
                    + "                content: \"\";\n"
                    + "                display: table;\n"
                    + "            }\n"
                    + "\n"
                    + "            *, *:before, *:after {\n"
                    + "                -moz-box-sizing: border-box;\n"
                    + "                -webkit-box-sizing: border-box;\n"
                    + "                box-sizing: border-box;\n"
                    + "            }\n"
                    + "\n"
                    + "            [class*=\"entypo-\"]:before {\n"
                    + "                font-family: 'entypo', sans-serif;\n"
                    + "                font-style: normal;\n"
                    + "                display: block;\n"
                    + "            }\n"
                    + "\n"
                    + "            i {\n"
                    + "                font-size: 4em;\n"
                    + "                line-height: 1;\n"
                    + "            }\n"
                    + "\n"
                    + "            h5 {\n"
                    + "                font-family: \"Heebo\";\n"
                    + "                font-weight: 700;\n"
                    + "                font-size: 1.5em;\n"
                    + "                line-height: 1;\n"
                    + "                margin: .5em;\n"
                    + "                position: relative;\n"
                    + "                z-index: 99;\n"
                    + "            }\n"
                    + "\n"
                    + "            body {\n"
                    + "                background: #fafafa;\n"
                    + "                color: #a5a5a5;\n"
                    + "                text-align: center;\n"
                    + "                padding: 2em 0 0;\n"
                    + "                font-family: \"Nunito\";\n"
                    + "                font-weight: 400;\n"
                    + "            }\n"
                    + "\n"
                    + "            .board {\n"
                    + "                width: 860px;\n"
                    + "                margin: 4em auto;\n"
                    + "            }\n"
                    + "\n"
                    + "            section {\n"
                    + "                width: 33.333333333333333%;\n"
                    + "                display: block;\n"
                    + "                float: left;\n"
                    + "                position: relative;\n"
                    + "                height: 12em;\n"
                    + "                border: 1px solid #f2f2f2;\n"
                    + "                overflow: hidden;\n"
                    + "            }\n"
                    + "\n"
                    + "            .tile {\n"
                    + "                padding: 2em .8em;\n"
                    + "                position: absolute;\n"
                    + "                width: 100%;\n"
                    + "                height: 100%;\n"
                    + "                -moz-transition: top 0.55s ease-in;\n"
                    + "                -o-transition: top 0.55s ease-in;\n"
                    + "                -webkit-transition: top 0.55s ease-in;\n"
                    + "                transition: top 0.55s ease-in;\n"
                    + "            }\n"
                    + "            .tile:hover {\n"
                    + "                cursor: pointer;\n"
                    + "            }\n"
                    + "\n"
                    + "            .desc {\n"
                    + "                top: 100%;\n"
                    + "                padding-top: 4em;\n"
                    + "                background: #f7f7f7 span;\n"
                    + "                background-display: block;\n"
                    + "                background-margin: 0 0 .75em;\n"
                    + "            }\n"
                    + "\n"
                    + "            /*** Animations ***/\n"
                    + "            @keyframes spinOut {\n"
                    + "                0% {\n"
                    + "                    transform: rotate(0deg);\n"
                    + "                    opacity: 1.0;\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    transform: rotate(360deg);\n"
                    + "                    opacity: 0;\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @keyframes spinIn {\n"
                    + "                0% {\n"
                    + "                    transform: rotate(0deg);\n"
                    + "                    opacity: 0;\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    transform: rotate(-360deg);\n"
                    + "                    opacity: 1.0;\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @keyframes scootOut {\n"
                    + "                0% {\n"
                    + "                    transform: translateY(0);\n"
                    + "                }\n"
                    + "                5% {\n"
                    + "                    transform: translateY(-15px);\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    transform: translateY(110px);\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @keyframes scootIn {\n"
                    + "                0% {\n"
                    + "                    transform: translateY(110px);\n"
                    + "                }\n"
                    + "                66% {\n"
                    + "                    transform: translateY(-5px);\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    transform: translateY(0px);\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @-webkit-keyframes spinOut {\n"
                    + "                0% {\n"
                    + "                    -webkit-transform: rotate(0deg);\n"
                    + "                    opacity: 1.0;\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    -webkit-transform: rotate(360deg);\n"
                    + "                    opacity: 0;\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @-webkit-keyframes spinIn {\n"
                    + "                0% {\n"
                    + "                    -webkit-transform: rotate(0deg);\n"
                    + "                    opacity: 0;\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    -webkit-transform: rotate(-360deg);\n"
                    + "                    opacity: 1.0;\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @-webkit-keyframes scootOut {\n"
                    + "                0% {\n"
                    + "                    -webkit-transform: translateY(0);\n"
                    + "                }\n"
                    + "                5% {\n"
                    + "                    -webkit-transform: translateY(-15px);\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    -webkit-transform: translateY(110px);\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @-webkit-keyframes scootIn {\n"
                    + "                0% {\n"
                    + "                    -webkit-transform: translateY(110px);\n"
                    + "                }\n"
                    + "                66% {\n"
                    + "                    -webkit-transform: translateY(-5px);\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    -webkit-transform: translateY(0px);\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @-moz-keyframes spinOut {\n"
                    + "                0% {\n"
                    + "                    -moz-transform: rotate(0deg);\n"
                    + "                    opacity: 1.0;\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    -moz-transform: rotate(360deg);\n"
                    + "                    opacity: 0;\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @-moz-keyframes spinIn {\n"
                    + "                0% {\n"
                    + "                    -moz-transform: rotate(0deg);\n"
                    + "                    opacity: 0;\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    -moz-transform: rotate(-360deg);\n"
                    + "                    opacity: 1.0;\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @-moz-keyframes scootOut {\n"
                    + "                0% {\n"
                    + "                    -moz-transform: translateY(0);\n"
                    + "                }\n"
                    + "                5% {\n"
                    + "                    -moz-transform: translateY(-15px);\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    -moz-transform: translateY(110px);\n"
                    + "                }\n"
                    + "            }\n"
                    + "            @-moz-keyframes scootIn {\n"
                    + "                0% {\n"
                    + "                    -moz-transform: translateY(110px);\n"
                    + "                }\n"
                    + "                66% {\n"
                    + "                    -moz-transform: translateY(-5px);\n"
                    + "                }\n"
                    + "                100% {\n"
                    + "                    -moz-transform: translateY(0px);\n"
                    + "                }\n"
                    + "            }\n"
                    + "            .spin-in {\n"
                    + "                animation: spinIn 0.4s 0.2s ease both;\n"
                    + "                -moz-animation: spinIn 0.4s 0.2s ease both;\n"
                    + "                -webkit-animation: spinIn 0.4s 0.2s ease both;\n"
                    + "            }\n"
                    + "\n"
                    + "            .spin-out {\n"
                    + "                animation: spinOut 0.4s 0s ease both;\n"
                    + "                -moz-animation: spinOut 0.4s 0s ease both;\n"
                    + "                -webkit-animation: spinOut 0.4s 0s ease both;\n"
                    + "            }\n"
                    + "\n"
                    + "            .scoot-out {\n"
                    + "                animation: scootOut 0.5s 0s ease both;\n"
                    + "                -moz-animation: scootOut 0.5s 0s ease both;\n"
                    + "                -webkit-animation: scootOut 0.5s 0s ease both;\n"
                    + "            }\n"
                    + "\n"
                    + "            .scoot-in {\n"
                    + "                animation: scootIn 1s 0s ease both;\n"
                    + "                -moz-animation: scootIn 1s 0s ease both;\n"
                    + "                -webkit-animation: scootIn 1s 0s ease both;\n"
                    + "            }\n"
                    + "        </style>\n"
                    + "\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <!-- partial:index.partial.html -->\n"
                    + "        <h1>Home ADM</h1>\n"
                    + "        <h3>Selamat datang, "+nama_user+"</h3>"
                    + "        <div class=\"board\">\n"
                    + "\n"
                    + "            <section>\n"
                    + "                <div onclick=\"location.href='./formAdd_suster';\" style=\"cursor: pointer;\" class=\"tile cover\">\n"
                    + "                    <i class=\"entypo-plus-squared\"></i>\n"
                    + "                    <h5>Tambah Data</h5>\n"
                    + "                </div>\n"
                    + "                <div class=\"tile desc\">\n"
                    + "                    <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod ab ipsa commodi quas voluptatibus?</span>\n"
                    + "                    <a href=\"\">View Project</a>\n"
                    + "                </div>\n"
                    + "            </section>\n"
                    + "\n"
                    + "            <section>\n"
                    + "                <div onclick=\"location.href='./showSuster_';\" style=\"cursor: pointer;\" class=\"tile cover\">\n"
                    + "                    <i class=\"entypo-eye\"></i>\n"
                    + "                    <h5>Lihat Data</h5>\n"
                    + "                </div>\n"
                    + "                <div class=\"tile desc\">\n"
                    + "                    <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod ab ipsa commodi quas voluptatibus.</span>\n"
                    + "                    <a href=\"\">View Project</a>\n"
                    + "                </div>\n"
                    + "            </section>\n"
                    + "\n"
                    + "            <section>\n"
                    + "                <div onclick=\"location.href='./pengaturan_akun';\" style=\"cursor: pointer;\" class=\"tile cover\">\n"
                    + "                    <i class=\"entypo-cog\"></i>\n"
                    + "                    <h5>Pengaturan Akun</h5>\n"
                    + "                </div>\n"
                    + "                <div class=\"tile desc\">\n"
                    + "                    <span>TYPE TEXT HERE</span>\n"
                    + "                    <a href=\"./logs_\">View Project</a>\n"
                    + "                </div>\n"
                    + "            </section>\n"
                    + "\n"
                    + "            <section>\n"
                    + "                <div class=\"\">\n"
                    + "                    <i class=\"\"></i>\n"
                    + "                    <h5></h5>\n"
                    + "                </div>\n"
                    + "                <div >\n"
                    + "                    <span></span>\n"
                    + "                </div>\n"
                    + "            </section>\n"
                    + "\n"
                    + "            <section>\n"
                    + "                <div onclick=\"location.href='./doLogout';\" style=\"cursor: pointer;\" class=\"tile cover\">\n"
                    + "                    <i class=\"entypo-logout\"></i>\n"
                    + "                    <h5>Logout</h5>\n"
                    + "                </div>\n"
                    + "                <div class=\"tile desc\">\n"
                    + "                    <span>Untuk logout silahkan..</span>\n"
                    + "                    <a href=\"#\">View Project</a>\n"
                    + "                </div>\n"
                    + "            </section>\n"
                    + "\n"
                    + "            <section>\n"
                    + "                <div class=\"\">\n"
                    + "                    <i class=\"\"></i>\n"
                    + "                    <h5></h5>\n"
                    + "                </div>\n"
                    + "                <div >\n"
                    + "                    <span></span>\n"
                    + "                </div>\n"
                    + "            </section>\n"
                    + "\n"
                    + "        </div>\n"
                    + "        <!-- partial -->\n"
                    + "        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script  src=\"./script.js\"></script>\n"
                    + "        <script>\n"
                    + "            $(document).ready(function () {\n"
                    + "                $('section').click(function () {\n"
                    + "                    var $this = $(this);\n"
                    + "                    if ($this.hasClass(\"show-desc\")) {\n"
                    + "                        $this.find('div.cover').css({top: \"0\"});\n"
                    + "                        $this.find('div.desc').css({top: \"100%\"});\n"
                    + "                        $this.find('[class*=\"entypo-\"]').removeClass('spin-out').addClass('spin-in');\n"
                    + "                        $this.find('.cover h5').addClass('scoot-in');\n"
                    + "                        $this.removeClass(\"show-desc\");\n"
                    + "                    } else {\n"
                    + "                        $this.find('div.cover').css({top: \"-100%\"});\n"
                    + "                        $this.find('div.desc').css({top: \"0\"});\n"
                    + "                        $this.find('[class*=\"entypo-\"]').removeClass('spin-in').addClass('spin-out');\n"
                    + "                        $this.find('.cover h5').removeClass('scoot-in').addClass('scoot-out');\n"
                    + "                        $this.addClass(\"show-desc\");\n"
                    + "                    }\n"
                    + "                });\n"
                    + "            });\n"
                    + "        </script>\n"
                    + "\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");
        } else {
            response.sendRedirect("./index.html");
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
