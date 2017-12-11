<%-- 
    Document   : carta
    Created on : 14/11/2010, 02:40:26 PM
    Author     : cesardl
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<script type="text/javascript">
    $(function() {
        $("#tabs").tabs();
    });
</script>

<div id="tabs">
    <ul>
        <c:forEach var="carta" items="${cartas}">
            <li><a href="#tabs-${carta.idCarta}">${carta.variedad}</a></li>
        </c:forEach>
    </ul>
    <c:forEach var="carta" items="${cartas}">
        <div id="tabs-${carta.idCarta}">
            <table class="tabla_datos" border="1" width="90%" align="center">
                <thead>
                    <tr>
                        <th class="ui-state-default ">Nombre</th>
                        <th class="ui-state-default ">Descripcion</th>
                        <th class="ui-state-default ">Precio</th>
                        <c:if test="${admin_visible}">
                            <th class="ui-state-default " colspan="2">Acciones</th>
                        </c:if>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="var" items="${carta.variedadesCollection}">
                        <tr onmouseover="this.style.backgroundColor='#F1F1F1'" onmouseout="this.style.backgroundColor='#FFFFFF'">
                            <td>${var.nombre}</td>
                            <td>${var.descripcion}</td>
                            <td style="text-align: center;">
                                <fmt:formatNumber value="${var.precio}" pattern="0.00"></fmt:formatNumber>
                            </td>
                            <c:if test="${admin_visible}">
                                <td>Editar</td>
                                <td>Borrar</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </c:forEach>
</div>