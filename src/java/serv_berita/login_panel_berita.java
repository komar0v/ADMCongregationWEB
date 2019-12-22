/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv_berita;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "login_panel_berita", urlPatterns = {"/login_panel_berita"})
public class login_panel_berita extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("\n"
                    + "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>LOGIN</title>\n"
                    + "        <style type=\"text/css\">\n"
                    + "            /* 'Open Sans' font from Google Fonts */\n"
                    + "            @import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);\n"
                    + "\n"
                    + "            body {\n"
                    + "                background: #F5F5F5;\n"
                    + "                font-family: 'Open Sans', sans-serif;\n"
                    + "            }\n"
                    + "\n"
                    + "            .center {\n"
                    + "                line-height: 200px;\n"
                    + "                height: 200px;\n"
                    + "                text-align: center;\n"
                    + "                \n"
                    + "            }\n"
                    + "\n"
                    + "\n"
                    + "            .login {\n"
                    + "                width: 400px;\n"
                    + "                margin: 16px auto;\n"
                    + "                font-size: 16px;\n"
                    + "                vertical-align: middle;\n"
                    + "            }\n"
                    + "\n"
                    + "            /* Reset top and bottom margins from certain elements */\n"
                    + "            .login-header,\n"
                    + "            .login p {\n"
                    + "                margin-top: 0;\n"
                    + "                margin-bottom: 0;\n"
                    + "            }\n"
                    + "\n"
                    + "            /* The triangle form is achieved by a CSS hack */\n"
                    + "            .login-triangle {\n"
                    + "                width: 0;\n"
                    + "                margin-right: auto;\n"
                    + "                margin-left: auto;\n"
                    + "                border: 12px solid transparent;\n"
                    + "                border-bottom-color: #4CAF50;\n"
                    + "            }\n"
                    + "\n"
                    + "            .login-header {\n"
                    + "                background: #4CAF50;\n"
                    + "                padding: 20px;\n"
                    + "                font-size: 1.4em;\n"
                    + "                font-weight: normal;\n"
                    + "                text-align: center;\n"
                    + "                text-transform: uppercase;\n"
                    + "                color: #fff;\n"
                    + "            }\n"
                    + "\n"
                    + "            .login-container {\n"
                    + "                background: #ebebeb;\n"
                    + "                padding: 12px;\n"
                    + "            }\n"
                    + "\n"
                    + "            /* Every row inside .login-container is defined with p tags */\n"
                    + "            .login p {\n"
                    + "                padding: 12px;\n"
                    + "            }\n"
                    + "\n"
                    + "            .login input {\n"
                    + "                box-sizing: border-box;\n"
                    + "                display: block;\n"
                    + "                width: 100%;\n"
                    + "                border-width: 1px;\n"
                    + "                border-style: solid;\n"
                    + "                padding: 16px;\n"
                    + "                outline: 0;\n"
                    + "                font-family: inherit;\n"
                    + "                font-size: 0.95em;\n"
                    + "            }\n"
                    + "\n"
                    + "            .login input[type=\"email\"],\n"
                    + "            .login input[type=\"password\"] {\n"
                    + "                background: #fff;\n"
                    + "                border-color: #bbb;\n"
                    + "                color: #555;\n"
                    + "            }\n"
                    + "\n"
                    + "            /* Text fields' focus effect */\n"
                    + "            .login input[type=\"email\"]:focus,\n"
                    + "            .login input[type=\"password\"]:focus {\n"
                    + "                border-color: #888;\n"
                    + "            }\n"
                    + "\n"
                    + "            .login input[type=\"submit\"] {\n"
                    + "                background: #4CAF50;\n"
                    + "                border-color: transparent;\n"
                    + "                color: #fff;\n"
                    + "                cursor: pointer;\n"
                    + "            }\n"
                    + "\n"
                    + "            .login input[type=\"submit\"]:hover {\n"
                    + "                background: #17c;\n"
                    + "            }\n"
                    + "\n"
                    + "            /* Buttons' focus effect */\n"
                    + "            .login input[type=\"submit\"]:focus {\n"
                    + "                border-color: #05a;\n"
                    + "            }\n"
                    + "        </style>\n"
                    + "\n"
                    + "    </head>\n"
                    + "\n"
                    + "    <body>\n"
                    + "\n"
                    + "        <div class=\"login\">\n"
                    + "            <div class=\"login-triangle\"></div>\n"
                    + "            <h2 class=\"login-header\">Login Panel</h2>\n"
                    + "            <form class=\"login-container\" method=\"POST\" action=\"./login_ke_panel_berita\">\n"
                    + "                <p><input type=\"email\" name=\"email_\" placeholder=\"user\"></p>\n"
                    + "                <p><input type=\"password\" name=\"password_\" placeholder=\"pass\"></p>\n"
                    + "                <p><input type=\"submit\" value=\"Log In\"></p>\n"
                    + "            </form>\n"
                    + "        </div>\n"
                    + "\n"
                    + "    </body>\n"
                    + "\n"
                    + "</html>\n"
                    + "");
        } finally {
            out.close();
        }
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
