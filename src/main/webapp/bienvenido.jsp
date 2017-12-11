<%-- 
    Document   : bienvenido
    Created on : 11/11/2010, 02:56:55 PM
    Author     : cesardl
--%>

<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="styles/jquery.ui/jquery-ui-1.8.2.custom.css">
        <link type="text/css" rel="stylesheet" href="styles/touching/touching.css">
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.2.custom.js"></script>
        <script type="text/javascript" src="js/jquery.ui.core.js"></script>
        <script type="text/javascript" src="js/jquery.ui.widget.js"></script>
        <script type="text/javascript">
            $(function() {
                $("input:submit").button();
            });
        </script>
        <title>Administrador de la polleria</title>
    </head>
    <body>
        <div id="container">
            <div id="banner">
                <div id='bannertitle'>Administrador de la polleria</div>
            </div>

            <div id="outer">
                <div id="left">
                    <div class="verticalmenu">
                        <ul>
                            <li><a href="#" onclick="$('#detalle').load('mantenimiento/principal.jsp')">Principal</a></li>
                            <li><a id="carta" href="#" onclick="$('#detalle').load('carta.servlet');">Carta</a></li>
                            <c:if test="${admin_visible}">
                                <li><a href="#" onclick="$('#detalle').load('mantenimiento/compras.jsp')">Compras</a></li>
                                <li><a href="#" onclick="$('#detalle').load('mantenimiento/usuarios.jsp')">Cuenta Usuario</a></li>
                            </c:if>
                        </ul>
                    </div>
                    <c:if test="${!admin_visible}">
                        <form method="post" action="login.servlet">
                            <table class="formulario">
                                <tr>
                                    <td>
                                        <h2>Iniciar sesi&oacute;n</h2>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Usuario:<br>
                                        <input type="text" id="j_user" name="j_user" value="" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Contrase&ntilde;a:<br>
                                        <input type="password" id="j_passwd" name="j_passwd" value="" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="submit" name="login" value="Aceptar" />
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </c:if>
                </div>
                <div id="content">
                    <c:if test="${admin_visible}">
                        <table width="100%">
                            <tr>
                                <td>
                                    <h1>Bienvenido ${usuario.usuario}</h1>
                                </td>
                                <td align="right">
                                    <a id="logout" class="action" name="logout"
                                       href="login.servlet">Cerrar sesion</a>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <hr class="separator">
                                </td>
                            </tr>
                        </table>
                    </c:if>
                    <div id="detalle" style="padding: 15px;">
                        <jsp:include page="mantenimiento/principal.jsp" flush="true"></jsp:include>
                    </div>
                </div><!-- end content -->
            </div><!-- end outer -->
            <div id="footer">
                <center>
                    <h1>Demo realizada por Cesardl</h1>
                </center>
            </div>
        </div><!-- end container -->
    </body>
</html>