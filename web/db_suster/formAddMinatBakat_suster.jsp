<%-- 
    Document   : formAddMinatBakat_suster
    Created on : Nov 17, 2019, 1:23:07 PM
    Author     : ASUS
--%>

<%@page import="kelasJava.biodata_suster"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta charset="UTF-8">
            <title>ADD DATA SUSTER</title>
            <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
            <link href='https://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'><link rel="stylesheet" href="#">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
            <style type="text/css">
                html, body, div, span, applet, object, iframe,
                h1, h2, h3, h4, h5, h6, p, blockquote, pre,
                a, abbr, acronym, address, big, cite, code,
                del, dfn, em, img, ins, kbd, q, s, samp,
                small, strike, strong, sub, sup, tt, var,
                b, u, i, center,
                dl, dt, dd, ol, ul, li,
                fieldset, form, label, legend,
                table, caption, tbody, tfoot, thead, tr, th, td,
                article, aside, canvas, details, embed,
                figure, figcaption, footer, header, hgroup,
                menu, nav, output, ruby, section, summary,
                time, mark, audio, video {
                    margin: 0;
                    padding: 0;
                    border: 0;
                    font: inherit;
                    font-size: 100%;
                    vertical-align: baseline;
                }

                html {
                    line-height: 1;
                }

                ol, ul {
                    list-style: none;
                }

                table {
                    border-collapse: collapse;
                    border-spacing: 0;
                }

                caption, th, td {
                    text-align: left;
                    font-weight: normal;
                    vertical-align: middle;
                }

                q, blockquote {
                    quotes: none;
                }
                q:before, q:after, blockquote:before, blockquote:after {
                    content: "";
                    content: none;
                }

                a img {
                    border: none;
                }

                article, aside, details, figcaption, figure, footer, header, hgroup, main, menu, nav, section, summary {
                    display: block;
                }

                /* Colors */
                /* ---------------------------------------- */
                * {
                    -moz-box-sizing: border-box;
                    -webkit-box-sizing: border-box;
                    box-sizing: border-box;
                }

                body {
                    text-align: center;
                    font-family: 'Lato', 'sans-serif';
                    font-weight: 400;
                }

                a {
                    text-decoration: none;
                }

                .info-text {
                    text-align: left;
                    width: 100%;
                }

                header, form {
                    padding: 4em 10%;
                }

                .form-group {
                    margin-bottom: 20px;
                }

                h2.heading {
                    font-size: 18px;
                    text-transform: uppercase;
                    font-weight: 300;
                    text-align: left;
                    color: #506982;
                    border-bottom: 1px solid #506982;
                    padding-bottom: 3px;
                    margin-bottom: 20px;
                }

                .controls {
                    text-align: left;
                    position: relative;
                }
                .controls input[type="text"],
                .controls input[type="email"],
                .controls input[type="number"],
                .controls input[type="date"],
                .controls input[type="tel"],
                .controls textarea,
                .controls button,
                .controls select {
                    padding: 12px;
                    font-size: 14px;
                    border: 1px solid #c6c6c6;
                    width: 100%;
                    margin-bottom: 18px;
                    color: #888;
                    font-family: 'Lato', 'sans-serif';
                    font-size: 16px;
                    font-weight: 300;
                    -moz-border-radius: 2px;
                    -webkit-border-radius: 2px;
                    border-radius: 2px;
                    -moz-transition: all 0.3s;
                    -o-transition: all 0.3s;
                    -webkit-transition: all 0.3s;
                    transition: all 0.3s;
                }
                .controls input[type="text"]:focus, .controls input[type="text"]:hover,
                .controls input[type="email"]:focus,
                .controls input[type="email"]:hover,
                .controls input[type="number"]:focus,
                .controls input[type="number"]:hover,
                .controls input[type="date"]:focus,
                .controls input[type="date"]:hover,
                .controls input[type="tel"]:focus,
                .controls input[type="tel"]:hover,
                .controls textarea:focus,
                .controls textarea:hover,
                .controls button:focus,
                .controls button:hover,
                .controls select:focus,
                .controls select:hover {
                    outline: none;
                    border-color: #9FB1C1;
                }
                .controls input[type="text"]:focus + label, .controls input[type="text"]:hover + label,
                .controls input[type="email"]:focus + label,
                .controls input[type="email"]:hover + label,
                .controls input[type="number"]:focus + label,
                .controls input[type="number"]:hover + label,
                .controls input[type="date"]:focus + label,
                .controls input[type="date"]:hover + label,
                .controls input[type="tel"]:focus + label,
                .controls input[type="tel"]:hover + label,
                .controls textarea:focus + label,
                .controls textarea:hover + label,
                .controls button:focus + label,
                .controls button:hover + label,
                .controls select:focus + label,
                .controls select:hover + label {
                    color: #bdcc00;
                    cursor: text;
                }
                .controls .fa-sort {
                    position: absolute;
                    right: 10px;
                    top: 17px;
                    color: #999;
                }
                .controls select {
                    -moz-appearance: none;
                    -webkit-appearance: none;
                    cursor: pointer;
                }
                .controls label {
                    position: absolute;
                    left: 8px;
                    top: 12px;
                    width: 60%;
                    color: #999;
                    font-size: 16px;
                    display: inline-block;
                    padding: 4px 10px;
                    font-weight: 400;
                    background-color: rgba(255, 255, 255, 0);
                    -moz-transition: color 0.3s, top 0.3s, background-color 0.8s;
                    -o-transition: color 0.3s, top 0.3s, background-color 0.8s;
                    -webkit-transition: color 0.3s, top 0.3s, background-color 0.8s;
                    transition: color 0.3s, top 0.3s, background-color 0.8s;
                    background-color: white;
                }
                .controls label.active {
                    top: -11px;
                    color: #555;
                    background-color: white;
                    width: auto;
                }
                .controls textarea {
                    resize: none;
                    height: 200px;
                }

                button {
                    cursor: pointer;
                    background-color: #1b3d4d;
                    border: none;
                    color: #fff;
                    padding: 12px 0;
                    float: right;
                }
                button:hover {
                    background-color: #224c60;
                }

                .clear:after {
                    content: "";
                    display: table;
                    clear: both;
                }

                .grid {
                    background: white;
                }
                .grid:after {
                    /* Or @extend clearfix */
                    content: "";
                    display: table;
                    clear: both;
                }

                [class*='col-'] {
                    float: left;
                    padding-right: 10px;
                }
                .grid [class*='col-']:last-of-type {
                    padding-right: 0;
                }

                .col-2-3 {
                    width: 66.66%;
                }

                .col-1-3 {
                    width: 33.33%;
                }

                .col-1-2 {
                    width: 50%;
                }

                .col-1-4 {
                    width: 25%;
                }

                @media (max-width: 760px) {
                    .col-1-4-sm, .col-1-3, .col-2-3 {
                        width: 100%;
                    }

                    [class*='col-'] {
                        padding-right: 0px;
                    }
                }
                .col-1-8 {
                    width: 12.5%;
                }

            </style>
        </head>
        <body>
            

            <form method="POST" action="/projectSusteranADM/tambahSuster_" enctype="multipart/form-data">
                <!--  General -->
                <div class="form-group">
                    <h2 class="heading"><b>MINAT DAN BAKAT</b></h2>
                    <div class="controls">
                        <% String idSuster = (String)request.getAttribute("idSuster");%>
                        <input type="text" id="idSuster" class="floatLabel" name="idSuster" value="${idSuster}" maxlength="17" readonly>
                        <label for="idSuster">NIK Suster</label>
                    </div>
                    <div class="field_wrapper">
                        <div>
                            <input type="text" name="minatbakat[]" value="" size="30"/>
                            <a href="javascript:void(0);" class="add_button" title="Add field"><img src="https://img.icons8.com/pastel-glyph/64/000000/plus.png" width="25" height="25"></a>
                        </div>
                    </div>

                    <div class="grid">
                        <button type="submit" value="Submit" class="col-1-4">SELANJUTNYA</button>
                    </div>
                </div> <!-- /.form-group -->

            </form>
            <!-- partial -->
            <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
            <script src='http://raw.githubusercontent.com/andiio/selectToAutocomplete/master/jquery-ui-autocomplete.js'></script>
            <script src='http://raw.githubusercontent.com/andiio/selectToAutocomplete/master/jquery.select-to-autocomplete.js'></script>
            <script src='http://raw.githubusercontent.com/andiio/selectToAutocomplete/master/jquery.select-to-autocomplete.min.js'></script>
            <script>
                (function ($) {
                    function floatLabel(inputType) {
                        $(inputType).each(function () {
                            var $this = $(this);
                            // on focus add cladd active to label
                            $this.focus(function () {
                                $this.next().addClass("active");
                            });
                            //on blur check field and remove class if needed
                            $this.blur(function () {
                                if ($this.val() === '' || $this.val() === 'blank') {
                                    $this.next().removeClass();
                                }
                            });
                        });
                    }
                    // just add a class of "floatLabel to the input field!"
                    floatLabel(".floatLabel");
                })(jQuery);
            </script>
            <script>
                // Add the following code if you want the name of the file appear on select
                $(".custom-file-input").on("change", function () {
                    var fileName = $(this).val().split("\\").pop();
                    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
                });
            </script>
            <script type="text/javascript">
                $(document).ready(function () {
                    var maxField = 10; //Input fields increment limitation
                    var addButton = $('.add_button'); //Add button selector
                    var wrapper = $('.field_wrapper'); //Input field wrapper <img src="https://img.icons8.com/flat_round/64/000000/minus.png">
                    var fieldHTML = '<div><input type="text" name="minatbakat[]" value="" size="30"/><a href="javascript:void(0);" class="remove_button"><img src="https://img.icons8.com/pastel-glyph/64/000000/minus.png" width="25" height="25"></a></div>'; //New input field html 
                    var x = 1; //Initial field counter is 1

                    //Once add button is clicked
                    $(addButton).click(function () {
                        //Check maximum number of input fields
                        if (x < maxField) {
                            x++; //Increment field counter
                            $(wrapper).append(fieldHTML); //Add field html
                        }
                    });

                    //Once remove button is clicked
                    $(wrapper).on('click', '.remove_button', function (e) {
                        e.preventDefault();
                        $(this).parent('div').remove(); //Remove field html
                        x--; //Decrement field counter
                    });
                });
            </script>

        </body>
    </html>
</f:view>
